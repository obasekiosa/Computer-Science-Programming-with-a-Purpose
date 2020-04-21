/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Raman {
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        long stop = (long) Math.pow(n, 1.0 / 3) + 1;

        for (long i = 0; i <= stop; i++) {

            long i_cube = i * i * i;
            long j_stop = (long) Math.pow(n - i_cube, 1.0 / 3) + 1;
            for (long j = 0; j <= j_stop; j++) {

                long j_cube = j * j * j;
                for (long k = 0; k <= stop; k++) {

                    long k_cube = k * k * k;
                    long l_stop = (long) Math.pow(n - k_cube, 1.0 / 3) + 1;
                    for (long l = 0; l <= l_stop; l++) {
                        StdOut.println(i + " " + j + " " + k + " " + l);
                        if ((i != k || j != l) && (i != l || j != k)) {
                            long l_cube = l * l * l;
                            if (l_cube + k_cube == n && n == i_cube + j_cube) {
                                StdOut.println(i + " " + j + " " + k + " " + l);
                                StdOut.println(true);
                            }
                        }
                    }
                }
            }
        }
        StdOut.println(false);
    }
}
