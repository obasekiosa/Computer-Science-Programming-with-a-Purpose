/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        if (a.length == 0) return 0;

        int[][] sum = new int[a.length][a.length];

        int max = a[0][0];
        sum[0][0] = a[0][0];
        for (int i = 1; i < a.length; i++) {
            sum[0][i] = a[0][i];
            sum[i][0] = a[i][0];
            max = Math.max(max, Math.max(sum[0][i], sum[i][0]));
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] == 1) {
                    sum[i][j] = Math.min(Math.min(sum[i - 1][j], sum[i][j - 1]), sum[i - 1][j - 1])
                            + 1;
                    max = Math.max(max, sum[i][j]);
                }
                else {
                    sum[i][j] = 0;
                }
            }
        }

        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();

        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = StdIn.readInt();
            }
        }

        StdOut.println(size(array));
    }
}
