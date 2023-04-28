package encoder;

import encoder.resources.ProgressCounter;

public class StringEncoder extends CommonEncoder {

    ProgressCounter countProgress;

    public StringEncoder(ProgressCounter countProgress) {
        this.countProgress = countProgress;
    }

    public String codingText(String text) {
        countProgress.setLength(text.length());
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
            countProgress.increaseValue();
        }
        if (count == 1) {
            codingText += tmp;
        } else {
            codingText += tmp + String.valueOf(count);
        }
        countProgress.increaseValue();
        return codingText;
    }

    public String decodingText(String text) {
        countProgress.setLength(text.length());
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
            countProgress.increaseValue();
        }
        if (count == 0) {
            decodedText += tmp;
        } else {
            for (int j = 0; j < count; j++) {
                decodedText += tmp;
            }
        }
        countProgress.increaseValue();
        return decodedText;
    }
}