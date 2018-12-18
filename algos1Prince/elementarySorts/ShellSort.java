/*
  ShellSort or H-Sort is essentially InsertionSort

  The main difference is you sort based upon a h value
  and keep decrementing h until it reaches 1 making it insertion.

  Useful for large datasets because when h sort you don't pass through
  the entire data set.  Instead you sort the data set in small chunks
  until h equals 1.  By that point the dataset is partially sorted so
  InsertionSort takes O(N) to pass through and finish sorting it.
*/
public class ShellSort {

  public static void sort(Comparable[] a) {
    int h = 1;
    // find largest h value to start with
    while (h < a.length / 3) h = 3 * h + 1;

    while (h >= 1) {
      // insertion sort base
      for (int i = h; i < a.length; i++) {
        for (int j = i; j >= h; j -= h) {
          if (less(a[j], a[j-h])) exch(a, j, j - h);
          else break;
        }
      }

      for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
      }
      System.out.println();

      h /= 3; // decrement h to the next value to shell sort
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    String[] a = {
      "xone", "candy", "Candy", "zone", "surplus", "surplusX", "xyz", "abd", "xzy", "yzx",
      "surplusX", "xyz", "abd", "xzy", "yzx", "xone", "candy", "Candy", "zone", "surplus",
      "xone", "candy", "Candy", "zone", "surplus", "surplusX", "xyz", "abd", "xzy", "yzx",
      "zone", "surplus", "surplusX", "xone", "candy", "Candy", "xyz", "abd", "xzy", "yzx",
    };

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    ShellSort.sort(a);

    // for (int i = 0; i < a.length; i++) {
    //   System.out.print(a[i] + " ");
    // }
    // System.out.println();
  }
}
