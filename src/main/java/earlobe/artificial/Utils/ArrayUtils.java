package earlobe.artificial.Utils;

public final class ArrayUtils {
    public static double[][] dotProduct(final double[][] x, final double[][] y) {
        if (x.length == 0 || y.length == 0) {
            throw new RuntimeException("Arrays must not be empty");
        }

        if (x[0].length != y.length) {
            throw new RuntimeException("Arrays must be same size");
        }

        double[][] z = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++) { // ROW OF X
            for (int j = 0; j < y[0].length; j++) { // COLUMN OF Y
                double prod = 0;
                for (int k = 0; k < x[0].length; k++) { // VALUE
                    prod += x[i][k] * y[k][j];
                }
                z[i][j] = prod;
            }
        }
        return z;
    }

    public static double[][] addArrays(final double[][] x, final double[][] y) {
        if (x.length == 0 || y.length == 0) {
            throw new RuntimeException("Arrays must not be empty");
        }

        if (x[0].length != y[0].length) {
            throw new RuntimeException("Arrays must be same size");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] + y[i][j];
            }
        }
        return z;
    }

    public static double[][] subtractArrays(final double[][] x, final double[][] y) {
        if (x.length == 0 || y.length == 0) {
            throw new RuntimeException("Arrays must not be empty");
        }

        if (x[0].length != y[0].length) {
            throw new RuntimeException("Arrays must be same size");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] - y[i][j];
            }
        }
        return z;
    }

    public static double[][] multiplyArrays(final double[][] x, final double[][] y) {
        if (x.length == 0 || y.length == 0) {
            throw new RuntimeException("Arrays must not be empty");
        }

        if (x[0].length != y[0].length) {
            throw new RuntimeException("Arrays must be same size");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] * y[i][j];
            }
        }
        return z;
    }

    public static double[][] divideArrays(final double[][] x, final double[][] y) {
        if (x.length == 0 || y.length == 0) {
            throw new RuntimeException("Arrays must not be empty");
        }

        if (x[0].length != y[0].length) {
            throw new RuntimeException("Arrays must be same size");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] / y[i][j];
            }
        }
        return z;
    }

    public static double[][] tangentHyperbolicArray(final double[][] x) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = Math.tanh(x[i][j]);
            }
        }
        return z;
    }

    public static double[][] tangentHyperbolicPrimeArray(final double[][] x) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = 1 - Math.pow(Math.tanh(x[i][j]), 2);
            }
        }
        return z;
    }

    public static double[][] divideArraysByValue(final double[][] x, final double y) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] / y;
            }
        }
        return z;
    }

    public static double[][] exponentArrays(final double[][] x, final double y) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = Math.pow(x[i][j], y);
            }
        }
        return z;
    }

    public static double[][] multiplyArraysByValue(final double[][] x, final double y) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x.length][x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[i][j] = x[i][j] * y;
            }
        }
        return z;
    }

    public static double getArrayMean(final double[][] x) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double sum = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                sum += x[i][j];
            }
        }
        return sum / (x.length * x[0].length);
    }

    public static double[][] transposeArray(final double[][] x) {
        if (x.length == 0 || x[0].length == 0) {
            throw new RuntimeException("Array must not be empty");
        }

        double[][] z = new double[x[0].length][x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                z[j][i] = x[i][j];
            }
        }

        return z;
    }
}
