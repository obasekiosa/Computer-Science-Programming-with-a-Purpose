/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]), sequence_length = args.length - 1;
        int[] cumulative_sum = new int[sequence_length + 1];
        for (int i = 1; i < sequence_length + 1; i++) {
            cumulative_sum[i] = cumulative_sum[i - 1] + Integer.parseInt(args[i]);
        }

        for (int index = 0; index < m; index++) {
            int r = (int) (Math.random() * cumulative_sum[cumulative_sum.length - 1]);
            for (int i = 1; i < cumulative_sum.length; i++) {
                if (r >= cumulative_sum[i - 1] && r < cumulative_sum[i]) {
                    if (index == m - 1) {
                        System.out.println(i);
                    }
                    else {
                        System.out.print(i + " ");
                    }
                }
            }
        }
    }
}
