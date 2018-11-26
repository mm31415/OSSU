/*
  Improvement 1: Weighting

  Find/Connected: O(log N)
  Union: O(log N), log N includes the searching of root, technicatlly the
  actual union portion is constant
*/

class WeightedQUF {

  private int[] id, sz;

  public WeightedQUF(int N) {
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  private int root(int i) {
    while (id[i] != i) i = id[i];

    return i;
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
