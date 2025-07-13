package org.ia;

public class Main {

    public static double[][][] baseI = {
            {{0, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 0}, {0}},
            {{1, 1}, {1}}
    };

    public static double[][][] baseII = {
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {1}}
    };

    public static double[][][] baseIII = {
            {{0, 0}, {0}},
            {{0, 1}, {1}},
            {{1, 0}, {1}},
            {{1, 1}, {0}}
    };

    public static double[][][] baseIV = {
            {{0, 0, 0}, {1, 1}},
            {{0, 0, 1}, {0, 1}},
            {{0, 1, 0}, {1, 0}},
            {{0, 1, 1}, {0, 1}},
            {{1, 0, 0}, {1, 0}},
            {{1, 0, 1}, {1, 0}},
            {{1, 1, 0}, {1, 0}},
            {{1, 1, 1}, {1, 0}}
    };

    public static void main(String[] args) {
        // Base E (AND)
        Perceptron perceptronE = new Perceptron(2, 1);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double errE = 0;
            for (int a = 0; a < baseI.length; a++) {
                double[] out = perceptronE.treinar(baseI[a][0], baseI[a][1]);
                errE += Math.abs(out[0] - baseI[a][1][0]);
            }
            System.out.printf("[BASE E] Epoch: %d - Error: %.4f%n", epoch, errE);
        }

        // Base OU (OR)
        Perceptron perceptronOU = new Perceptron(2, 1);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double errOU = 0;
            for (int a = 0; a < baseII.length; a++) {
                double[] out = perceptronOU.treinar(baseII[a][0], baseII[a][1]);
                errOU += Math.abs(out[0] - baseII[a][1][0]);
            }
            System.out.printf("[BASE OU] Epoch: %d - Error: %.4f%n", epoch, errOU);
        }

        // Base XOR
        Perceptron perceptronXOR = new Perceptron(2, 1);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double errXOR = 0;
            for (int a = 0; a < baseIII.length; a++) {
                double[] out = perceptronXOR.treinar(baseIII[a][0], baseIII[a][1]);
                errXOR += Math.abs(out[0] - baseIII[a][1][0]);
            }
            System.out.printf("[BASE XOR] Epoch: %d - Error: %.4f%n", epoch, errXOR);
        }

        // Base Robô
        Perceptron perceptronRobo = new Perceptron(3, 2);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double errROBO = 0;
            for (int a = 0; a < baseIV.length; a++) {
                double[] out = perceptronRobo.treinar(baseIV[a][0], baseIV[a][1]);
                for (int j = 0; j < baseIV[a][1].length; j++) {
                    errROBO += Math.abs(out[j] - baseIV[a][1][j]);
                }
            }
            System.out.printf("[BASE ROBO] Epoch: %d - Error: %.4f%n", epoch, errROBO);
        }
    }
}
