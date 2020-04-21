/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {

    private static final int MAX_HOURS = 24;
    private static final int MAX_MINUTES = 60;

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {

        if (h < 0 || h > 23) throw new IllegalArgumentException();

        if (m < 0 || m > 59) throw new IllegalArgumentException();

        this.hours = h;
        this.minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {

        String str = s;

        if (str.length() != 5) throw new IllegalArgumentException();

        if (!str.substring(2, 3).equals(":")) throw new IllegalArgumentException();

        String hrStr = str.substring(0, 2);
        String minStr = str.substring(3);

        if (!(Character.isDigit(hrStr.charAt(0)) && Character.isDigit(hrStr.charAt(1))))
            throw new IllegalArgumentException();

        if (!(Character.isDigit(minStr.charAt(0)) && Character.isDigit(minStr.charAt(1))))
            throw new IllegalArgumentException();

        int hr = Integer.parseInt(str.substring(0, 2));
        int min = Integer.parseInt(str.substring(3));

        if (hr < 0 || hr > 23) throw new IllegalArgumentException();

        if (min < 0 || min > 59) throw new IllegalArgumentException();

        this.hours = hr;
        this.minutes = min;

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String min = "" + this.minutes;
        String hr = "" + this.hours;

        if (this.minutes < 10) {
            min = 0 + min;
        }
        if (this.hours < 10) {
            hr = 0 + hr;
        }

        return hr + ":" + min;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (that == null) throw new IllegalArgumentException();

        if (this.hours < that.hours) return true;
        else if (this.hours == that.hours) return this.minutes < that.minutes;
        else return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        int min = this.minutes + 1;

        this.hours = (this.hours + min / MAX_MINUTES) % MAX_HOURS;
        this.minutes = min % MAX_MINUTES;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();

        int min = this.minutes + delta;

        this.hours = (this.hours + min / MAX_MINUTES) % MAX_HOURS;
        this.minutes = min % MAX_MINUTES;
    }

    // Test client (see below).
    public static void main(String[] args) {

        Clock clock = new Clock(23, 59);
        Clock clock1 = new Clock("23:59");

        StdOut.println(clock + " = " + clock1);

        clock.tic();

        StdOut.println(clock + " < " + clock1 + " is " + clock.isEarlierThan(clock1));

        clock1.toc(5);
        clock.toc(7);

        StdOut.println(clock + " < " + clock1 + " is " + clock.isEarlierThan(clock1));

    }
}
