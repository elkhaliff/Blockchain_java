package blockchain;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Broker {
    private final Blockchain blockchain;
    private final int poolSize = Runtime.getRuntime().availableProcessors();
    private final ExecutorService execPool = Executors.newFixedThreadPool(poolSize);

    public Broker(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    private final List<Callable<Void>> workers = IntStream.range(0, Runtime.getRuntime().availableProcessors())
            .mapToObj(ignored -> new Callable<Void>() {
                @Override
                public Void call() {
                    blockchain.nextBlock(
                            new Block(blockchain.getLastBlock(), blockchain.getHashZeros()), true);
                    return null;
                }
            })
            .collect(Collectors.toList());
    void generateBlock() {
        try {
            // it's invokeAll, but I don't want my processor to suffocate
            execPool.invokeAny(workers);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    void shutdown() {
        execPool.shutdownNow();
    }
}
