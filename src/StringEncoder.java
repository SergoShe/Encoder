public class StringEncoder extends CommonEncoder {

    public String codingText(String text) {
        String codingText = "";
        char tmp = text.charAt(0);
        int count = 1;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol != tmp) {
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
        if (count == 1) {
            codingText += tmp;
        } else {
            codingText += tmp + String.valueOf(count);
        }
        return codingText;
    }

    public String decodingText(String text) {
        String decodedText = "";
        char tmp = text.charAt(0);
        int count = 0;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (47 < symbol && symbol < 58) {
                int number = Integer.parseInt(String.valueOf(symbol));
                count = count * 10 + number;
            } else if (count == 0) {
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
        if (count == 0) {
            decodedText += tmp;
        } else {
            for (int j = 0; j < count; j++) {
                decodedText += tmp;
            }
        }
        return decodedText;
    }
}