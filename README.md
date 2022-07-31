# Block-Chain-Technology
Employee Verification using Block Chain Technology
----------------------------------------------------------
The Main aim of this project is to learn about Block Chain Technology and to provide an basic application which will be useful to the external world. “Employee verification” is an application that provides feedback of an employee to the HR Professional when an employee comes for a job just by using employee's email ID (unique)

In this application, the HR Professionals have following functionalities:
1. He can get feedback of an employee from the companies he worked in past.
2. He can give feedback to a particular employee.

and other functionalities like Validating block chain and Mining blocks are also present.

Block Chain technology is used for securely storing the feedback.

Assumption: 
- I assume that the HR professionals are genuine and give feedback correctly because once the block is created even the HR can't able to change or erase anything.
------------------------------------------------------------
Developed in: JAVA
------------------------------------------------------------
Practice.java (main file)
---------------------------------------------------------------
Input: HR_ID and password ( By default I have taken HR_ID = user and Password = user as I have not connected this application with database).

Output: Various functionalities availble to the HR will be displayed. He can choose from 

- View Employee Feedback Details:
     HR can able to see all the details (Feedback) related to an employee by using employee's email id.

- Give Feedback :
     If our blockchain is initially empty we will create a genesis block and we will add new block with all the details given by the HR about an employee.

- Check validity of Block Chain :
     This function is to check whether the information contained in Block Chain is valid or not. If the information in blockchain is removed or modified then this function returns false which means the block chain is not valid.

- Modify data and Check validity :
   This function is not acutally provided to HR in real world. I have just added it to check how the checkvalidity() function is working when data is changed in block chain.

----------------------------------------------------------------------
Block.java
----------------------------------------------------------------------
- This file contains Block class which stores all the information related to an employee. 
- It has a constructor that is called when object is created to it and assigns attibutes of class.
- It has calculateHash() function that uses  sha256 method in Hashing class (Hashing.java file - which uses inbuilt functionalities available in java to compute the hash of the block).
- It has mineBlock() function that finds the perfect nonce required to mine a block.
-----------------------------------------------------------------------
BlockChain.java
------------------------------------------------------------------------
- BlockChain class we maintain chain of blocks by using arrayList and it has a function to create a genesis block.
- As every block contains it's hash and it's previous block hash. We use this concept to check whether block is valid or not in isChainValid() function.
- Difficulty attribute in this class is used in mineBlock() function of Block class (Block.java) . I set this attribute to 0 to mine blocks easily. For testing it is better to chose a value>4 which takes some time to mine a block. In real world this value is a large no.
------------------------------------------------------------------------
Future scope: 
- I have implemented basic concepts of Block chain to understand them better. We can add database, frontend, Validations, Transaction management, Giving rewards to miners for publishing blocks etc.
------------------------------------------------------------------------
