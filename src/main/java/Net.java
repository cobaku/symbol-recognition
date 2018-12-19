import java.util.concurrent.ThreadLocalRandom;

public class Net {

    private static final short HIDDEN_LAYER_NEURONS = 19;
    private static final short OUTPUT_NEURONS = 4;
    private static final double TEACH_SPEED = 0.2;
    private static final short KNOWN_SYMBOLS_COUNT = 16;
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

    private double sigmoid(double u) {
        return 1 / (1 + Math.exp(-u));
    }

    public void train() {

        int start;
        int end;
        int iterator;
        double sum = 0;

        for (int i = 0; i < INPUT_NEURONS * HIDDEN_LAYER_NEURONS; i++) {
            weight_input[i] = ThreadLocalRandom.current().nextDouble(-1, 1);
        }

        for (int i = 0; i < OUTPUT_NEURONS * HIDDEN_LAYER_NEURONS; i++) {
            weight_hidden[i] = ThreadLocalRandom.current().nextDouble(-1, 1);
        }

        for (int i = 0; i < 5000; i++) {
            for (int n = 0; n < KNOWN_SYMBOLS_COUNT; n++) {
                switch (n) {
                    case 0: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_0[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 1: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_1[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 2: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_2[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 3: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_3[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 4: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_4[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 5: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_5[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 6: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_6[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 7: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_7[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 8: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_8[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 9: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_9[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 10: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_A[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 11: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_B[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 12: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_C[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 13: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_D[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 14: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_E[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 15: {
                        for (int s = 0; s < INPUT_NEURONS; s++) {
                            inputArray[s] = DummyDataset.symbol_F[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                }

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
            }
        }
    }

    public void predict(boolean[] input) {
        double sum = 0;

        System.arraycopy(input, 0, inputArray, 0, INPUT_NEURONS);

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

        inputSymbol(INPUT_NEURONS, inputArray);
        outputSymbol(OUTPUT_NEURONS, outputArray);
    }

    private static void outputSymbol(short outputNeurons, double[] output) {
        System.out.print("\nЗначения на выходных нейронах: \n");
        for (int j = 0; j < outputNeurons; j++) {
            System.out.print(output[j] + " ");
        }

        System.out.print("\n<=#=><=#=><=#=>\n\n");
        System.out.print("\nПолученный символ: \n");
        if (output[0] < 0.2) {
            if (output[1] < 0.2) {
                if (output[2] < 0.2) {
                    if (output[3] < 0.2)
                        System.out.print("It's 0 \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's 1 \n");
                } else if (output[2] >= 0.8) {
                    if (output[3] < 0.2)
                        System.out.print("It's 2 \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's 3 \n");
                }
            } else if (output[1] >= 0.8) {
                if (output[2] < 0.2) {
                    if (output[3] < 0.2)
                        System.out.print("It's 4 \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's 5 \n");
                } else if (output[2] >= 0.8) {
                    if (output[3] < 0.2)
                        System.out.print("It's 6 \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's 7 \n");
                }
            }
        } else if (output[0] >= 0.8) {
            if (output[1] < 0.2) {
                if (output[2] < 0.2) {
                    if (output[3] < 0.2)
                        System.out.print("It's 8 \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's 9 \n");
                } else if (output[2] >= 0.8) {
                    if (output[3] < 0.2)
                        System.out.print("It's A \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's B \n");
                }
            } else if (output[1] >= 0.8) {
                if (output[2] < 0.2) {
                    if (output[3] < 0.2)
                        System.out.print("It's C \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's D \n");
                } else if (output[2] >= 0.8) {
                    if (output[3] < 0.2)
                        System.out.print("It's E \n");
                    else if (output[3] >= 0.8)
                        System.out.print("It's F \n");
                }
            }
        }
    }

    private static void inputSymbol(short inputNeurons, boolean[] input) {
        System.out.print("Введенный символ:");
        for (int j = 0; j < inputNeurons; j++) {
            if (j % 5 == 0) System.out.print("");

            if (input[j]) System.out.print("$");

            else System.out.print(" ");
        }
    }

    private static int boolToInt(boolean boolVariable) {
        return boolVariable ? 1 : 0;
    }
}
