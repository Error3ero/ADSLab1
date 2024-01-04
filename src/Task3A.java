import java.util.Scanner;

public class Task3A {
    static class Stack {
        private final int[] storage;
        private int size;

        public Stack() {
            storage = new int[1 << 7];
            size = 0;
        }

        public void push(int n) {
            storage[size++] = n;
            System.out.println("ok");
        }

        public void pop() {
            System.out.println(storage[--size]);
        }

        public void back() {
            System.out.println(storage[size - 1]);
        }

        public void size() {
            System.out.println(size);
        }

        public void clear() {
            size = 0;
            System.out.println("ok");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        while (true) {
            switch (sc.next()) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "back":
                    stack.back();
                    break;
                case "size":
                    stack.size();
                    break;
                case "clear":
                    stack.clear();
                    break;
                case "exit":
                    sc.close();
                    System.out.println("bye");
                    return;
            }
        }
    }
}
