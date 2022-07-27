package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Block implements Serializable {
    private final Integer id;
    private transient final long minerId = Thread.currentThread().getId();

    private final int countZero;
    private final Long timeStamp;
    private long workedSeconds;
    private Long magicNumber;
    private final String prevHash;
    private final Map<String, List<HashMap<String, String>>> blockData = new HashMap<>();
    private String currHash;

    public Block(Block prevBlock, int countZero) {
        this.id = prevBlock == null ? 0 : prevBlock.getId() + 1;
        this.prevHash = prevBlock == null ? "0" : prevBlock.getCurrHash();
        this.countZero = countZero;
        magicNumber = 0L;
        timeStamp = new Date().getTime();
        workedSeconds = 0L;
        getNewHash();
    }

    private long generateNumber() {
        return  ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
    public void getNewHash() {
        String prefix = new String(new char[countZero]).replace('\0', '0');
        do {
            magicNumber = generateNumber();
            String fullField = id.toString() + magicNumber + timeStamp.toString() + prevHash;
            currHash = StringUtil.applySha256(fullField);
        } while (!currHash.substring(0, countZero).equals(prefix));
        var timeStampEnd = new Date().getTime();
        workedSeconds = (timeStampEnd - timeStamp) / 100;
    }

    public Map<String, List<HashMap<String, String>>> getBlockData() {
        return blockData;
    }
    public Long getTimeStamp() { return timeStamp; }

    public long getMinerId() { return minerId; }

    public String getCurrHash() {
        return currHash;
    }

    public long getWorkedSeconds() {
        return workedSeconds;
    }

    public Integer getId() { return id; }

    public String getPrevHash() { return prevHash; }

    @Override
    public String toString() {
        return "Block:\n" +
                String.format("Created by miner # %d\n", getMinerId()) +
                String.format("Id: %d\n", getId()) +
                String.format("Timestamp: %d\n", getTimeStamp()) +
                String.format("Magic number: %d\n", magicNumber) +
                "Hash of the previous block:\n" +
                String.format("%s\n", getPrevHash()) +
                "Hash of the block:\n" +
                String.format("%s\n", getCurrHash()) +
                String.format("Block was generating for %d seconds\n", getWorkedSeconds());
    }
}
