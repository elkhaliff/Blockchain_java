import java.util.Scanner;     

class ArrayCalc {

    public static class MinMaxPair {
        private int min;
        private int max;

        public MinMaxPair(int first, int second) {
            this.min = first;
            this.max = second;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

    public static MinMaxPair findMinMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i: array) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return new MinMaxPair(min, max);
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int magicNumber = 10;

        // input array 
        int[] array = new int[magicNumber];
        for (int i = 0; i < magicNumber; i++) {
            array[i] = scanner.nextInt();
        }

        ArrayCalc.MinMaxPair p = ArrayCalc.findMinMax(array);

        System.out.println("min = " + p.getMin());
        System.out.println("max = " + p.getMax());
    }
}