package encoder;


import encoder.resources.ProgressCounter;
import encoder.resources.Resource;
import encoder.thread.ThreadCoding;
import encoder.thread.ThreadDecoding;

public class ComparableEncoder extends CommonEncoder {

    public String codingText(String text) {
        Resource resource = new Resource(text);
        ProgressCounter countString = new ProgressCounter();
        ProgressCounter countStringBuilder = new ProgressCounter();
        ThreadCoding runnableStringEncoder = new ThreadCoding(resource, new StringEncoder(countString));
        ThreadCoding runnableStringBuilderEncoder = new ThreadCoding(resource, new StringBuilderEncoder(countStringBuilder));
        Thread threadStringEncoder = new Thread(runnableStringEncoder);
        Thread threadStringBuilderEncoder = new Thread(runnableStringBuilderEncoder);
        threadStringEncoder.start();
        threadStringBuilderEncoder.start();
        boolean isWork = true;
        try {
            while (isWork) {
                System.out.println("String: " + "*".repeat((int) countString.getPercent() / 10) + " " + String.format("%.2f", countString.getPercent()) + "%");
                System.out.println("StringBuilder: " + "*".repeat((int) countStringBuilder.getPercent() / 10) + " " + String.format("%.2f", countStringBuilder.getPercent()) + "%");
                if (runnableStringEncoder.isFinished || runnableStringBuilderEncoder.isFinished) {
                    isWork = false;
                    if (runnableStringEncoder.isFinished && runnableStringBuilderEncoder.isFinished) {
                        System.out.println("encoder.StringEncoder and encoder.StringBuilderEncoder threads are finished");
                    } else if (!runnableStringBuilderEncoder.isFinished) {
                        threadStringBuilderEncoder.interrupt();
                        System.out.println("First finish is encoder.StringEncoder thread");
                    } else {
                        threadStringEncoder.interrupt();
                        System.out.println("First finish is encoder.StringBuilderEncoder thread");
                    }
                } else {
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resource.getOutputText();
    }

    public String decodingText(String text) {
        Resource resource = new Resource(text);
        ProgressCounter countString = new ProgressCounter();
        ProgressCounter countStringBuilder = new ProgressCounter();
        ThreadDecoding runnableStringEncoder = new ThreadDecoding(resource, new StringEncoder(countString));
        ThreadDecoding runnableStringBuilderEncoder = new ThreadDecoding(resource, new StringBuilderEncoder(countStringBuilder));
        Thread threadStringEncoder = new Thread(runnableStringEncoder);
        Thread threadStringBuilderEncoder = new Thread(runnableStringBuilderEncoder);
        threadStringEncoder.start();
        threadStringBuilderEncoder.start();
        boolean isWork = true;
        try {
            while (isWork) {
                System.out.println("String: " + "*".repeat((int) countString.getPercent() / 10) + " " + String.format("%.2f", countString.getPercent()) + "%");
                System.out.println("StringBuilder: " + "*".repeat((int) countStringBuilder.getPercent() / 10) + " " + String.format("%.2f", countStringBuilder.getPercent()) + "%");
                if (runnableStringEncoder.isFinished || runnableStringBuilderEncoder.isFinished) {
                    isWork = false;
                    if (runnableStringEncoder.isFinished && runnableStringBuilderEncoder.isFinished) {
                        System.out.println("encoder.StringEncoder and encoder.StringBuilderEncoder threads are finished");
                    } else if (!runnableStringBuilderEncoder.isFinished) {
                        threadStringBuilderEncoder.interrupt();
                        System.out.println("First finish is encoder.StringEncoder thread");
                    } else {
                        threadStringEncoder.interrupt();
                        System.out.println("First finish is encoder.StringBuilderEncoder thread");
                    }
                } else {
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resource.getOutputText();
    }
}