public class EncoderApp {
    public static void main(String[] args) {
        try {
            Parameters parameters = ParametersBuilder.build(args);
            CommonEncoder commonEncoder = null;
            switch (parameters.getType()) {
                case STRING -> commonEncoder = new StringEncoder(new ProgressCounter());
                case STRINGBUILDER -> commonEncoder = new StringBuilderEncoder(new ProgressCounter());
                case COMPARABLE -> commonEncoder = new ComparableEncoder();
            }
            FileEncoder fileEncoder = new FileEncoder(commonEncoder);
            fileEncoder.transformFile(parameters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}