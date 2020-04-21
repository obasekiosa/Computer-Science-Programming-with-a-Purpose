public class WorldMap {
    public static void main(String[] args) {
        int xMax = StdIn.readInt();
        int yMax = StdIn.readInt();
        StdDraw.setCanvasSize(xMax, yMax);
        StdDraw.setXscale(0, xMax);
        StdDraw.setYscale(0, yMax);

        while(!StdIn.isEmpty()) {
            String regionName = StdIn.readString();
            int numPoints = StdIn.readInt();
            double[][] points = new double[2][numPoints];
            for (int i = 0; i < numPoints; i++) {
                points[0][i] = StdIn.readDouble();
                points[1][i] = StdIn.readDouble();
            }
            StdDraw.polygon(points[0], points[1]);
        }
        StdDraw.show();
    }
}
