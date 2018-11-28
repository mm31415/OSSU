import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private boolean[][] grid;
  private WeightedQuickUnionUF uf;
  private int openSites;
  private int virtualTop;
  private int virtualBottom;

  public Percolation(int n) {
    if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
    grid = new boolean[n][n];
    openSites = 0;
    virtualTop = 0;
    virtualBottom = n*n + 1;
    uf = new WeightedQuickUnionUF(n*n + 2);
  }

  public void open(int row, int col) {
    validates(row, col);

    if (!isOpen(row, col)) {
      grid[row - 1][col - 1] = true;
      openSites += 1;

      int n = grid[0].length;
      int p = gridValue(row, col, n);

      if (row == n) {
        uf.union(p, virtualBottom);
      } else if (row == 1) {
          uf.union(p, virtualTop);
      }

      if (row + 1 <= n && isOpen(row + 1, col)) {
        uf.union(p, gridValue(row + 1, col, n));
      }
      if (row - 1 >= 1 && isOpen(row - 1, col)) {
        uf.union(p, gridValue(row - 1, col, n));
      }
      if (col + 1 <= n && isOpen(row, col + 1)) {
        uf.union(p, gridValue(row, col + 1, n));
      }
      if (col - 1 >= 1 && isOpen(row, col - 1)) {
        uf.union(p, gridValue(row, col - 1, n));
      }
    }
  }

  public boolean isOpen(int row, int col) {
    validates(row, col);

    return grid[row - 1][col - 1];
  }

  public boolean isFull(int row, int col) {
    validates(row, col);

    int n = grid[0].length;
    return uf.connected(virtualTop, gridValue(row, col, n));
  }

  public int numberOfOpenSites() {
    return openSites;
  }

  public boolean percolates() {
    return uf.connected(virtualTop, virtualBottom);
  }

  private void validates(int row, int col) {
    int n = grid[0].length;

    if (row < 1 || row > n) {
      throw new IllegalArgumentException("row " + row + " not between 1 and " + n);
    } else if (col < 1 || col > n) {
      throw new IllegalArgumentException("col " + col + " not between 1 and " + n);
    }
  }

  private int gridValue(int row, int col, int n) {
    return n * (row - 1) + col;
  }
}
