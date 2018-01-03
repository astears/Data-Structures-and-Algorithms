import java.util.Arrays;
public class TripleStep {

  public static int countWays(int n) {
    int memo[] = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWaysHelper(n, memo);
  }

  public static int countWaysHelper(int n, int mem[]) {

    if (n < 0) {
      return 0;
    }
    else if (n == 0) {
      return 1;
    }
    else if (mem[n] > - 1) {
      return mem[n];
    }

    mem[n] = countWaysHelper(n - 1, mem) + countWaysHelper(n - 2, mem) + countWaysHelper(n - 3, mem);

    return mem[n];
  }

  public static void main(String[] args) {
    System.out.println(countWays(4));
  }

}
