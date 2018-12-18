public class InsertionSort {

  public static void sort(Comparable[] a) {
    int i = 0;

    while (i < a.length) {
      for (int j = i; j > 0; j--) {
        if (less(a[j], a[j-1])) exch(a, j, j - 1);
        else break;
      }
      i++;
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
    String[] a = { "xone", "candy", "Candy", "zone", "surplus", "surplusX", "xyz", "abd", "xzy", "yzx" };

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    InsertionSort.sort(a);

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
}
