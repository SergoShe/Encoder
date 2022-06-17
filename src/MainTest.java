import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testReadFile_1() throws IOException {
        String pathWay = "input1.txt";
        String expected = "asd";
        String actual = Main.readFile(pathWay);
        assertEquals(expected,actual);
    }

    @Test
    public void testWriteFile() {
    }

    @Test
    public void testCodingFile_1() {
        String text = "aaabbbbcceeeeeeeeeebbbb";
        String excepted =  "a3b4c2e10b4";
        String actual = Main.codingFile(text);
        assertEquals(excepted,actual);
    }

    @Test
    public void testCodingFile_2() {
        String text = "aaassearsssrmmj";
        String excepted =  "a3s2ears3rm2j";
        String actual = Main.codingFile(text);
        assertEquals(excepted,actual);
    }

    @Test
    public void testDecodingFile_1() {
        String text = "a3b4c2e10b4";
        String excepted =  "aaabbbbcceeeeeeeeeebbbb";
        String actual = Main.decodingFile(text);
        assertEquals(excepted,actual);
    }

    @Test
    public void testDecodingFile_2() {
        String text = "a3s2ears3rm2j";
        String excepted =  "aaassearsssrmmj";
        String actual = Main.decodingFile(text);
        assertEquals(excepted,actual);
    }

    @Test
    public void main() {
    }
}
