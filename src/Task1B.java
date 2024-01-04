import java.util.Arrays;
import java.util.Scanner;

public class Task1B {
    public static long inversions;

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
        int[] merged = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        for (int q = 0; q < a.length + b.length; q++) {
            if (i < a.length && j < b.length) {
                if (a[i] > b[j]) {
                    merged[q] = b[j++];
                    inversions += a.length - i;
                } else {
                    merged[q] = a[i++];
                }
            } else if (j < b.length) {
                merged[q] = b[j++];
            } else {
                merged[q] = a[i++];
            }
        }

        return merged;
    }

    static public void main(String[] args) {
        inversions = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }
        System.err.println(Arrays.toString(sort(in)));
        System.out.println(inversions);
    }
}
