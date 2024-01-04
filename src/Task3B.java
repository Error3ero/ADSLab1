import java.util.Arrays;
import java.util.Scanner;

public class Task3B {
    static class Queue {
        private final int MAX_SIZE = 100;
        private int[] items;
        private int front;
        private int last;
        private int size;

        public Queue() {
            items = new int[MAX_SIZE];
            front = -1;
            last = -1;
            size = 0;
        }


        public void push(int n) {
            if (last == MAX_SIZE - 1) {
                pushBack(front, last);
            }
            System.out.println("ok");
            items[++last] = n;
            size++;
            front = front == -1 ? 0 : front;
        }

        public void pop() {
            System.out.println(items[front++]);
            size--;
            if (size == 0) {
                last = -1;
                front = -1;
            }
        }

        public void front() {
            System.out.println(items[front]);
        }

        public void size() {
            System.out.println(size);
        }

        public void clear() {
            items = new int[MAX_SIZE];
            size = 0;
            last = -1;
            front = -1;
            System.out.println("ok");
        }

        private void pushBack(int from, int to) {
            int[] res = new int[MAX_SIZE];
            for (int i = from; i <= to; i++) {
                res[i - from] = items[i];
            }
            items = res;
            last = size - 1;
            front = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        while (true) {
            switch (sc.next()) {
                case "push":
                    queue.push(sc.nextInt());
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "front":
                    queue.front();
                    break;
                case "size":
                    queue.size();
                    break;
                case "clear":
                    queue.clear();
                    break;
                case "exit":
                    System.out.println("bye");
                    sc.close();
                    return;
            }
        }
    }
}
