/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double new_sound[] = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            new_sound[i] = alpha * a[i];
        }

        return new_sound;
    }

    public static double[] normalize(double[] a) {
        double new_sound[] = new double[a.length];

        return new_sound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double new_sound[] = new double[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            new_sound[a.length - i - 1] = a[i];
        }

        return new_sound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {

        double new_sound[] = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            new_sound[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            new_sound[a.length + i] = b[i];
        }

        return new_sound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        int max_length = (a.length > b.length ? a.length : b.length);

        double new_sound[] = new double[max_length];

        for (int i = 0; i < max_length; i++) {
            if (a.length == max_length) {
                if (i >= b.length) {
                    new_sound[i] = a[i];
                }
                else {
                    new_sound[i] = a[i] + b[i];
                }
            }
            else {
                if (i >= a.length) {
                    new_sound[i] = b[i];
                }
                else {
                    new_sound[i] = a[i] + b[i];
                }
            }

        }

        return new_sound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int length = (int) (a.length / alpha);

        double[] new_sound = new double[length];

        for (int i = 0; i < length; i++) {
            new_sound[i] = a[(int) (alpha * i)];
        }

        return new_sound;
    }

    public static void main(String[] args) {
        double[] input = StdAudio.read("singer.wav");
        double[] second_input = StdAudio.read("harp.wav");
        double[] third_input = StdAudio.read("piano.wav");
        double[] fourth_input = StdAudio.read("beatbox.wav");
        double[] fifth_input = StdAudio.read("chimes.wav");
        double[] output = changeSpeed(input, 1.5);
        output = mix(output, second_input);
        output = merge(output, fifth_input);
        output = mix(second_input, output);
        output = merge(fourth_input, output);
        output = amplify(output, 0.6);
        output = reverse(output);
        output = mix(third_input, output);
        output = reverse(output);
        output = merge(third_input, output);
        output = amplify(output, 0.05);
        output = reverse(output);

        StdAudio.play(output);
    }
}
