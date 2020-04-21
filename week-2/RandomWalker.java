/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int x = 0, y = 0, direction, steps = 0;
        while (Math.abs(x) + Math.abs(y) < r) {
            System.out.println("(" + x + ", " + y + ")");
            direction = (int) (4 * Math.random());

            if (direction == 0) {
                y += 1;
            }
            else if (direction == 1) {
                x += 1;
            }
            else if (direction == 2) {
                y -= 1;
            }
            else {
                x -= 1;
            }
            steps++;
        }

        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
