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
        int M = 5;
        int K = 1024;

        String[][] a = new String[M][K];
        a[0] = TextFileHandler.readfromFile("./resources/strings1.txt");
        a[1] = TextFileHandler.readfromFile("./resources/strings2.txt");
        a[2] = TextFileHandler.readfromFile("./resources/strings3.txt");
        a[3] = TextFileHandler.readfromFile("./resources/strings4.txt");
        a[4] = TextFileHandler.readfromFile("./resources/strings5.txt");

        // Average Case
        System.out.printf("\nAVERAGE CASE\n");
        System.out.format("\n%11s %14s %11s", "Array Size", "Compare Count", "Copy Count");

        for (int row = 0; row < M; row++) {
            for (int k = 1; k <= 10; k++) {
                int N = (int) Math.pow(2, k);
                String[][] temp = new String[M][N];

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j <= N - 1; j++) {
                        temp[i][j] = a[i][j];
                    }
                }

                Merge.sort(temp[row]);
                System.out.format("\n%11d %14d %11d", N, Merge.getCompareCount(), Merge.getCopyCount());

            }
        }

        // Best Case
        System.out.printf("\nBEST CASE\n");
        System.out.format("\n%11s %14s %11s", "Array Size", "Compare Count", "Copy Count");

        for (int row = 0; row < M; row++) {
            for (int k = 1; k <= 10; k++) {
                int N = (int) Math.pow(2, k);
                String[][] temp = new String[M][N];

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j <= N - 1; j++) {
                        temp[i][j] = a[i][j];
                    }
                }

                Merge.sort(temp[row]);
                Merge.sort(temp[row]);
                System.out.format("\n%11d %14d %11d", N, Merge.getCompareCount(), Merge.getCopyCount());
            }
        }
    }
}
