package blockchain;

import java.util.ArrayList;
import java.util.List;
public class BlockChain {
    public static void main(String[] args) {
        List<Block> blockChainList =  new ArrayList<>();
        Block genesis = new Block("BlockChain", 0);
        blockChainList.add(genesis);
        Block welcomeBlock = new Block("Welcome", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(welcomeBlock);
        Block toBlock = new Block("To", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(toBlock);
        Block theBlock = new Block("The", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(theBlock);
        Block worldBlock = new Block("World", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(worldBlock);
        Block ofBlock = new Block("Of", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(ofBlock);
        Block blockChainBlock = new Block("BlockChain", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(blockChainBlock);
        
        System.out.println("---------------------");
        System.out.println("- BlockChain -");
        System.out.println("---------------------");
        blockChainList.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Is valid?: " + validate(blockChainList));
        System.out.println("---------------------");
        
        // corrupt blockchain by modifying one of the block
        Block corruptBlock = new Block("Corruption", genesis.getHash());
        int index = blockChainList.indexOf(welcomeBlock);
        blockChainList.remove(index);
        blockChainList.add(index, corruptBlock);
        System.out.println("Corrupted block chain by replacing 'Welcome' block with 'Corruption' Block");
        System.out.println("---------------------");
        System.out.println("- BlockChain -");
        System.out.println("---------------------");
        blockChainList.forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println("Is valid?: " + validate(blockChainList));
        System.out.println("---------------------");
    }
    private static boolean validate(List<Block> blockChain) {
        boolean result = true;
        Block lastBlock = null;
        for(int i = blockChain.size() -1; i >= 0; i--) {
            if(lastBlock == null) {
                lastBlock = blockChain.get(i);
            }
            else {
                Block current = blockChain.get(i);
                if(lastBlock.getPreviousHash() != current.getHash()) {
                    result = false;
                    break;
                }
                lastBlock = current;
            }
        }
        return result;
    }
}