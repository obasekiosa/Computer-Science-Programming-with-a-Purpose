/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int max = 0, count = 0, len = dna.length();
        String search_key = "CAG";
        for (int i = 0; i <= len - 3; i++) {
            String compare = dna.substring(i, i + 3);
            if (search_key.equals(compare)) {
                count++;
                i += 2;
            }
            else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        return Math.max(max, count);

    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        int len = s.length();
        char[] output = new char[len];
        int j = -1;
        for (int i = 0; i < len; i++) {
            String str = s.substring(i, i + 1);
            if (!str.trim().isEmpty()) {
                output[++j] = str.charAt(0);
            }
        }
        return new String(output).substring(0, j + 1);
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats > 180) {
            return "not human";
        }
        else if (maxRepeats <= 35) {
            return "normal";
        }
        else if (maxRepeats <= 39) {
            return "high risk";
        }
        else if (maxRepeats <= 180) {
            return "Huntington's";
        }
        else {
            return "null";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);

        String content = in.readAll();
        content = removeWhitespace(content);
        int count = maxRepeats(content);
        StdOut.println("max repeats = " + count);
        StdOut.println(diagnose(count));

    }
}
