public class EncoderApp {
    public static void main(String[] args) {
        try {
            Parameters parameters = ParametersBuilder.build(args);
            StringEncoder stringEncoder = new StringEncoder();
            FileEncoder encoderFile = new FileEncoder(stringEncoder);
            encoderFile.transformFile(parameters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}