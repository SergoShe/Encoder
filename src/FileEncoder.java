import java.io.*;
import java.nio.file.Path;

public class FileEncoder {
    StringEncoder stringEncoder;

    public FileEncoder(StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    private String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String text = reader.readLine();
        if (text == null) {
            throw new NullPointerException("Error: text is empty");
        }
        return text;
    }

    private void writeFile(String text, String pathWay) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathWay));
        writer.write(text);
        writer.close();
    }

    private String createPathEncoder(String pathWay, String option) {
        Path pathFile = Path.of(pathWay);
        String encoderPath = String.valueOf(pathFile.getParent());
        String fileName = String.valueOf(pathFile.getFileName());
        String encoderFile = File.separator + fileName.substring(0, fileName.lastIndexOf('.')) + "_" + option + ".txt";
        encoderPath += encoderFile;
        return encoderPath;
    }

    private void doTransform(Parameters parameters) throws IOException {

        final File file = new File(parameters.getPathWay());
        final String text = readFile(file);
        String pathWayEncoder;
        String textEncoder;
        switch (parameters.getMode()) {
            case CODING -> {
                pathWayEncoder = createPathEncoder(parameters.getPathWay(), "coded");
                textEncoder = stringEncoder.codingText(text);
                writeFile(textEncoder, pathWayEncoder);
            }
            case DECODING -> {
                pathWayEncoder = createPathEncoder(parameters.getPathWay(), "decoded");
                textEncoder = stringEncoder.decodingText(text);
                writeFile(textEncoder, pathWayEncoder);
            }
        }
    }

    public void transformFile(Parameters parameters) {
        try {
            doTransform(parameters);
        } catch (IOException e) {
            System.out.println("Error: file not found");
        }
    }
}