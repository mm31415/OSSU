import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private int n;
  private int trials;
  private Percolation perc;
  private double[] threshold;

  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException("n or trials is <= 0");
    }
    this.n = n;
    this.trials = trials;
    threshold = new double[trials];

    runTests();
  }

  private void runTests() {
    for (int i = 0; i < trials; i++) {
      perc = new Percolation(n);
      while (!perc.percolates()) {
        perc.open(
          StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1)
        );
      }

      threshold[i] = (double) perc.numberOfOpenSites() / (n * n);
    }
  }

  public double mean() {
    return StdStats.mean(threshold);
  }

  public double stddev() {
    return StdStats.stddev(threshold);
  }

  public double confidenceLo() {
    return mean() - (1.96 * stddev() / Math.sqrt(trials));
  }

  public double confidenceHi() {
    return mean() + (1.96 * stddev() / Math.sqrt(trials));
  }

  public static void main(String[] args) {
    int n, trials;
    if (args.length == 2) {
      n = Integer.parseInt(args[0]);
      trials = Integer.parseInt(args[1]);
    } else {
      throw new IllegalArgumentException("missing info");
    }

    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException("values must be greater than 0");
    }

    PercolationStats pStat = new PercolationStats(n, trials);

    System.out.println("mean\t\t\t= " + pStat.mean());
    System.out.println("stddev\t\t\t= " + pStat.stddev());
    System.out.println(
      "95% confidence interval\t= [" + pStat.confidenceLo() +
      ", " + pStat.confidenceHi() + "]\n"
    );

  }
}
