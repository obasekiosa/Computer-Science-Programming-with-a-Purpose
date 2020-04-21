/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {

    private static long coefficient(int n, int k, long[][] mem, int offset) {

        if (n == 0 && k == 0) {
            return 1;
        }
        else if (k < -n || k > n) {
            return 0;
        }
        else if (mem[n][k + offset] != 0) {
            return mem[n][k + offset];
        }
        else {
            mem[n][k + offset] = coefficient(n - 1, k - 1, mem, offset) + coefficient(n - 1, k, mem,
                                                                                      offset)
                    + coefficient(n - 1, k + 1, mem, offset);

            return mem[n][k + offset];
        }
    }

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        int offset = n - k;
        long[][] mem = new long[n + 1][2 * n + 1];

        return coefficient(n, k, mem, offset);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        double start = System.currentTimeMillis() / 1000.0;
        long result = trinomial(n, k);
        double stop = System.currentTimeMillis() / 1000.0;
        StdOut.println(result + " , time taken : " + (stop - start) + " seconds");
    }
}
