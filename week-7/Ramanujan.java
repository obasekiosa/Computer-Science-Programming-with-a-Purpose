/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        long stop = (long) Math.pow(n, 1.0 / 3) + 1;
        long i = 0, j = 0, k = 0, l = 0;


        boolean found = false;
        for (i = 0; i <= stop; i++) {
            long i_cube = i * i * i;
            long remainder = n - i_cube;
            j = (long) Math.pow(remainder, 1.0 / 3) + 1;
            if (remainder == j * j * j) {
                found = true;
                break;
            }
        }

        if (!found) return false;
        else found = false;

        for (k = i + 1; k <= stop; k++) {
            long k_cube = k * k * k;
            long remainder = n - k_cube;
            l = (long) Math.pow(remainder, 1.0 / 3) + 1;

            if (remainder == l * l * l) {
                // StdOut.println(i + ", " + j + "\n" + k + ", " + l);
                found = true;
                break;
            }
        }

        if (i == l) {
            return false;
        }

        return found;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        // StdOut.println(n);

        StdOut.println(isRamanujan(n));

    }
}
