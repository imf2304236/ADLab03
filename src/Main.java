import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Sedgewick
 * Created by IF on 03.11.17.
 */
public class Main {


    public static void main(String[] args) {
        String[] a = new TextFileHandler("./resources/strings.txt").readfromFile();

        for (int k = 1; k <= 10; k++) {
            int N = (int)Math.pow(2, k);
            String[] temp1 = new String[N];
            String[] temp2 = new String[N];
            String[] temp3 = new String[N];

            for (int i = 0; i <= N-1; i++) {
                temp1[i] = a[i];
                temp2[i] = a[i];
                temp3[i] = a[i];
            }

            System.out.printf("\nARRAY SIZE = %d", N);
            Selection.main(temp1);
            Insertion.main(temp2);
            Merge.main(temp3);
        }
    }
}
