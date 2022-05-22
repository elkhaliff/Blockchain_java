package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Block implements Serializable {
    private final Integer id;
    private final int countZero;
    private final Long timeStamp;
    private long workedSeconds;
    private Long magicNumber;
    private final String prevHash;

    private String currHash;

    public Block(Integer prevId, String prevHash, int countZero) {
        this.id = prevId == null ? 0 : prevId + 1;
        this.countZero = countZero;
        this.prevHash = prevHash;
        magicNumber = 0L;
        timeStamp = new Date().getTime();
        workedSeconds = 0L;
    }

    private long generateNumber() {
        return  ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
    public String getNewHash() {
        String prefix = new String(new char[countZero]).replace('\0', '0');
        do {
            magicNumber = generateNumber();
            String fullField = id.toString() + magicNumber + timeStamp.toString() + prevHash;
            currHash = StringUtil.applySha256(fullField);
        } while (!currHash.substring(0, countZero).equals(prefix));
        var timeStampEnd = new Date().getTime();
        workedSeconds = (timeStampEnd - timeStamp) / 1000;
        return currHash;
    }

    @Override
    public String toString() {
        return "Block:\n" +
                String.format("Id: %d\n", id) +
                String.format("Timestamp: %d\n", timeStamp) +
                String.format("Magic number: %d\n", magicNumber) +
                "Hash of the previous block:\n" +
                String.format("%s\n", prevHash) +
                "Hash of the block:\n" +
                String.format("%s\n", currHash) +
                String.format("Block was generating for %d seconds\n", workedSeconds);
    }

    public String getCurrHash() {
        return currHash;
    }

    public long getWorkedSeconds() {
        return workedSeconds;
    }

    public Integer getId() {
        return id;
    }

    public String getPrevHash() {
        return prevHash;
    }
}
