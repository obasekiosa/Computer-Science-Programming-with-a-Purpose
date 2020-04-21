/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        if (k > (n * (n - 1)) / 2) {
            return new int[0];
        }

        if (n == 0) {
            return new int[0];
        }

        int[] permutation = new int[n];
        int[] interted = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        int num_full_reverse = 0;
        long temp_k = k;
        for (int i = 1; i < n; i++) {
            if (temp_k - (n - i) >= 0) {
                num_full_reverse++;
                temp_k -= (n - i);
            }
            else {
                break;
            }
        }

        for (int i = 0; i < num_full_reverse; i++) {
            interted[i] = permutation[n - 1 - i];
        }

        int cut_point = n - 1 - num_full_reverse;
        for (int i = 0; i < cut_point - temp_k; i++) {
            interted[num_full_reverse + i] = permutation[i];
        }


        interted[(int) (n - 1 - temp_k)] = permutation[n - 1 - num_full_reverse];

        for (int i = 0; i < temp_k; i++) {
            interted[n - (int) (temp_k) + i] = permutation[cut_point - (int) temp_k + i];
        }

        return interted;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Integer.parseInt(args[1]);

        // double base = 1.0;
        // for (int i = 0; i < 20; i++) {
        //     double start = System.currentTimeMillis();
        //     int[] result = generate(n, k);
        //     double stop = System.currentTimeMillis();
        //
        //     StdOut.println(
        //             "for n = " + n + " : " + (stop - start) + ", ratio = "
        //                     + (stop - start) / base + ", count = " + count(result));
        //     base = (stop - start > 0.0 ? stop - start : base);
        //     n *= 2;
        // }

        int[] result = generate(n, k);

        for (int i = 0; i < result.length; i++) {
            StdOut.print(result[i] + " ");
        }
        StdOut.println();


    }
}
