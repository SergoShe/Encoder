public class EncoderApp {
    public static void main(String[] args) {
        try {
            Parameters parameters = ParametersBuilder.build(args);
            CommonEncoder commonEncoder = null;
            switch (parameters.getType()) {
                case STRING -> commonEncoder = new StringEncoder();
                case STRINGBUILDER -> commonEncoder = new StringBuilderEncoder();
            }
            FileEncoder fileEncoder = new FileEncoder(commonEncoder);
            fileEncoder.transformFile(parameters);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}