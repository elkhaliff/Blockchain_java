import java.util.Scanner;

class Main {
    private static int getDesk(int group) {
        return group % 2 + group / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group1 = scanner.nextInt();
        int group2 = scanner.nextInt();
        int group3 = scanner.nextInt();
        System.out.println(getDesk(group1) + getDesk(group2) + getDesk(group3));
    }
}