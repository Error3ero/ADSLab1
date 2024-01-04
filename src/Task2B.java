import java.util.Scanner;

public class Task2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int M = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            int l = -1;
            int r = n - 1;
            while (r - l > 1) {
                int m = (r + l) / 2;
                int v = a[m];
                if (v < k) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (a[r] == k) {
                System.out.print(++r + " ");
            } else {
                System.out.println(0);
                continue;
            }
            l = 0;
            r = n;
            while (r - l > 1) {
                int m = (r + l) / 2;
                int v = a[m];
                if (v <= k) {
                    l = m;
                } else {
                    r = m;
                }
            }
            System.out.println(++l);
        }
        sc.close();
    }
}