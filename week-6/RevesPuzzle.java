/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    private static void hanoiMove(int n, char start, char dest, char ext, int offset) {
        if (n == 0) return;
        hanoiMove(n - 1, start, ext, dest, offset);
        StdOut.println("Move disk " + (n + offset) + " from " + start + " to " + dest);
        hanoiMove(n - 1, ext, dest, start, offset);
    }

    private static void move(int n, char start, char dest, char ext1, char ext2) {

        if (n == 0) return;

        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        //
        // hanoiMove(k, start, ext1, dest, 0);
        move(k, start, ext1, dest, ext2);
        hanoiMove(n - k, start, dest, ext2, k);
        // hanoiMove(k, ext1, dest, start, 0);
        move(k, ext1, dest, start, ext2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        move(n, 'A', 'D', 'B', 'C');
    }
}
