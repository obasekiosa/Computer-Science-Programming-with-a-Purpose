/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]), k = Integer
                .parseInt(args[2]);

        char[][] field = new char[m][n];

        for (int i = 0; i < k; i++) {
            int row, col;
            do {
                row = (int) (Math.random() * m);
                col = (int) (Math.random() * n);
            } while (field[row][col] == '*');
            field[row][col] = '*';
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (field[row][col] != '*') {
                    int sum = 0, top_row = row - 1, bottom_row = row + 1,
                            right_col = col + 1, left_col = col - 1;

                    if (top_row >= 0 && left_col >= 0 && field[top_row][left_col] == '*') {
                        sum += 1;
                    }
                    if (top_row >= 0 && field[top_row][col] == '*') {
                        sum += 1;
                    }
                    if (top_row >= 0 && right_col < n && field[top_row][right_col] == '*') {
                        sum += 1;
                    }
                    if (left_col >= 0 && field[row][left_col] == '*') {
                        sum += 1;
                    }
                    if (right_col < n && field[row][right_col] == '*') {
                        sum += 1;
                    }
                    if (bottom_row < m && left_col >= 0 && field[bottom_row][left_col] == '*') {
                        sum += 1;
                    }
                    if (bottom_row < m && field[bottom_row][col] == '*') {
                        sum += 1;
                    }
                    if (bottom_row < m && right_col < n && field[bottom_row][right_col] == '*') {
                        sum += 1;
                    }

                    int decimal = 10;
                    field[row][col] = Character.forDigit(sum, decimal);
                }

                if (col == n - 1) {
                    System.out.println(field[row][col]);
                }
                else {
                    System.out.print(field[row][col] + "  ");
                }
            }
        }
    }
}
