import java.util.ArrayList;
public class BlockChain {
    public static ArrayList<Block> blockchain=new ArrayList<Block>();
    public static int difficulty = 0;

    public static Block createGenesisBlock()
    {
        return new Block("Genesis Block","","","","",0,0,0,0,"0");
    }

    public static Boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;
        String hashTarget=new String(new char[difficulty]).replace('\0','0');

        for (int i=1;i<blockchain.size();i++) 
        {
            currentBlock=blockchain.get(i);
            previousBlock=blockchain.get(i - 1);
            if(!currentBlock.hash.equals(currentBlock.calculateHash())) 
            {
                System.out.println("Hashes are not equal");
                return false;
            }
            if(!previousBlock.hash.equals(currentBlock.previousHash)) 
            {
                System.out.println( "Previous Hashes are not equal");
                return false;
            }
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) 
            {
				System.out.println("This block is not mined.");
				return false;
			}
        }
        return true;
    }   
}

