/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class Mandelbrot {
    private static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);
        int n = 512;
        // int[][] colorPallet = new int[][] { { 23, 128, 222 }, { 235, 18, 122 }, { 103, 225, 22 } };
        Picture picture = new Picture(n, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                double x0 = xc - size / 2 + size * i / n;
                double y0 = yc - size / 2 + size * j / n;
                Complex z0 = new Complex(x0, y0);
                int ans = mand(z0, 255);
                int gray = 255 - ans;
                Color c = new Color(gray, gray, gray);
                // Color c = new Color(gray, gray % 21, gray % 91);
                // Color c = new Color((int) StdRandom.uniform(0, gray + 1),
                //                     (int) StdRandom.uniform(0, gray + 1),
                //                     (int) StdRandom.uniform(0, gray + 1));
                // int index = 0;
                // for (int k = 0; k < colorPallet.length; k++) {
                //     int bench = 255 / colorPallet.length;
                //     if (ans > bench * (k + 1)) index = k;
                // }
                //
                // // Color c = new Color((colorPallet[index][0] + ans) % 255,
                // //                     (colorPallet[index][1] + ans) % 255,
                // //                     (colorPallet[index][2] + ans) % 255);
                //
                // Color c = new Color(colorPallet[index][0],
                //                     colorPallet[index][1],
                //                     colorPallet[index][2]);
                picture.set(i, n - 1 - j, c);
            }
        picture.show();
    }
}
