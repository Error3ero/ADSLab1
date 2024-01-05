import java.util.Arrays;
import java.util.Scanner;

public class Task6A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] data = sc.next().toCharArray();
        sc.close();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] == 'w' || dp[i] == -1) {
                continue;
            }
            if (data[i] == '"') {
                dp[i]++;
            }
            if (i + 1 < n && data[i + 1] != 'w') {
                if (dp[i + 1] == -1) {
                    dp[i + 1]++;
                }
                dp[i + 1] = Integer.max(dp[i], dp[i + 1]);
            }
            if (i + 3 < n && data[i + 3] != 'w') {
                if (dp[i + 3] == -1) {
                    dp[i + 3]++;
                }
                dp[i + 3] = Integer.max(dp[i], dp[i + 3]);
            }
            if (i + 5 < n && data[i + 5] != 'w') {
                if (dp[i + 5] == -1) {
                    dp[i + 5]++;
                }
                dp[i + 5] = Integer.max(dp[i], dp[i + 5]);
            }
        }
        System.out.println(dp[n - 1]);
    }
}
