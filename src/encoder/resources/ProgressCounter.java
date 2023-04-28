package encoder.resources;

public class ProgressCounter {
    private double value;
    private double length;

    public void increaseValue() {
        value++;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPercent() {
        return value / length * 100;
    }
}
