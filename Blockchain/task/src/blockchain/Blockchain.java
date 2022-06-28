package blockchain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

public class Blockchain implements Serializable {
    private int countZero = 0;
    private final Deque<Block> chain = new LinkedList<>();
    public static final String SERIAL_FILE_NAME = "data.dat";

    public Blockchain() {
    }

    private void saveData() {
        try {
            SerializationUtils.serialize(this, SERIAL_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Blockchain loadData() {
        File tempFile = new File(SERIAL_FILE_NAME);
        if (tempFile.exists()) {
            try {
                Blockchain bc = (Blockchain) SerializationUtils.deserialize(SERIAL_FILE_NAME);
                if (bc.verify()) {
                    return bc;
                }
            } catch (IOException | ClassNotFoundException ignored) {
                System.out.println("No data.");
            }
        }
        return new Blockchain();
    }

    public Block getLastBlock() {
        return chain.peekLast();
    }

    public Deque<Block> getChain() {
        return chain;
    }

    public boolean verify() {
        return true;
    }

    public synchronized void nextBlock(Block block, boolean check) {
        if (block == null
                || !block.getCurrHash().startsWith(StringUtil.repeat('0', countZero))
                || !block.getPrevHash().equals(chain.peekLast() != null ? chain.peekLast().getCurrHash() : "0")
                // || !block.getBlockData().isEmpty()
        ) {
            return;
        }

        /* if (block.acceptData(serviceData)) {
            serviceData.clear();
        }*/

        int shiftZero = 0;
        if (block.getWorkedSeconds() < 10L) {
            countZero++;
            shiftZero++;
        } else if (block.getWorkedSeconds() > 15L) {
            countZero--;
            shiftZero--;
        }

        if (check) {
            System.out.print(block);
            if (shiftZero > 0) {
                System.out.printf("N was increased to %d\n\n", countZero);
            } else if (shiftZero < 0) {
                System.out.printf("N was decreased to %d\n\n", countZero);
            } else {
                System.out.print("N stays the same\n\n");
            }
        }

        chain.addLast(block);
        saveData();
    }

    public int getCountZero() {
        return countZero;
    }
}
