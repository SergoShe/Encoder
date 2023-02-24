public class Resource {
    private final String inputText;
    private String outputText = "";

    Resource(String inputText) {
        this.inputText = inputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    public String getInputText() {
        return inputText;
    }

    public String getOutputText() {
        return outputText;
    }
}
