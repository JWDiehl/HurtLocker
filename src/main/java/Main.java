import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static String readRawDataToString() throws IOException {
        //standardCharsets.UTF_8 for charset handling
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("RawData.txt");
        if (inputStream == null) {
            throw new IOException("Resource not found from RawData.txt");
        }
        try {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } finally {
            inputStream.close();
        }
    }

    public static void main(String[] args) {
        try {
            JerkSONParser itemParser = new JerkSONParser();
            String rawData = readRawDataToString();
            itemParser.createItem(rawData);
            System.out.println(itemParser.groceryListConstructor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
