/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n <= 0) {
            System.out.println();
            return;
        }

        int[] sequence = new int[1];
        while (sequence.length < n) {
            int[] new_sequence = new int[2 * sequence.length];
            for (int i = 0, len = sequence.length; i < len; i++) {
                new_sequence[i] = sequence[i];
                if (sequence[i] == 0) {
                    new_sequence[sequence.length + i] = 1;
                }
                else {
                    new_sequence[sequence.length + i] = 0;
                }
            }
            sequence = new_sequence;
        }

        int len = sequence.length;
        char[][] visulaize = new char[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (sequence[i] == sequence[j]) {
                    visulaize[i][j] = '+';
                    visulaize[j][i] = '+';
                }
                else {
                    visulaize[i][j] = '-';
                    visulaize[j][i] = '-';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(visulaize[i][j] + "\n");
                }
                else {
                    System.out.print(visulaize[i][j] + "  ");
                }
            }
        }
    }
}
