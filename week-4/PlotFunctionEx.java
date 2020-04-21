/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class PlotFunctionEx {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] x = new double[N + 1];
        double[] y = new double[N + 1];
        StdDraw.setXscale(0, Math.PI);
        StdDraw.setYscale(-2.0, 2.0);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i <= N; i++) {
            x[i] = i * Math.PI / N;
            y[i] = Math.sin(4 * x[i]) + Math.cos(20 * x[i]);
            // StdDraw.point(x[i], y[i]);
        }

        for (int i = 0; i < N; i++) {
            StdDraw.line(x[i], y[i], x[i + 1], y[i + 1]);
        }
        StdDraw.show();
    }
}
