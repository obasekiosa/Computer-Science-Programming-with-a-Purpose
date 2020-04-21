/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]), trails = Integer.parseInt(args[1]);
        int[] total_occurance_of_number_of_persons_before_duplicate_birthday = new int[n + 1];
        for (int i = 0; i < trails; i++) {
            int person_number = 1;
            boolean[] room = new boolean[n];
            while (true) {
                int birthday = (int) (Math.random() * n);
                if (room[birthday]) {
                    total_occurance_of_number_of_persons_before_duplicate_birthday[person_number
                            - 1]++;
                    break;
                }
                else {
                    room[birthday] = true;
                }
                person_number++;
            }
        }

        double sum = 0;
        for (int j = 0; j < total_occurance_of_number_of_persons_before_duplicate_birthday.length
                && sum / trails < 0.5;
             j++) {
            sum += total_occurance_of_number_of_persons_before_duplicate_birthday[j];
            System.out.format("%-8d%-8d%-8f%n", j + 1,
                              total_occurance_of_number_of_persons_before_duplicate_birthday[j],
                              sum / trails);
        }
    }
}
