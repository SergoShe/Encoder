public class ComparableEncoder extends CommonEncoder {

    public String codingText(String text) {
        Resource resource = new Resource(text);
        CounterProgress countString = new CounterProgress();
        CounterProgress countStringBuilder = new CounterProgress();
        ThreadCoding runnableStringBuilder = new ThreadCoding(resource, new StringEncoder(countString));
        ThreadCoding runnableStringBuilderEncoder = new ThreadCoding(resource, new StringBuilderEncoder(countStringBuilder));
        Thread threadStringEncoder = new Thread(runnableStringBuilder, "threadStringEncoder");
        Thread threadStringBuilderEncoder = new Thread(runnableStringBuilderEncoder, "threadStringBuilderEncoder");
        threadStringEncoder.start();
        threadStringBuilderEncoder.start();
        try {
            while (threadStringBuilderEncoder.isAlive() && threadStringEncoder.isAlive()) {
                System.out.println("String: " + "*".repeat((int) countString.getPercent() / 10) + " " + String.format("%.2f", countString.getPercent()) + "%");
                System.out.println("StringBuilder: " + "*".repeat((int) countStringBuilder.getPercent() / 10) + " " + String.format("%.2f", countStringBuilder.getPercent()) + "%");
            }
            threadStringEncoder.join();
            threadStringBuilderEncoder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resource.getOutputText();
    }

    public String decodingText(String text) {
        return null;
    }
}
