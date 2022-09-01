import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean test = true;
        BiPredicate<Integer, Integer> predicate = (a, b) -> a == m && b == n || b == m && a == n;
        test = IntStream.range(1, count)
                .noneMatch(i -> predicate.test(arr[i - 1], arr[i]));

        System.out.println(test);
    }
}