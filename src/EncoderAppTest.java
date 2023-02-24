import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EncoderAppTest {
    StringEncoder stringEncoder = new StringEncoder(new CounterProgress());
    StringBuilderEncoder stringBuilderEncoder = new StringBuilderEncoder(new CounterProgress());

    /*
        @Test
        public void testReadFile_1() throws IOException {
            File file = new File("input1.txt");
            String expected = "asd";
            String actual = encoderFile.readFile(file);
            assertEquals(expected, actual);
        }
    */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCodingFile_1() {
        String text = "aaabbbbcceeeeeeeeeebbbb";
        String excepted = "a3b4c2e10b4";
        String actual = stringEncoder.codingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testCodingFile_2() {
        String text = "aaassearsssrmmj";
        String excepted = "a3s2ears3rm2j";
        String actual = stringEncoder.codingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testCodingFile_3() {
        String text = "aaabbbbcceeeeeeeeeebbbb";
        String excepted = "a3b4c2e10b4";
        String actual = stringBuilderEncoder.codingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testCodingFile_4() {
        String text = "aaassearsssrmmj";
        String excepted = "a3s2ears3rm2j";
        String actual = stringBuilderEncoder.codingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testDecodingFile_1() {
        String text = "a3b4c2e10b4";
        String excepted = "aaabbbbcceeeeeeeeeebbbb";
        String actual = stringEncoder.decodingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testDecodingFile_2() {
        String text = "a3s2ears3rm2j";
        String excepted = "aaassearsssrmmj";
        String actual = stringEncoder.decodingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testDecodingFile_3() {
        String text = "a3b4c2e10b4";
        String excepted = "aaabbbbcceeeeeeeeeebbbb";
        String actual = stringBuilderEncoder.decodingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testDecodingFile_4() {
        String text = "a3s2ears3rm2j";
        String excepted = "aaassearsssrmmj";
        String actual = stringBuilderEncoder.decodingText(text);
        assertEquals(excepted, actual);
    }

    @Test
    public void testBuild_1() {
        String[] inputArgs = {"input1.txt", "coding", "StrinG"};
        Parameters excepted = new Parameters("D:\\Java\\IdeaProjects\\Encoder\\input1.txt", Mode.CODING, Type.STRING);
        Parameters actual = ParametersBuilder.build(inputArgs);
        assertEquals(excepted.getPathWay(), actual.getPathWay());
        assertEquals(excepted.getMode(), actual.getMode());
        assertEquals(excepted.getType(), actual.getType());
    }

    @Test
    public void testBuild_2() {
        String[] inputArgs = {"input1.txt", "decoding", "StringBuilder"};
        Parameters excepted = new Parameters("D:\\Java\\IdeaProjects\\Encoder\\input1.txt", Mode.DECODING, Type.STRINGBUILDER);
        Parameters actual = ParametersBuilder.build(inputArgs);
        assertEquals(excepted.getPathWay(), actual.getPathWay());
        assertEquals(excepted.getMode(), actual.getMode());
    }

    @Test
    public void testBuild_3() {
        String[] inputArgs = {"input1.txt", "StringBuilder"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error: parameter(s) not entry\nRequired parameters: pathWay, mode, type");
        ParametersBuilder.build(inputArgs);
    }

    @Test
    public void testBuild_4() {
        String[] inputArgs = {"input1.txt", "decode", "StringBuilder"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error: mode is not found\nAvailable modes: coding, decoding");
        ParametersBuilder.build(inputArgs);
    }

    @Test
    public void testBuild_5() {
        String[] inputArgs = {"input1.txt", "coding", "StrBld"};
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error: type is not found\nAvailavle types: String, StringBuilder");
        ParametersBuilder.build(inputArgs);
    }

}