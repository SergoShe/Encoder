import java.io.*;
import java.nio.file.Path;

public class Main {
    static BufferedReader reader;
    static BufferedWriter writer;
    static String text;

    public static String readFile(String pathWay) throws IOException {

        try {
            reader = new BufferedReader(new FileReader(pathWay));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = reader.readLine();
        if (text == null) {
            throw new NullPointerException("Error: file is empty");
        }

        return text;
    }

    public static boolean writeFile(String text, String pathWay) {
        boolean flag = true;
        Path path = Path.of(pathWay).getParent();
        pathWay = path + "\\output.txt";
        try {
            writer = new BufferedWriter(new FileWriter(pathWay));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(text);
        } catch (IOException e) {
            flag = false;
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static String codingFile(String text) {
        String codingText = "";
        char tmp = text.charAt(0);
        int count = 1;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol!=tmp) {
                if (count == 1) {
                    codingText += tmp;
                } else {
                    codingText += tmp + String.valueOf(count);
                }
                count = 1;
                tmp = symbol;
            } else {
                count++;
            }
        }
        if (count==1){
            codingText += tmp;
        } else {
            codingText += tmp + String.valueOf(count);
        }

        return codingText;
    }

    public static String decodingFile(String text) {
        String decodedText = "";
        char tmp = text.charAt(0);
        int count = 0;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (47 < symbol && symbol < 58) {
                int number = Integer.parseInt(String.valueOf(symbol));
                count = count*10 + number;
            } else if (count==0){
                decodedText += tmp;
                tmp = symbol;
            } else {
                for (int j = 0; j < count; j++) {
                    decodedText += tmp;
                }
                tmp = symbol;
                count = 0;
            }
        }
        if (count==0){
            decodedText += tmp;
        } else {
            for (int j = 0; j < count; j++) {
                decodedText += tmp;
            }
        }

        return decodedText;
    }

    public static void main(String[] args) throws IOException {
        if (args.length!=2){
            throw new ArrayIndexOutOfBoundsException("Error: option(s) not entry");
        }
        String pathWay = String.valueOf(Path.of(args[0]).toAbsolutePath());
        String text = readFile(pathWay);
        String option = args[1];
        if (!(option.equals("coding") || option.equals("decoding"))) {
            throw new NullPointerException("Error: option is not found");
        } else if (args[1].equals("coding")){
            text = codingFile(text);
        } else {
            text = decodingFile(text);
        }
        System.out.println(writeFile(text, pathWay));

    }


}