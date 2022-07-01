public class StringBuilderEncoder extends CommonEncoder {

    public String codingText(String text) {
        StringBuilder codingText = new StringBuilder();
        char tmp = text.charAt(0);
        int count = 1;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol != tmp) {
                if (count == 1) {
                    codingText.append(tmp);
                } else {
                    codingText.append(tmp).append(count);
                }
                count = 1;
                tmp = symbol;
            } else {
                count++;
            }
        }
        if (count == 1) {
            codingText.append(tmp);
        } else {
            codingText.append(tmp).append(count);
        }
        return codingText.toString();
    }

    public String decodingText(String text) {
        StringBuilder decodedText = new StringBuilder();
        char tmp = text.charAt(0);
        int count = 0;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (47 < symbol && symbol < 58) {
                int number = Integer.parseInt(String.valueOf(symbol));
                count = count * 10 + number;
            } else if (count == 0) {
                decodedText.append(tmp);
                tmp = symbol;
            } else {
                decodedText.append(String.valueOf(tmp).repeat(count));
                tmp = symbol;
                count = 0;
            }
        }
        if (count == 0) {
            decodedText.append(tmp);
        } else {
            decodedText.append(String.valueOf(tmp).repeat(count));
        }
        return decodedText.toString();
    }
}