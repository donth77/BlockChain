package blockchain;

import java.util.Arrays;

public class Block {
    private int previousHash;
    private String data;
    private int hash;
    public Block(String data, int previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        // Mix the content of this block with previous hash to create the hash of this new block
        this.hash  = Arrays.hashCode(new Integer[]{data.hashCode(), previousHash});
    }
    
    public int getPreviousHash() {
    		return this.previousHash;
    }
    
    public int getHash() {
    		return this.hash;
    }
}
