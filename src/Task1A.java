import java.util.Arrays;
import java.util.Scanner;

public class Task1A {
    static public int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        } else {
            int[] left = sort(Arrays.copyOfRange(a, 0, a.length / 2));
            int[] right = sort(Arrays.copyOfRange(a, a.length / 2, a.length));

            return merge(left, right);
        }
    }

    static public int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] merged = new int[n + m];
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            if (j == m || (i < n && (a[i] < b[j]))) {
                merged[i + j] = a[i];
                i++;
            } else {
                merged[i + j] = b[j];
                j++;
            }
        }
        return merged;
    }

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        System.err.println(Arrays.toString(sort(input)));
        sc.close();
        int[] output = sort(input);
        for (int i = 0; i < n; i++) {
            System.out.print(output[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}