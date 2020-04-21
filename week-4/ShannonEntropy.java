
public class ShannonEntropy {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double entropy = 0.0;
        int[] count = new int[N];
        int data_length = 0;
        while (!StdIn.isEmpty()){
            count[StdIn.readInt() - 1]++;
            data_length++;
        }
        for (int i = 0; i < N; i++) {
            if (count[i] == 0) {
                continue;
            }
            // StdOut.println(count[i]);
            double proportion = (1.0*count[i])/data_length;
            // StdOut.println(proportion);
            entropy += proportion * Math.log(proportion)/Math.log(2);
        }
        StdOut.printf("%.4f", (entropy != 0 ? -entropy:entropy));
    }
}
