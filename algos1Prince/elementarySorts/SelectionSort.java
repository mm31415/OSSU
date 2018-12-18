public class SelectionSort {

  public static void sort(Comparable[] a) {
    int i = 0, j, min;

    while (i < a.length) {
      min = i;
      for (j = i; j < a.length; j++) {
        if (less(a[j], a[min])) min = j;
      }

      exch(a, i, min);
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
    Integer[] a = { 0, 3, -4, 40, 33, 43, 32, 1, 45, 3, 5, 2 };

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    SelectionSort.sort(a);

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
}
