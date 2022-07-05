import java.nio.file.Path;

public class ParametersBuilder {

    public static Parameters build(final String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: parameter(s) not entry\nRequired parameters: pathWay, mode, type");
        }

        final String pathWay = String.valueOf(Path.of(args[0]).toAbsolutePath());
        final String mode = args[1].toLowerCase();
        final String type = args[2].toLowerCase();
        final Mode modeName = switch (mode) {
            case "coding" -> Mode.CODING;
            case "decoding" -> Mode.DECODING;
            default ->
                    throw new IllegalArgumentException("Error: mode is not found\nAvailable modes: coding, decoding");
        };
        final Type typeName = switch (type) {
            case "string" -> Type.STRING;
            case "stringbuilder" -> Type.STRINGBUILDER;
            default ->
                    throw new IllegalArgumentException("Error: type is not found\nAvailavle types: String, StringBuilder");
        };
        return new Parameters(pathWay, modeName, typeName);
    }
}