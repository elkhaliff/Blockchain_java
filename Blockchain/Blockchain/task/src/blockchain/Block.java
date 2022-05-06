package blockchain;

import java.util.Date;

public class Block {
    private final Integer id;
    private final Long timeStamp;
    private final String prevHash;

    private String currHash;

    public Block(int id, String prevHash) {
        this.id = id;
        this.prevHash = prevHash;
        timeStamp = new Date().getTime();
    }

    public String getNewHash() {
        String fullField = id.toString() + timeStamp.toString() + prevHash;
        currHash = StringUtil.applySha256(fullField);
        return currHash;
    }

    @Override
    public String toString() {
        return "Block:\n" +
                String.format("Id: %d\n", id) +
                String.format("Timestamp: %d\n", timeStamp) +
                "Hash of the previous block:\n" +
                String.format("%s\n", prevHash) +
                "Hash of the block:\n" +
                String.format("%s\n", currHash);
    }
}
