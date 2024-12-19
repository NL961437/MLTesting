package earlobe.artificial.Intelligence;

import earlobe.artificial.Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Layer> layers = new ArrayList<>();

    public void add(Layer layer) {
        layers.add(layer);
    }

    public double[][] runNetwork(double[][][] inputs) {
        int samples = inputs.length;
        double[][] result = new double[inputs.length][1];

        for (int i = 0; i < samples; i++) {
            double[][] output = inputs[i];
            for (Layer layer : layers) {
                output = layer.forwardPropagation(output);
            }
            result[i] = output[0];
        }

        return result;
    }

    public void trainNetwork(double[][][] inputs, double[][][] correctOutputs, int epochs, double learningRate) {
        int samples = inputs.length;
        List<Layer> reversedLayers = reverseLayers(layers);

        for (int i = 0; i < epochs; i++) {
            double err = 0;
            for (int j = 0; j < samples; j++) {
                double[][] output = inputs[j];
                for (Layer layer : layers) {
                    output = layer.forwardPropagation(output);
                }
                err += getLoss(correctOutputs[j], output);

                double[][] error = getLossPrime(correctOutputs[j], output);
                for (Layer layer: reversedLayers) {
                    error = layer.backwardPropagation(error, learningRate);
                }
            }
            err /= samples;
            //System.out.printf("epoch %d/%d   error=%f%n", i+1, epochs, err);
        }
    }


    public static double getLoss(double[][] correctOutput, double[][] output) {
        return ArrayUtils.getArrayMean(ArrayUtils.exponentArrays(ArrayUtils.subtractArrays(correctOutput, output), 2));
    }

    public static double[][] getLossPrime(double[][] correctOutput, double[][] output) {
        return ArrayUtils.divideArraysByValue(
                ArrayUtils.multiplyArraysByValue(
                        ArrayUtils.subtractArrays(output, correctOutput), 2), correctOutput[0].length);
    }

    public static List<Layer> reverseLayers(List<Layer> layers) {
        List<Layer> reverseLayers = new ArrayList<>();
        for (int i = layers.size() - 1; i >= 0; i--) {
            reverseLayers.add(layers.get(i));
        }
        return reverseLayers;
    }
}
