/*
  Comparabble interface imposes a total ordering on the objects of each class 
  that implements it. This ordering is referred to as the class's natural
  ordering, and the class's compareTo method is referred to as its
  natural comparison method
*/
public class Date implements Comparable<Date> {
  // instance variables are final in order to keep them from being reassigned
  private final int month, day, year;

  public Date(int m, int d, int y) {
    month = m;
    day = d;
    year = y;
  }

  public int compareTo(Date that) {
    if (this.year < that.year) return -1;
    if (this.year > that.year) return 1;
    if (this.month < that.month) return -1;
    if (this.month > that.month) return 1;
    if (this.day < that.day) return -1;
    if (this.day > that.day) return 1;
    return 0;
  }

  public static void main(String[] args) {
    Date d1 = new Date(12, 12, 2013); // original
    Date d2 = new Date(12, 12, 2013); // 0
    Date d3 = new Date(12, 12, 2014); // -1
    Date d4 = new Date(10, 12, 2013); // 1
    Date d5 = new Date(12, 25, 2013); // -1

    System.out.println(d1.compareTo(d2));
    System.out.println(d1.compareTo(d3));
    System.out.println(d1.compareTo(d4));
    System.out.println(d1.compareTo(d5));
  }
}
