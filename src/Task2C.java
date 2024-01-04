import java.util.Scanner;

public class Task2C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double a = Double.parseDouble(sc.next().replace(',', '.'));
        sc.close();
        double l = 0.01;
        double r = a;
        double[] h = new double[n];
        h[0] = a;
        while (r - l > 0.0000001) {
            h[1] = (l + r) / 2;
            boolean isUp = true;
            for (int i = 2; i < n; i++) {
                h[i] =  2 * h[i - 1] - h[i - 2] + 2;
                if (h[i] < 0) {
                    isUp = false;
                    break;
                }
            }
            if (isUp) {
                r = h[1];
            }
            else {
                l = h[1];
            }
        }
        String s = Long.toString((long) (h[n - 1] * 100));
        if (s.equals("0")) {
            System.out.println("0.01");
            return;
        }
        if (s.substring(0, s.length() - 2).isEmpty()) {
            s = "0" + s;
        }
        System.out.println(s.substring(0, s.length() - 2) + "." + s.substring(s.length() - 2));
    }
}
