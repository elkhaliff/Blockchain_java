import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> words = IntStream.range(0, count).mapToObj(i ->
                        scanner.nextLine().toLowerCase())
                .collect(Collectors.toCollection(HashSet::new));

        count = Integer.parseInt(scanner.nextLine());
        Set<String> input = IntStream.range(0, count).mapToObj(i ->
                        List.of(scanner.nextLine().toLowerCase().split("\\s+")))
                .flatMap(Collection::stream)
                .filter(s -> !words.contains(s))
                .collect(Collectors.toSet());
        input.forEach(System.out::println);
    }
}