import java.nio.file.Path;

public class ParametersBuilder {

    public static Parameters build(final String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: parameter(s) not entry\nRequired parameters: pathWay, mode");
        }

        final String pathWay = String.valueOf(Path.of(args[0]).toAbsolutePath());
        final String mode = args[1].toLowerCase();
        final Mode modeName = switch (mode) {
            case "coding" -> Mode.CODING;
            case "decoding" -> Mode.DECODING;
            default -> throw new IllegalArgumentException("Error: mode is not found");
        };
        return new Parameters(pathWay, modeName);
    }
}