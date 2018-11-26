/*
  Quick-Find UF [eager approach]

  Find/Connected is O(1), constant time since due to only needing
  to index and checking equality

  Union is O(N), N being the total number of objects

  Main downside of this approach is that union will always require
  having to iterate through the entire id[]
*/
public class QuickFindUF {
  // private instance variable for QuickFindUF class
  private int[] id;

  // constructor for the QuickFindUF class
  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public void union(int p, int q) {
    // store old id of p
    int oldP = id[p];

    /*
      iterate through id[] and change id values equal to oldP
      to the value of id[q]
    */
    for (int i = 0; i < id.length; i++) {
      if (id[i] === oldP) {
        id[i] = id[q];
      }
    }
  }

  public boolean connected(int p, int q) {
    // equality check returns a boolean value
    return id[p] === id[q];
  }
}
