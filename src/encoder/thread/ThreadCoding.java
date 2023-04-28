package encoder.thread;

import encoder.CommonEncoder;
import encoder.resources.Resource;

public class ThreadCoding implements Runnable {
    private final Resource resource;
    private final CommonEncoder encoder;
    public boolean isFinished;

    public ThreadCoding(Resource resource, CommonEncoder encoder) {
        this.resource = resource;
        this.encoder = encoder;
    }

    @Override
    public synchronized void run() {
        String outputText = encoder.codingText(resource.getInputText());
        if (resource.getOutputText().isEmpty()) {
            resource.setOutputText(outputText);
            isFinished = true;
        }
    }
}