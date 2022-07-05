public class Parameters {
    private final String pathWay;
    private final Mode mode;
    private final Type type;

    public Parameters(String pathWay, Mode mode, Type type) {
        this.pathWay = pathWay;
        this.mode = mode;
        this.type = type;
    }

    public String getPathWay() {
        return pathWay;
    }

    public Mode getMode() {
        return mode;
    }

    public Type getType() {
        return type;
    }
}