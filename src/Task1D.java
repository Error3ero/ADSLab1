import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1D {
    private static List<Integer> queue;
    private static int size = 0;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queue = new ArrayList<>(n);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            switch (sc.nextInt()) {
                case 1:
                    extractMax();
                    break;
                case 2:
                    add(sc.nextInt());
                    break;
                case 3:
                    rm(sc.nextInt() - 1);
                    break;
            }
        }
        print(queue);
    }

    private static int sift_up(int i) {
        while (queue.get(i) > queue.get((i - 1) / 2)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
        return i;
    }

    private static int sift_down(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < size && queue.get(i) < queue.get(left)) {
                swap(i, left);
                i = left;
            } else if (right < size && queue.get(i) < queue.get(right)) {
                swap(i, right);
                i = right;
            } else {
                break;
            }
        }
        return i;
    }

    private static void add(int a) {
        if (size == n) {
            System.out.println(-1);
            return;
        }
        queue.add(a);
        System.out.println(sift_up(size++) + 1);
    }

    private static void rm(int i) {
        if (i >= size || i < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue.get(i));
        queue.set(i, queue.get(--size));
        queue.remove(size);
        sift_down(i);
    }

    private static void extractMax() {
        if (size == 0) {
            System.out.println(-1);
            return;
        }
        int max = queue.get(0);
        queue.set(0, queue.remove(--size));
        System.out.println((sift_down(0) + 1) + " " + max);
    }

    private static void swap(int i, int j) {
        int q = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, q);
    }

    private static void print(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
