/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int x, y, direction, steps;
        double average_steps = 0;
        for (int n = 0; n < trials; n++) {
            x = 0;
            y = 0;
            steps = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
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
            average_steps += steps;
        }
        if (trials != 0) {
            average_steps /= trials;
        }
        System.out.println("average number of steps = " + average_steps);
    }
}
