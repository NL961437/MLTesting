package earlobe.artificial.Intelligence.Layers;

import earlobe.artificial.Intelligence.Layer;
import earlobe.artificial.Utils.ArrayUtils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FullyConnected implements Layer {
    private double[][] bias;
    private double[][] weights;

    private double[][] input;

    public FullyConnected(int inputSize, int outputSize) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        bias = new double[1][outputSize];
        weights = new double[inputSize][outputSize];
        for (int o = 0; o < outputSize; o++) {
            bias[0][o] = random.nextDouble() - 0.5;
            for (int i = 0; i < inputSize; i++) {
                weights[i][o] = random.nextDouble() - 0.5;
            }
        }
    }

    public double[][] forwardPropagation(double[][] input) {
        this.input = input;
        double[][] dp = ArrayUtils.dotProduct(input, weights); //Do dot product of inputs and weights
        return ArrayUtils.addArrays(dp, bias); // add bias to output
    }

    public double[][] backwardPropagation(double[][] outputError, double learningRate) {
        double[][] inputError = ArrayUtils.dotProduct(outputError, ArrayUtils.transposeArray(weights));
        double[][] weightsError = ArrayUtils.dotProduct(ArrayUtils.transposeArray(input), outputError);

        weights = ArrayUtils.subtractArrays(weights, ArrayUtils.multiplyArraysByValue(weightsError, learningRate));
        bias = ArrayUtils.subtractArrays(bias, ArrayUtils.multiplyArraysByValue(outputError, learningRate));

        return inputError;
    }
}
