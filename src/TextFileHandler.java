import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ADLab03
 * Created by IF on 08.11.17.
 */
public class TextFileHandler {
    private static String FILE;

    public TextFileHandler(String fileName) {
        FILE = fileName;
    }

    public static String[] readfromFile() {
        String[] a = new String[1024];
        BufferedReader reader = null;

        try {
            Path stringsFile = Paths.get(FILE).toAbsolutePath();
            reader = new BufferedReader(new FileReader(stringsFile.toString()));
            String line;
            line = reader.readLine();
            int i = 0;

            while(line != null) {
                a[i] = line;
                line = reader.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e){
                    System.err.println(e);
                }
            }
        }
        return a;
    }
}
