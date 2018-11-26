public class Client {
  public static void main(String[] args) {
    int N = StdIn.readInt();
    UF uf = new UF(N);

    while (!StdIn.empty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();

      if (!uf.connected(p, q)) {
        uf.union(p, q);
        StdOut.println(p + " and " + q + " are now connected");
      } else {
        StdOut.println(p + " and " + q + " are already connected");
      }
    }
  }
}
