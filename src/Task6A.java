import java.util.Scanner;

public class Task6A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] data = sc.next().toCharArray();
        long[] dp = new long[n];
        long[] roads = new long[n];
        roads[0] = 1;
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (roads[i] == 0 || data[i] == 'w') {
                continue;
            }
            if (data[i] == '"') {
                dp[i]++;
            }
            if (i + 1 < n && data[i + 1] != 'w') {
                    roads[i + 1] += roads[i];
                    dp[i + 1] += dp[i];
            }
            if (i + 3 < n && data[i + 3] != 'w') {
                    roads[i + 3] += roads[i];
                    dp[i + 3] += dp[i];
            }
            if (i + 5 < n && data[i + 5] != 'w') {
                    roads[i + 5] += roads[i];
                    dp[i + 5] += dp[i];
            }
        }
        if (roads[n - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1]);
        }
    }
}
