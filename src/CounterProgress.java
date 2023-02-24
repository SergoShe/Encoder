public class CounterProgress {
    public double value;
    public double length;

    public double getPercent() {
        return value / length * 100;
    }
}
