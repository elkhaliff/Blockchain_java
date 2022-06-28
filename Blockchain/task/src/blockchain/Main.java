package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = Blockchain.loadData();
        Miner miner = new Miner(blockchain);

        Runtime.getRuntime().addShutdownHook(new Thread(miner::shutdown));

        for (int i = 0; i < 5; i++) {
            miner.generateBlock();
        }

        System.exit(0);

    }
}
