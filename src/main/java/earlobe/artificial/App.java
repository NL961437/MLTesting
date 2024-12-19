package earlobe.artificial;

import earlobe.artificial.Intelligence.Layers.Activation;
import earlobe.artificial.Intelligence.Layers.FullyConnected;
import earlobe.artificial.Intelligence.Network;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        double[][][] trainInputs = {{{1,1,1}}, {{1,1,0}}, {{1,0,1}}, {{1,0,0}}, {{0,1,1}}, {{0,1,0}}};
        double[][][] trainOutputs = {{{1}}, {{1}}, {{1}}, {{0}}, {{1}}, {{0}}, {{1}}, {{0}}};

        double[][][] actualInputs = {{{0,0,1}}, {{0,0,0}}};
        double[][][] actualOutputs = {{{1}}, {{0}}};

        Network network = new Network();
        network.add(new FullyConnected(3, 20));
        network.add(new Activation());
        network.add(new FullyConnected(20, 20));
        network.add(new Activation());
        network.add(new FullyConnected(20, 20));
        network.add(new Activation());
        network.add(new FullyConnected(20, 20));
        network.add(new Activation());
        network.add(new FullyConnected(20, 1));
        network.add(new Activation());

        network.trainNetwork(trainInputs, trainOutputs, 100000, 0.1);

        double[][] out = network.runNetwork(actualInputs);
        System.out.println(Arrays.deepToString(out));
    }
}
