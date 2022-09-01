import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int count = scanner.nextInt();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int key = scanner.nextInt();
            String value = scanner.nextLine().trim();
            if (key >= min && key <= max) {
                map.put(key, value);
            }
        }
        map.forEach((k, val) -> System.out.println(k + " " + val));
    }
}