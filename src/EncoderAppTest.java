import org.junit.Test;

import static org.junit.Assert.*;

public class EncoderAppTest {
    StringEncoder stringEncoder = new StringEncoder();
    FileEncoder encoderFile = new FileEncoder(stringEncoder);

    /*
        @Test
        public void testReadFile_1() throws IOException {
            File file = new File("input1.txt");
            String expected = "asd";
            String actual = encoderFile.readFile(file);
            assertEquals(expected, actual);
        }
    */
    @Test
    public void testWriteFile() {
    }

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

    /*
        @Test
        public void testCreateEncoderPath_1() {
            String pathWay = "D:\\Java\\IdeaProjects\\Encoder\\input.txt";
            String excepted = "D:\\Java\\IdeaProjects\\Encoder\\input_coded.txt";
            String actual = encoderFile.createPathEncoder(pathWay, "coded");
            assertEquals(excepted, actual);
        }

        @Test
        public void testCreateEncoderPath_2() {
            String pathWay = "D:\\Java\\IdeaProjects\\Encoder\\input.txt";
            String excepted = "D:\\Java\\IdeaProjects\\Encoder\\input_decoded.txt";
            String actual = encoderFile.createPathEncoder(pathWay, "decoded");
            assertEquals(excepted, actual);
        }
    */
    @Test
    public void testBuild_1() {
        String[] inputArgs = {"input1.txt", "coding"};
        Parameters excepted = new Parameters("D:\\Java\\IdeaProjects\\Encoder\\input1.txt", Mode.CODING);
        Parameters actual = ParametersBuilder.build(inputArgs);
        assertEquals(excepted.getPathWay(), actual.getPathWay());
        assertEquals(excepted.getMode(), actual.getMode());
    }

    @Test
    public void testBuild_2() {
        String[] inputArgs = {"input1.txt", "decoding"};
        Parameters excepted = new Parameters("D:\\Java\\IdeaProjects\\Encoder\\input1.txt", Mode.DECODING);
        Parameters actual = ParametersBuilder.build(inputArgs);
        assertEquals(excepted.getPathWay(), actual.getPathWay());
        assertEquals(excepted.getMode(), actual.getMode());
    }

    @Test
    public void testBuild_3() {
        String[] inputArgs = {"input1.txt", "code"};
        Parameters excepted = new Parameters("D:\\Java\\IdeaProjects\\Encoder\\input1.txt", null);
        Parameters actual = ParametersBuilder.build(inputArgs);
        assertEquals(excepted.getPathWay(), actual.getPathWay());
        assertEquals(excepted.getMode(), actual.getMode());
    }
}