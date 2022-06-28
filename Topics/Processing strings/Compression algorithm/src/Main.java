import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        char curr = chars[0];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (curr == aChar) {
                cnt++;
            } else {
                sb.append(curr).append(cnt);
                curr = aChar;
                cnt = 1;
            }
        }
        sb.append(curr).append(cnt);
        System.out.println(sb);
    }
}