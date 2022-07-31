import java.util.*;
public class practice{
    private static String HR_ID;
    private static String password;
	public static void main(String[] args)
	{
        System.out.println("-----------HR LOGIN----------------------");
		System.out.print("Enter HR_ID:");
        Scanner sc = new Scanner(System.in);
        HR_ID=sc.next();
        System.out.print("Enter password:");
        password=sc.next();
        if(HR_ID.equals("user") && password.equals("user"))
        {
            int choice=-1;
            while(choice!=4)
            {
                System.out.println();
                System.out.println();
                System.out.println("-------Employee Verification----------");
                System.out.println("1.View Employee Feedback Details");
                System.out.println("2.Give Feedback");
                System.out.println("3.Check validity of Block Chain");
                System.out.println("4.Modify data and Check validity");
                System.out.println("5.Logout");
                System.out.println("Enter your choice:");
                choice=sc.nextInt();
                if(choice==1)
                    practice.viewFeedback();
                else if(choice==2)
                    practice.giveFeedback();
                else if(choice==3)
                    practice.checkValidity();
                else if(choice==4)
                {
                    if(BlockChain.blockchain.size()>1){
                    System.out.println("Change name of first employee..Enter new name:"); 
                    String newName=sc.next();
                    BlockChain.blockchain.get(1).name=newName;
                    practice.checkValidity();
                    continue;
                    }
                    System.out.println("Block chain is Empty");
                }
                else if(choice==4)
                    System.out.println("Logging out");
                else
                    System.out.println("Invalid choice...Please enter valid choice");   
            }
        }
        else{System.out.println("Invalid Credentials");}
        return;
	}
    public static void viewFeedback()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------View Feedback of an Employee-----------");
        System.out.println("Enter the email of the employee:");
        String findEmail=sc.next();
        boolean flag=false;
        for (int i = 1; i < BlockChain.blockchain.size(); i++)
        {
            if(BlockChain.blockchain.get(i).email.equals(findEmail))
            {
                flag=true;
                System.out.println("------------Employee Feedback-------------");
                System.out.printf("Name : %s\n",BlockChain.blockchain.get(i).name);
                System.out.printf("Email : %s\n",BlockChain.blockchain.get(i).email);
                System.out.printf("Company : %s\n",BlockChain.blockchain.get(i).company);
                System.out.printf("Designation : %s\n",BlockChain.blockchain.get(i).designation);
                System.out.printf("Years/Months Worked : %s\n",BlockChain.blockchain.get(i).years);
                System.out.printf("Project Count : %d\n",BlockChain.blockchain.get(i).pCount);
                System.out.printf("Technical skills : %.1f (out of 10)\n",BlockChain.blockchain.get(i).techSkills);
                System.out.printf("Communicational skills : %.1f (out of 10)\n",BlockChain.blockchain.get(i).commSkills);
                System.out.printf("Behaviour:%.1f (out of 10)\n",BlockChain.blockchain.get(i).behaviour);
            }
            System.out.println();
        }
        if(!flag) {System.out.println("No employee found");}
    }
    public static void giveFeedback()
    {
        if(BlockChain.blockchain.size()==0)
        {
            BlockChain.blockchain.add(BlockChain.createGenesisBlock());
            BlockChain.blockchain.get(0).mineBlock(BlockChain.difficulty);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Give Feedback to an Employee-----------");
        System.out.println("Enter the name of the employee:");
        String name=sc.nextLine();
        System.out.println("Enter the email of the employee:");
        String email=sc.nextLine();
        System.out.println("Enter the Company name");
        String company=sc.nextLine();
        System.out.println("Enter Designation of the employee:");
        String designation=sc.nextLine();
        System.out.println("Years/Months worked:");
        String years=sc.nextLine();
        System.out.println("Enter Project Count:");
        int pCount=sc.nextInt();
        System.out.println("Rating to Technical Skills(out of 10):");
        float techSkills=sc.nextFloat();
        System.out.println("Rating to Communicational Skills(out of 10):");
        float commSkills=sc.nextFloat();
        System.out.println("Rating to Behaviour(out of 10):");
        float behaviour=sc.nextFloat();
        BlockChain.blockchain.add(new Block(name,email,company,designation,years,pCount,techSkills,commSkills,behaviour,BlockChain.blockchain.get(BlockChain.blockchain.size() - 1).hash));
        BlockChain.blockchain.get(BlockChain.blockchain.size()-1).mineBlock(BlockChain.difficulty);
    }
    public static void checkValidity()
    {
        if(BlockChain.isChainValid())
            System.out.println("BlockChain is Valid");
        else
            System.out.println("BlockChain is InValid");
    }    
}
