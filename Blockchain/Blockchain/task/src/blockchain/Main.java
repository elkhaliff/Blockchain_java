package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String prevHash = "0";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must start with: ");
        int zerroCnt = scanner.nextInt();
        System.out.println();
        for (int i = 1; i < 6; i++) {
            Block block = new Block(i, zerroCnt, prevHash);
            prevHash = block.getNewHash();
            System.out.println(block);
        }
    }
}
