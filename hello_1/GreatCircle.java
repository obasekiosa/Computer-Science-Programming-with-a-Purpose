/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double distance, x_1, x_2, y_1, y_2;
        x_1 = Math.toRadians(Double.parseDouble(args[0]));
        y_1 = Math.toRadians(Double.parseDouble(args[1]));
        x_2 = Math.toRadians(Double.parseDouble(args[2]));
        y_2 = Math.toRadians(Double.parseDouble(args[3]));

        distance = 2 * 6371.0 * Math.asin(Math.sqrt(
                Math.pow(Math.sin((x_2 - x_1) / 2), 2) + Math.cos(x_1) * Math.cos(x_2) * Math
                        .pow(Math.sin((y_2 - y_1) / 2), 2)));
        System.out.println(distance + " kilometers");
    }
}
