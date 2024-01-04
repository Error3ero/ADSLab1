import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        void_sex(n, 0);
    }

    private static void void_sex(int n, int depth) {
        if (depth == n) {
            System.err.println("CMEPTb");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.err.print("CMEPTb ");
            void_sex(n, depth + 1);
        }
    }
}