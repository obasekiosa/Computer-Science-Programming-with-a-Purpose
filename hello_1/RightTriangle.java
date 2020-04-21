/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a, b, c;
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        c = Integer.parseInt(args[2]);
        boolean is_all_positive = a > 0 && b > 0 && c > 0;
        boolean is_right_triangle1 = Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2);
        boolean is_right_triangle2 = Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2);
        boolean is_right_triangle3 = Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2);
        boolean is_right_triangle = is_all_positive && (is_right_triangle1 || is_right_triangle2
                || is_right_triangle3);
        System.out.println(is_right_triangle);
    }
}
