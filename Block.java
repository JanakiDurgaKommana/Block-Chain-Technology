import java.util.Date;

public class Block {

    public String name;
    public String email;
    public String company;
    public String designation;
    public String years;
    public int pCount;
    public float techSkills;
    public float commSkills;
    public float behaviour;
   
    public String previousHash; 
    private long timeStamp;
    public String hash; 

    private int nonce;

    public Block(String name,String email,String company,String designation,String years,int pCount,
    float techSkills,float commSkills,float behaviour,String previousHash) 
    { 
        
        this.name=name;
        this.email=email;
        this.company=company;
        this.designation=designation;
        this.years=years;
        this.pCount=pCount;
        this.techSkills=techSkills;
        this.commSkills=commSkills;
        this.behaviour=behaviour;
        this.previousHash =previousHash;
        this.timeStamp=new Date().getTime(); 
        this.hash=calculateHash(); 

    } 
    public String calculateHash() 
    { 
        String calculatedhash=Hashing.sha256(previousHash + Long.toString(timeStamp) + name + email + company+ 
        designation + Integer.toString(pCount)+ Float.toString(techSkills)+
        Float.toString(commSkills)+Float.toString(behaviour)); 
        return calculatedhash; 
    }
    public void mineBlock(int difficulty) {
		String target=new String(new char[difficulty]).replace('\0', '0');
		while(!hash.substring(0,difficulty).equals(target))
        {
			nonce ++;
			hash=calculateHash();
		}
        if(BlockChain.blockchain.size()>1) System.out.println("Block Mined ( Added to Block chain ) Successfully : ");
	}
} 
    
