/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = Integer.parseInt(args[1]);

        String delimiter = ",";
        int displayLimit = n;
        int animationTime = 50;
        // boolean soundOn = false;
        // int readCount = 0;

        // draw the bar chart
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // if (soundOn) {
        //     StdAudio.loop("piano.wav");
        //     StdAudio.close();
        // }

        String title = in.readLine();
        // readCount++;
        // StdOut.println(title);
        String xAxisLabel = in.readLine();
        // readCount++;
        // StdOut.println(xAxisLabel);
        String source = in.readLine();
        // readCount++;
        // StdOut.println(source);

        BarChart barChart = new BarChart(title, xAxisLabel, source);

        do {
            String empty = in.readLine();
            // readCount++;
            // StdOut.println(empty);
            int size = Integer.parseInt(in.readLine());
            // readCount++;
            Bar[] bars = new Bar[size];

            for (int i = 0; i < size; i++) {
                String input = in.readLine();
                // readCount++;
                // StdOut.println(input);
                String[] line = input.split(delimiter);
                // StdOut.println(line);
                String year = line[0];
                String name = line[1];
                // String country = line[2];
                String value = line[3];
                String category = line[4]; // move up into outer loop

                int intValue = Integer.parseInt(value);
                bars[i] = new Bar(name, intValue, category);
                barChart.setCaption(year);
            }

            Arrays.sort(bars);

            // get top displayLimit bars
            for (int i = 0; i < size && i < displayLimit; i++) {
                Bar temp = bars[size - 1 - i];
                if (temp.getValue() > 0)
                    barChart.add(temp.getName(), temp.getValue(), temp.getCategory());
            }

            // draw the bar chart
            barChart.draw();
            StdDraw.show();
            StdDraw.pause(animationTime);
            StdDraw.clear();
            barChart.reset();
        } while (in.hasNextLine());

        in.readLine();
        // readCount++;
        // StdAudio.close();
        // StdOut.println(readCount);

    }
}
