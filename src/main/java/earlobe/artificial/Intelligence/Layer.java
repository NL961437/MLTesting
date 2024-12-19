package earlobe.artificial.Intelligence;

public interface Layer {
    public double[][] forwardPropagation(double[][] input);

    public double[][] backwardPropagation(double[][] outputError, double learningRate);
}
