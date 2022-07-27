package blockchain;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Miner {
    private final Blockchain blockchain;
    private final int poolSize = Runtime.getRuntime().availableProcessors();
    private final ExecutorService execPool = Executors.newFixedThreadPool(poolSize);

    public Miner(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    private final List<Callable<Void>> miners = IntStream.range(0, Runtime.getRuntime().availableProcessors())
            .mapToObj(ignored -> new Callable<Void>() {
                @Override
                public Void call() {
                    Block block = blockchain.getLastBlock();
                    blockchain.nextBlock(
                            new Block(block, blockchain.getCountZero()), true);
                    return null;
                }
            })
            .collect(Collectors.toList());

    public boolean generateBlock() {
        try {
            execPool.invokeAny(miners);
            return blockchain.getCurrentCount() < 5;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    void shutdown() {
        execPool.shutdownNow();
    }
}
