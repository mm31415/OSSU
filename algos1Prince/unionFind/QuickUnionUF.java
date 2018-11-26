/*
  QuickUnionUF [lazy approach]

  Find is O(N) because of having to search for roots

  Union is O(N) because of having to run the root method

  Essentially the union is fast but the slow part of the algorithm is
  actually root() in terms of the possibility of having to cycle
  through one single tree
*/

public class QuickUnionUF {

  private int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    if (id[i] == i) return i;

    return root(id[i]);
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    id[root(p)] = root(q);
  }
  
}
