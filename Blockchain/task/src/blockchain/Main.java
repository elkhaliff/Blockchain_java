package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*String prevHash = "0";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must start with: ");
        int countZero = scanner.nextInt();
        System.out.println();
        for (int i = 1; i < 6; i++) {
            Block block = new Block(i, countZero, prevHash);
            prevHash = block.getNewHash();
            System.out.println(block);
        }
        */

        Blockchain bc = Blockchain.loadData();
        Broker broker = new Broker(bc);

        Runtime.getRuntime().addShutdownHook(new Thread(broker::shutdown));

        // while (true) {
        for (int i = 0; i < 15; i++) {
            broker.generateBlock();
        }

        System.exit(0);

    }
}
