public class Checkerboard {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        StdDraw.setScale(0, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
            }
        }
        StdDraw.show();
    }
}
