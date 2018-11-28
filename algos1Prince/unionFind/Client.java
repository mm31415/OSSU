/*
  javac WeightPathQUF.java
  javac -cp .:../algos4.jar Client.java
  java -cp .:../algos4.jar Client < tinyUF.txt

  When two classes are in the same directory you do not need to import
  the class.  This is why WeightPathQUF can be used without an import
  statement.

  -cp stands for -classpath
  . stands for start in this directory
  : is used to seperate classpaths
  < filename.type  means the file will be used as the standard inputgit 
*/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Client {
  public static void main(String[] args) {
    int N = StdIn.readInt();
    WeightPathQUF uf = new WeightPathQUF(N);

    while (!StdIn.isEmpty()) {
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
