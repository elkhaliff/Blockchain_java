import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int step = 3;
        var year = scanner.nextInt();
        for (int i = 0; i < step; i++) {
            System.out.println(LocalDate.ofYearDay(year, scanner.nextInt()));
        }
    }
}