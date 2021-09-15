package com.accountmanagement.ui;
import java.util.Scanner;
import com.accountmanagement.service.ServiceImpl;
import com.accountmanagement.dao.Dao;

//end user interacts with client and we take info from client side and pass it to service then to dao 
public class Client {
	public static void main(String[] args) {
	//switch case for different operations
	//output required- 
//		"Welcome to Bank Application"
	System.out.println("Welcome to Bank Application");
	ServiceImpl ca=new ServiceImpl();
	Dao data=new Dao();
	Scanner sc=new Scanner(System.in);
    String cust_name;
    long mob_number;
    String acc_type;
    int accountnum;
    String branch;
    float balance;
    boolean exit=false;
    while(exit!=true)
    {
    System.out.println("1.Create Account\n2.Deposit\n3.Withdrawal\n4.Trasfer\n5.Transaction History\n6.Show Details\n7.Exit\n");
    System.out.println("Enter the choice: ");
    int choice=sc.nextInt();
    switch(choice)
    {
//	1.Account creation - 
//  further fields will be required. first is name - We need to use Regex , it has to be alphabetics only , First letter capital 
        case 1:
                System.out.println("Enter the Customer name: ");
                cust_name=sc.next();
                ca.customername(cust_name);
                
                System.out.println("Enter the Mobile Number: ");
                mob_number=sc.nextLong();
                ca.customermobile(mob_number);
                
                System.out.println("Enter the Account Type: ");
                acc_type=sc.next();
                ca.accountType(acc_type);
                
                System.out.println("Enter the Branch: ");
                branch=sc.next();
                ca.branchName(branch);
                
                System.out.println("Enter the Balance: ");
                balance=sc.nextFloat();
                //String accountType,String bankBranch,float balance,int contactNumber,String name
                data.add(acc_type,branch,balance,mob_number,cust_name);
                break;
        case 2:
            System.out.println("Enter Account Number: ");
            
            
            System.out.println("Enter Deposit Amount: ");

            
            System.out.println("Amount Deposit successful");
            System.out.println("Remaining Balance is");
            break;
        case 3:
            System.out.println("Enter Account Number: ");
            
            
            System.out.println("Enter Withdrawal Amount: ");

            
            System.out.println("Amount Withdrawal successful");
            System.out.println("Remaining Balance is");
            break;
        case 4:
            System.out.println("Enter Account Number: ");
            
            System.out.println("Enter 3rd Party Account Number: ");
            
            System.out.println("Enter Transfer Amount: ");

            
            System.out.println("Amount Transfer successful");
            System.out.println("Remaining Balance is");
            break;
       case 5:
            System.out.println("Enter Account Number: ");
            
            
            System.out.println("Transaction History:\n");

            
            System.out.println("Amount Deposit successful");
            System.out.println("Remaining Balance is");
            break;
       case 6:
           System.out.println("Enter Account Number: ");
           //accountnum=sc.nextInt();
           data.ShowDet();
           
           System.out.println("Details: \n");

           break;
       case 7:
    	   exit=true;
    	   break;
    }
}


	
	
//	2. Deposit amount
	
	// ask for account number
	//amount to be deposited
	
	//update balance 
	
//	3.Withdraw amount
	// ask for account number
		//amount to be withdrawn
		
		//update balance
	
	
//	4.Transfer to 3rd party
	
	//ask users account number
	//the 3rd party account number
	//update both balance
	
	
//	5. Show account details //user details based on account number
//	6.Show transaction history (all fund transfers)
//	7.Exit
//	
	}
}
