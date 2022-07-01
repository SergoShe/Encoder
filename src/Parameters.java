public class Parameters {
    private final String pathWay;
    private final Mode mode;

    public Parameters(String pathWay, Mode mode) {
        this.pathWay = pathWay;
        this.mode = mode;
    }

    public String getPathWay() {
        return pathWay;
    }

    public Mode getMode() {
        return mode;
    }
}