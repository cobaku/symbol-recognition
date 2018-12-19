import java.util.concurrent.ThreadLocalRandom;

public class Net {

    private static boolean[] symbol_0 = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_1 = {
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true
    };

    private static boolean[] symbol_2 = {
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    private static boolean[] symbol_3 = {
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_4 = {
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true
    };

    private static boolean[] symbol_5 = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_6 = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_7 = {
            false, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true,
            false, false, false, false, true
    };

    private static boolean[] symbol_8 = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_9 = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_A = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true
    };

    private static boolean[] symbol_B = {
            true, true, true, true, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, false,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_C = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    private static boolean[] symbol_D = {
            true, true, true, true, false,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, true, true, true, true
    };

    private static boolean[] symbol_E = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true
    };

    private static boolean[] symbol_F = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false
    };

    private static boolean[] symbol_testD = {
            true, true, true, true, false,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, false, false, true,
            true, false, true, false, false
    };

    private static boolean[] symbol_testC = {
            true, true, true, true, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, true, true, true
    };

    private static boolean[] symbol_test2 = {
            true, true, true, true, true,
            false, false, false, false, true,
            false, false, false, false, true,
            true, true, true, false, true,
            true, false, false, false, false,
            true, false, false, false, false,
            true, false, true, false, true
    };

    double Sigmoid(double u) {
        return 1 / (1 + Math.exp(-u));
    }

    /// Обучение
    public void Learn() {

        // Число скрытых нейронов
        final short hiddenNeurons = 19;

        // Число выходных нейронов
        final short outputNeurons = 4;

        // Скорость обучение
        double teachSpeed = 0.2;

        // Число распознаваемых символов 
        short symbolNumber = 16;

        // Массив входов
        final short inputNeurons = 35;
        boolean[] inputArray = new boolean[inputNeurons];

        // Ожидаемые значения
        boolean[] expectedOutput = new boolean[outputNeurons];

        //Веса входного слоя
        double[] weight_input = new double[inputNeurons * hiddenNeurons];
        //Веса скрытого слоя
        double[] weight_hidden = new double[hiddenNeurons * outputNeurons];

        int start;
        int end;
        int iterator;
        double sum = 0;
        //Массив выходных нейронов
        double[] outputArray = new double[outputNeurons];
        //Массив скрытых нейронов
        double[] hiddenArray = new double[hiddenNeurons];
        //Ошибка 
        double[] outputError = new double[outputNeurons];
        //Ошибка скрытых нейронов
        double[] hiddenError = new double[hiddenNeurons];

        for (int i = 0; i < inputNeurons * hiddenNeurons; i++) {
            weight_input[i] = (double) (ThreadLocalRandom.current().nextInt() % 100) / 100;
        }

        for (int i = 0; i < outputNeurons * hiddenNeurons; i++) {
            weight_hidden[i] = (double) (ThreadLocalRandom.current().nextInt() % 100) / 100;
        }

        for (int i = 0; i < 5000; i++) {
            for (int n = 0; n < symbolNumber; n++) {
                switch (n) {
                    case 0: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_0[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 1: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_1[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 2: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_2[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 3: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_3[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 4: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_4[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 5: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_5[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 6: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_6[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 7: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_7[s];
                            expectedOutput[0] = false;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 8: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_8[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 9: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_9[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 10: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_A[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 11: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_B[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = false;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 12: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_C[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 13: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_D[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = false;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                    case 14: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_E[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = false;
                        }

                        break;
                    }
                    case 15: {
                        for (int s = 0; s < inputNeurons; s++) {
                            inputArray[s] = symbol_F[s];
                            expectedOutput[0] = true;
                            expectedOutput[1] = true;
                            expectedOutput[2] = true;
                            expectedOutput[3] = true;
                        }

                        break;
                    }
                }

                start = 0;

                end = inputNeurons;

                for (int j = 0; j < hiddenNeurons; j++) {
                    for (int k = start; k < end; k++) {
                        sum += BoolToInt(inputArray[k - start]) * weight_input[k];
                    }

                    hiddenArray[j] = Sigmoid(sum);

                    start += inputNeurons;
                    end += inputNeurons;
                    sum = 0;
                    hiddenError[j] = 0;
                }

                start = 0;
                end = hiddenNeurons;

                for (int j = 0; j < outputNeurons; j++) {
                    for (int k = start; k < end; k++) {
                        sum += hiddenArray[k - start] * weight_hidden[k];
                    }

                    outputArray[j] = Sigmoid(sum);
                    outputError[j] = BoolToInt(expectedOutput[j]) - outputArray[j];
                    for (int k = start; k < end; k++) {
                        weight_hidden[k] += teachSpeed * outputError[j] * hiddenArray[k - start] * (1 - Sigmoid(sum)) *
                                Sigmoid(sum);
                    }

                    start += hiddenNeurons;
                    end += hiddenNeurons;
                    sum = 0;
                }

                start = 0;
                end = inputNeurons;

                for (int j = 0; j < hiddenNeurons; j++) {
                    for (int k = start; k < end; k++) {
                        sum += BoolToInt(inputArray[k - start]) * weight_input[k];
                    }

                    iterator = j;

                    for (int k = 0; k < outputNeurons; k++) {
                        hiddenError[j] += outputError[k] * weight_hidden[iterator];
                        iterator += hiddenNeurons;
                    }

                    for (int k = start; k < end; k++) {
                        weight_input[k] += teachSpeed * hiddenError[j] * BoolToInt(inputArray[k - start]) * (1 - Sigmoid(sum)) * Sigmoid(sum);
                    }

                    start += inputNeurons;
                    end += inputNeurons;
                    sum = 0;
                }
            }
        }

        System.out.print("Обучение завершено. Введите символ. \n");

        for (int j = 0; j < inputNeurons; j++) {
            //////symbol_testD
            /// symbol_testC
            /// symbol_test2
            inputArray[j] = symbol_testC[j];
        }

        start = 0;
        end = inputNeurons;

        for (int j = 0; j < hiddenNeurons; j++) {
            for (int k = start; k < end; k++) {
                sum += BoolToInt(inputArray[k - start]) * weight_input[k];
            }

            hiddenArray[j] = Sigmoid(sum);
            start += inputNeurons;
            end += inputNeurons;
            sum = 0;
        }

        start = 0;
        end = hiddenNeurons;

        for (int j = 0; j < outputNeurons; j++) {
            for (int k = start; k < end; k++) {
                sum += hiddenArray[k - start] * weight_hidden[k];
            }

            outputArray[j] = Sigmoid(sum);
            start += hiddenNeurons;
            end += hiddenNeurons;
            sum = 0;
        }

        InputSymbol(inputNeurons, inputArray);
        OutputSymbol(outputNeurons, outputArray);
    }

    private static void OutputSymbol(short outputNeurons, double[] output) {
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

    private static void InputSymbol(short inputNeurons, boolean[] input) {
        System.out.print("Введенный символ:");
        for (int j = 0; j < inputNeurons; j++) {
            if (j % 5 == 0) System.out.print("");

            if (input[j]) System.out.print("$");

            else System.out.print(" ");
        }
    }

    private static int BoolToInt(boolean boolVariable) {
        return boolVariable ? 1 : 0;
    }
}
