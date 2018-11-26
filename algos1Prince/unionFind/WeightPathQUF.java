/*
  Improvement 2: Path Compression

  Find/Connected: O(log N)
  Union: O(log N), log N includes the searching of root, technicatlly the
  actual union portion is constant
*/
class WeightPathQUF {

  private int[] id, sz;

  public WeightPathQUF(int N) {
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root(int i) {
    /*
      first approach is run a second while loop to
      set root for every node passed to top root

      int r = i, oldRoot;

      while (id[r] != r) {
        r = id[r];
      }

      while (id[i] != i) {
        oldRoot = id[i];
        id[i] = r;
        i = oldRoot;
      }
    */

    /*
      second approach is a modified version of 1
      just setting root to a grandparent during one pass
      done with just one line of code

      In practice essentially just as good as 2 loops
    */
    while (id[i] != i) {
      id[i] = id[id[i]];
      i = id[i];
    }

    return i;

    /*
      recursive way has the same effect of two loops
      main difference is more memory is being used up in call stack

      if (id[i] == i) return i;

      int root = root(id[i]);
      id[i] = root;

      return root;
    */
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int pRoot = root(p);
    int qRoot = root(q);

    if (pRoot == qRoot) return;

    if (sz[pRoot] > sz[qRoot]) {
      sz[pRoot] += sz[qRoot];
      id[qRoot] = pRoot;
    } else {
      sz[qRoot] += sz[pRoot];
      id[pRoot] = qRoot;
    }
  }
}
