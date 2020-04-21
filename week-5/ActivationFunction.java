/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ActivationFunction {

    public static double heaviside(double x) {

        if (x < 0) {
            return 0.0;
        }
        else if (x > 0) {
            return 1.0;
        }
        else if (x == 0) {
            return 0.5;
        }
        else {
            return Double.NaN;
        }
    }

    public static double sigmoid(double x) {
        return 1.0 / (1 + Math.exp(-x));
    }

    public static double tanh(double x) {

        if (x == Double.MAX_VALUE || x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        else if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
            return -1.0;
        }


        double e_x = Math.exp(x);
        double e_minus_x = Math.exp(-x);

        return (e_x - e_minus_x) / (e_x + e_minus_x);
    }

    public static double softsign(double x) {
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        else if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {

        if (x <= -2) {
            return -1.0;
        }
        else if (x < 0) {
            return x + (x * x) / 4;
        }
        else if (x < 2) {
            return x - (x * x) / 4;
        }
        else if (x >= 2) {
            return 1.0;
        }
        else {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
