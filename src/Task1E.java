import java.util.Arrays;
import java.util.Scanner;

public class Task1E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] barrels = new int[n];
        long volume = 0;
        for (int i = 0; i < n; i++) {
            barrels[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(barrels);
        for (int i = n - 1; i >= 0; i--) {
            while (barrels[i] > p && m > 0) {
                m--;
                volume += p;
                barrels[i] -= p;
            }
            if (m == 0) {
                break;
            }
        }
        Arrays.sort(barrels);
        for (int i = n - 1; i >= 0; i--) {
            if (m == 0) {
                break;
            }
            m--;
            volume += barrels[i];
        }
        System.out.println(volume);
    }
}
