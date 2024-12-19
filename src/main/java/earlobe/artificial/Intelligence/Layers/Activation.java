package earlobe.artificial.Intelligence.Layers;

import earlobe.artificial.Intelligence.Layer;
import earlobe.artificial.Utils.ArrayUtils;

public class Activation implements Layer {
    private double[][] input;

    public double[][] forwardPropagation(double[][] input) {
        this.input = input;
        return ArrayUtils.tangentHyperbolicArray(input);
    }

    public double[][] backwardPropagation(double[][] outputError, double learningRate) {
        return ArrayUtils.multiplyArrays(ArrayUtils.tangentHyperbolicPrimeArray(input), outputError);
    }
}
