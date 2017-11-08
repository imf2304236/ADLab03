/**
 * Sedgewick
 * Created by IF on 07.11.17.
 */
public class Merge {
    private static Comparable[] temp;
    private static int copyCount = 0;
    private static int compareCount = 0;

    /**
     * Recursive sort method which creates a temp array and begins sorting
     * @param a Array of Comparables
     */
    public static void sort(Comparable[] a) {
        temp = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * Recursive sort method which sorts both subarrays separately, then merges the two in place
     * @param a Array of Comparables
     * @param lo Integer of initial array index
     * @param hi Integer of final array index
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) { return; }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * Merge method which merges an array containing two partially sorted subarrays
     * @param a Array of Comparables
     * @param lo Integer of initial array index
     * @param mid Integer of median array index
     * @param hi Integer of final array index
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;         // Index of smallest member of left subarray
        int j = mid + 1;    // Index of smallest member of right subarray

        // Copy contents of a to temp from index lo to hi
        for (int k = 0; k <= hi; k++) {
            temp[k] = a[k];
            copyCount++;
        }

        // Merge contents of a to temp
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {          // Copy contents of right array when left index passes mid index
                a[k] = temp[j];
                j++;
            } else if (j > hi) {    // Copy contents of left array when right index passes hi index
                a[k] = temp[i];
                i++;
            } else if (less(temp[j], temp[i])) {    // Compare smallest members of each array
                a[k] = temp[j];
                j++;
            } else {
                a[k] = temp[i];
                i++;
            }
        }
    }

    /**
     * Less helper method
     * @param v Comparable object to be compared to
     * @param w Comparable object to be compared
     * @return Boolean true if v < w, false otherwise
     */
    private static boolean less(Comparable v, Comparable w) {
        compareCount++;
        return v.compareTo(w) < 0;
    }

    /**
     * Method which checks if an array is sorted
     * @param a Array of Comparables to be checked
     * @return Boolean true if the array is sorted, false otherwise
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method which prints each member of the array on a single line
     * @param a Array of Comparables to be printed
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main method to run tests
     * @param args Array of strings to define test behavior
     */
    public static void main(String[] args) {
        String[] a = new String[8];
        a[0] = "it";
        a[1] = "was";
        a[2] = "best";
        a[3] = "the";
        a[4] = "of";
        a[5] = "times";
        a[6] = "ever";
        a[7] = "seen";

        System.out.println("\nMerge Sort:");
        System.out.print("Unsorted array: ");
        show(a);

        sort(a);
        if (!isSorted(a)) throw new Error();

        System.out.print("Sorted array:   ");
        show(a);
        System.out.println("Compare Count:  " + compareCount);
        System.out.println("Copy Count:     " + copyCount);

    }
}
