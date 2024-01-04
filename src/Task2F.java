import java.util.Scanner;

public class Task2F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] wires = new int[n];
        for (int i = 0; i < n; i++) {
            wires[i] = sc.nextInt();
        }
        int l = 1;
        int r = Integer.MAX_VALUE - 5;
        while (l < r) {
            int m = (l + r) / 2;
            int current = 0;
            for (int i = 0; i < n; ++i)
                current += wires[i] / m;
            if (current >= k)
                l = m + 1;
            else
                r = m;
        }
        System.out.println(l - 1);
    }
}
