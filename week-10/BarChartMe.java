/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class BarChartMe {

    private final int ARRAY_BASE_SIZE = 100;
    private String title;
    private String xAxisLabel;
    private String dataSource;
    private Bar[] bars;
    private int numberOfBars;
    private String caption;

    private void expandBarStorage() {
        Bar[] temp = new Bar[this.bars.length * 2];
        for (int i = 0; i < this.bars.length; i++) temp[i] = bars[i];
        this.bars = temp;
    }

    // Creates a bar chart with the given title, x-axis label, and data source.
    public BarChartMe(String title, String xAxisLabel, String dataSource) {
        if (title == null || xAxisLabel == null || dataSource == null)
            throw new IllegalArgumentException();
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.dataSource = dataSource;
        this.bars = new Bar[this.ARRAY_BASE_SIZE];
        this.numberOfBars = 0;
    }

    // Sets the caption of this bar chart.
    public void setCaption(String caption) {
        if (caption == null) throw new IllegalArgumentException();
        this.caption = caption;
    }

    // Adds a bar (name, value, category) to this bar chart.
    public void add(String name, int value, String category) {


        if (this.bars.length == numberOfBars) expandBarStorage();

        this.bars[numberOfBars++] = new Bar(name, value, category);
    }

    // Remove all of the bars from this bar chart.
    public void reset() {
        this.bars = new Bar[this.ARRAY_BASE_SIZE];
    }

    // Draws this bar chart to standard draw.
    public void draw() {

    }

    public static void main(String[] args) {

    }
}
