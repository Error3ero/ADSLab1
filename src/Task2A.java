import java.util.Arrays;
import java.util.Scanner;

public class Task2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int q = sc.nextInt();
            int l = 0;
            int r = n - 1;
            boolean isFound = false;
            while (l <= r) {
                int m = (l + r) / 2;
                int value = arr[m];
                if (value == q) {
                    isFound = true;
                    break;
                }
                if (value < q) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            System.out.println(isFound ? "YES" : "NO");
        }
        sc.close();
    }
}
