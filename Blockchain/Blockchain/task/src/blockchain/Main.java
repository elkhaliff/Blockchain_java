package blockchain;

public class Main {
    public static void main(String[] args) {
        String prevHash = "0";
        for (int i = 1; i < 6; i++) {
            Block block = new Block(i, prevHash);
            prevHash = block.getNewHash();
            System.out.println(block);
        }
    }
}
