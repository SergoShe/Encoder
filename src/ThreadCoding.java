public class ThreadCoding implements Runnable {
    Resource resource;
    CommonEncoder encoder;

    public ThreadCoding(Resource resource, CommonEncoder encoder) {
        this.resource = resource;
        this.encoder = encoder;
    }

    @Override
    public synchronized void run() {
        String outputText = encoder.codingText(resource.getInputText());
        if (resource.getOutputText().isEmpty()) {
            resource.setOutputText(outputText);
            System.out.println("First finish is " + Thread.currentThread().getName());
        }

    }
}
