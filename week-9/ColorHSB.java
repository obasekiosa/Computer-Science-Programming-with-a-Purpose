/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    private int hue;
    private int saturation;
    private int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h > 359 || h < 0) throw new IllegalArgumentException();

        if (s > 100 || s < 0) throw new IllegalArgumentException();

        if (b > 100 || b < 0) throw new IllegalArgumentException();

        this.hue = h;
        this.saturation = s;
        this.brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + this.hue + ", " + this.saturation + ", " + this.brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (this.brightness == 0 || this.saturation == 0) {
            return true;
        }
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException();

        return (int) (Math.min(Math.pow(this.hue - that.hue, 2),
                               Math.pow(360 - Math.abs(this.hue - that.hue), 2)) +
                Math.pow(this.saturation - that.saturation, 2) +
                Math.pow(this.brightness - that.brightness, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color = new ColorHSB(h, s, b);
        int minDistance = -1;
        ColorHSB closestColor = null;
        String closestColorName = null;

        while (!StdIn.isEmpty()) {
            String colorInName = StdIn.readString();
            int hIn = StdIn.readInt();
            int sIn = StdIn.readInt();
            int bIn = StdIn.readInt();
            ColorHSB colorHSBIn = new ColorHSB(hIn, sIn, bIn);

            int distance = color.distanceSquaredTo(colorHSBIn);

            // StdOut.println(colorInName + colorHSBIn + ", " + distance);
            if (distance < minDistance || minDistance == -1) {
                closestColor = colorHSBIn;
                closestColorName = colorInName;
                minDistance = distance;
            }
        }

        StdOut.println(closestColorName + " " + closestColor);

    }
}
