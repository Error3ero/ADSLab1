public class Task1C {
    static class Pair {
        private final int a;
        private final int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public static Pair copy(Pair p) {
            return new Pair(p.getA(), p.getB());
        }

        public Pair[] arrCopy(Pair[] arr) {
            Pair[] res = new Pair[arr.length];
            for (int i = 0; i < arr.length; i++) {
                res[i] = Pair.copy(arr[i]);
            }
            return res;
        }
    }


}