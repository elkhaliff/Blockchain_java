import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int three = 3;
        final int five = 5;
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        for (int i = min; i <= max; i++) {
            boolean isThree = i % three == 0;
            boolean isFive = i % five == 0;
            System.out.println(isThree && isFive ? "FizzBuzz" :
                    isThree ? "Fizz" :
                    isFive ? "Buzz" :
                    i);
        }
    }
}