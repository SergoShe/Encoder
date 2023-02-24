public class StringBuilderEncoder extends CommonEncoder {

    CounterProgress countProgress;

    public StringBuilderEncoder(CounterProgress countProgress) {
        this.countProgress = countProgress;
    }

    public String codingText(String text) {
        StringBuilder codingTextBuilder = new StringBuilder();
        countProgress.length = text.length();
        char tmp = text.charAt(0);
        int count = 1;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol != tmp) {
                if (count == 1) {
                    codingTextBuilder.append(tmp);
                } else {
                    codingTextBuilder.append(tmp).append(count);
                }
                count = 1;
                tmp = symbol;
            } else {
                count++;
            }
            countProgress.value++;
        }
        if (count == 1) {
            codingTextBuilder.append(tmp);
        } else {
            codingTextBuilder.append(tmp).append(count);
        }
        countProgress.value++;
        return codingTextBuilder.toString();
    }

    public String decodingText(String text) {
        StringBuilder decodedTextBuilder = new StringBuilder();
        char tmp = text.charAt(0);
        int count = 0;
        for (int i = 1; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (47 < symbol && symbol < 58) {
                int number = Integer.parseInt(String.valueOf(symbol));
                count = count * 10 + number;
            } else if (count == 0) {
                decodedTextBuilder.append(tmp);
                tmp = symbol;
            } else {
                decodedTextBuilder.append(String.valueOf(tmp).repeat(count));
                tmp = symbol;
                count = 0;
            }
        }
        if (count == 0) {
            decodedTextBuilder.append(tmp);
        } else {
            decodedTextBuilder.append(String.valueOf(tmp).repeat(count));
        }
        return decodedTextBuilder.toString();
    }
}