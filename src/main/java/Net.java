import java.util.concurrent.ThreadLocalRandom;

public class Net {

    private static final short HIDDEN_LAYER_NEURONS = 19;
    private static final int OUTPUT_NEURONS = DummyDataset.DATASET.size();
    private static final double TEACH_SPEED = 0.2;
    private static final short INPUT_NEURONS = 35;

    // Значения на входе
    private boolean[] inputArray = new boolean[INPUT_NEURONS];
    // Ожидаемые значения
    private static final boolean[] expectedOutput = new boolean[OUTPUT_NEURONS];
    //Веса входного слоя
    private static final double[] weight_input = new double[INPUT_NEURONS * HIDDEN_LAYER_NEURONS];
    //Веса скрытого слоя
    private static final double[] weight_hidden = new double[HIDDEN_LAYER_NEURONS * OUTPUT_NEURONS];
    //Массив выходных нейронов
    private static final double[] outputArray = new double[OUTPUT_NEURONS];
    //Массив скрытых нейронов
    private static final double[] hiddenArray = new double[HIDDEN_LAYER_NEURONS];
    //Ошибка
    private static final double[] outputError = new double[OUTPUT_NEURONS];
    //Ошибка скрытых нейронов
    private static final double[] hiddenError = new double[HIDDEN_LAYER_NEURONS];

    public Net() {
        for (int i = 0; i < INPUT_NEURONS * HIDDEN_LAYER_NEURONS; i++) {
            weight_input[i] = ThreadLocalRandom.current().nextDouble(-1, 1);
        }

        for (int i = 0; i < OUTPUT_NEURONS * HIDDEN_LAYER_NEURONS; i++) {
            weight_hidden[i] = ThreadLocalRandom.current().nextDouble(-1, 1);
        }
    }

    private double sigmoid(double u) {
        return 1 / (1 + Math.exp(-u));
    }

    public void train() {

        for (int i = 0; i < 5000; i++) {
            DummyDataset.DATASET.forEach((symbolName, symbolMap) -> {
                inputArray = symbolMap;
                setOutputValue(symbolName);

                int start;
                int end;
                int iterator;
                double sum = 0;

                start = 0;

                end = INPUT_NEURONS;

                for (int j = 0; j < HIDDEN_LAYER_NEURONS; j++) {
                    for (int k = start; k < end; k++) {
                        sum += boolToInt(inputArray[k - start]) * weight_input[k];
                    }

                    hiddenArray[j] = sigmoid(sum);

                    start += INPUT_NEURONS;
                    end += INPUT_NEURONS;
                    sum = 0;
                    hiddenError[j] = 0;
                }

                start = 0;
                end = HIDDEN_LAYER_NEURONS;

                for (int j = 0; j < OUTPUT_NEURONS; j++) {
                    for (int k = start; k < end; k++) {
                        sum += hiddenArray[k - start] * weight_hidden[k];
                    }

                    outputArray[j] = sigmoid(sum);
                    outputError[j] = boolToInt(expectedOutput[j]) - outputArray[j];
                    for (int k = start; k < end; k++) {
                        weight_hidden[k] += TEACH_SPEED * outputError[j] * hiddenArray[k - start] * (1 - sigmoid(sum)) *
                                sigmoid(sum);
                    }

                    start += HIDDEN_LAYER_NEURONS;
                    end += HIDDEN_LAYER_NEURONS;
                    sum = 0;
                }

                start = 0;
                end = INPUT_NEURONS;

                for (int j = 0; j < HIDDEN_LAYER_NEURONS; j++) {
                    for (int k = start; k < end; k++) {
                        sum += boolToInt(inputArray[k - start]) * weight_input[k];
                    }

                    iterator = j;

                    for (int k = 0; k < OUTPUT_NEURONS; k++) {
                        hiddenError[j] += outputError[k] * weight_hidden[iterator];
                        iterator += HIDDEN_LAYER_NEURONS;
                    }

                    for (int k = start; k < end; k++) {
                        weight_input[k] += TEACH_SPEED * hiddenError[j] * boolToInt(inputArray[k - start]) * (1 - sigmoid(sum)) * sigmoid(sum);
                    }

                    start += INPUT_NEURONS;
                    end += INPUT_NEURONS;
                    sum = 0;
                }
            });
        }
    }

    public DummyDataset.SymbolName predict(boolean[] input) {
        double sum = 0;
        inputArray = input;

        int start = 0;
        int end = INPUT_NEURONS;

        for (int j = 0; j < HIDDEN_LAYER_NEURONS; j++) {
            for (int k = start; k < end; k++) {
                sum += boolToInt(inputArray[k - start]) * weight_input[k];
            }

            hiddenArray[j] = sigmoid(sum);
            start += INPUT_NEURONS;
            end += INPUT_NEURONS;
            sum = 0;
        }

        start = 0;
        end = HIDDEN_LAYER_NEURONS;

        for (int j = 0; j < OUTPUT_NEURONS; j++) {
            for (int k = start; k < end; k++) {
                sum += hiddenArray[k - start] * weight_hidden[k];
            }

            outputArray[j] = sigmoid(sum);
            start += HIDDEN_LAYER_NEURONS;
            end += HIDDEN_LAYER_NEURONS;
            sum = 0;
        }

        return outputSymbol(outputArray);
    }

    private DummyDataset.SymbolName outputSymbol(double[] output) {
        System.out.print("\nЗначения на выходных нейронах: \n");
        for (int j = 0; j < output.length; j++) {
            System.out.printf("Выход №%s. Значение не выходе: %s \n", j, output[j]);
        }

        final DummyDataset.SymbolName symbolName = DummyDataset.SymbolName.byNumber(findMaximumIndexInArray(output));

        System.out.printf("\nПолученный символ: %s\n", symbolName.name());
        return symbolName;
    }

    private int boolToInt(boolean boolVariable) {
        return boolVariable ? 1 : 0;
    }

    private void setOutputValue(DummyDataset.SymbolName symbolName) {
        for (int i = 0; i < expectedOutput.length; i++) {
            expectedOutput[i] = false;
        }

        expectedOutput[symbolName.ordinal()] = true;
    }

    private static int findMaximumIndexInArray(double[] array) {
        int maxAt = 0;

        for (int i = 0; i < array.length; i++) {
            maxAt = array[i] > array[maxAt] ? i : maxAt;
        }

        return maxAt;
    }
}
