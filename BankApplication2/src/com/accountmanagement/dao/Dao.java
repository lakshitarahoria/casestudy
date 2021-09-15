//package com.accountmanagement.dao;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//import java.util.function.Consumer;
//
//import com.accountmanagement.model.AccountDetails;
//import com.accountmanagement.model.Usertransaction;
//
//
//public class Dao implements DaoInterface {
//
//	int transactionId=100;
//	public final int minBalance=5000;
//	HashMap<Long, AccountDetails> customerData=new HashMap<Long, AccountDetails>();
//	HashMap<Usertransaction,Long> transaction=new HashMap<Usertransaction,Long>();
//	
//	
//	@Override
//	public void accountCreation(AccountDetails customer) {
//		// TODO Auto-generated method stub
//		
//		customerData.put(customer.getAccountNumber(), customer);
//		
//	}
//
//	@Override
//	public AccountDetails transfer(long debitAccNum, long creditorAccNum, double amountToTransfer) {
//		// TODO Auto-generated method stub
//		double finalBalance=0;
//		
//		AccountDetails result = null;
//		if(customerData.containsKey(debitAccNum) && customerData.containsKey(creditorAccNum) ) {
//			
//		AccountDetails debiter=customerData.get(debitAccNum); 
//		AccountDetails creditor=customerData.get(creditorAccNum); 
//		if(debiter.getBalance()>amountToTransfer) {
//		debiter.setBalance(debiter.getBalance()-amountToTransfer);
//		creditor.setBalance(creditor.getBalance()+amountToTransfer);
//		result=debiter;
//		}
//		else {
//			System.out.println("insufficient balance"); //exception handling can be
//		}}
//		
//		
//		else {
//			System.out.println("Either debitor or creditor AccNum is incorrect");
//			//exception handling can be done
//		}
//		Usertransaction fundTransfer= new Usertransaction(transactionId++,debitAccNum,creditorAccNum,amountToTransfer,new Date(),finalBalance,"Deposit");
//		transaction.put(fundTransfer,debitAccNum);
//		return result;
//	
//		
//	}
//
//	@Override
//	public AccountDetails deposit(long accountNum, double amountToTransfer) {
//		double finalBalance=0;
//		AccountDetails result = null;
//		if(customerData.containsKey(accountNum)) {
//			
//			AccountDetails customer=customerData.get(accountNum); 
//			customer.setBalance(customer.getBalance()+amountToTransfer);
//			finalBalance=customer.getBalance();	
//			
//			result= customer;
//			}
//			
//			else {
//				System.out.println("Either depositor or creditor AccNum is incorrect");
//				 //exception handling can be done
//			}
//		
//		Usertransaction fundTransfer= new Usertransaction(transactionId++,accountNum,0,amountToTransfer,new Date(),finalBalance,"Deposit");
//		transaction.put(fundTransfer,accountNum);
//		return result;
//	}
//
//	@Override
//	public AccountDetails withdraw(long accountNum, double amountToTransfer) {
//		AccountDetails result = null;
//		double finalBalance=0;
//		if(customerData.containsKey(accountNum)) {
//			if(customerData.get(accountNum).getBalance()> amountToTransfer) {
//			AccountDetails customer=customerData.get(accountNum); 
//			customer.setBalance(customer.getBalance()-amountToTransfer);
//			finalBalance=customer.getBalance();		
//			result= customer;
//			}
//		else {
//				System.out.println("insufficient balance"); //exception handling can be
//		}}
//		else {
//			System.out.println("Either depositor or creditor AccNum is incorrect");
//			
//		}
//		Usertransaction fundTransfer= new Usertransaction(transactionId++,0,accountNum,amountToTransfer,new Date(),finalBalance,"Withdrawal");
//		transaction.put(fundTransfer,accountNum);
//		return result;
//	}
//
//	@Override
//	public ArrayList<Usertransaction> transactionHistory() {
//		Set<Usertransaction> transactionsDone=transaction.keySet();
//		ArrayList<Usertransaction> list=new ArrayList<Usertransaction>();
//		list.addAll(transactionsDone);
//        return list;
//		
//	}}


package com.accountmanagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public class Dao implements DaoInterface {

	int transactionId = 100;
	public final int minBalance = 5000;
	HashMap<Long, AccountDetails> customerData = new HashMap<Long, AccountDetails>();
	HashMap<Usertransaction, Long> transaction = new HashMap<Usertransaction, Long>();

	@Override
	public void accountCreation(AccountDetails customer) {
		// TODO Auto-generated method stub

		customerData.put(customer.getAccountNumber(), customer);

	}

	@Override
	public AccountDetails transfer(long debitAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo{
		double finalBalance = 0;
		AccountDetails result = null;
		try {
			if (customerData.containsKey(debitAccNum) && customerData.containsKey(creditorAccNum)) {
				AccountDetails debiter = customerData.get(debitAccNum);
				AccountDetails creditor = customerData.get(creditorAccNum);

				if (debiter.getBalance() < amountToTransfer){
					throw new AlertsException();
				} else
				{
					debiter.setBalance(debiter.getBalance() - amountToTransfer);
					creditor.setBalance(creditor.getBalance() + amountToTransfer);
					result = debiter;
					Usertransaction fundTransfer = new Usertransaction(transactionId++, debitAccNum, creditorAccNum,
							amountToTransfer, new Date(), finalBalance, "Deposit");
					transaction.put(fundTransfer, debitAccNum);
				}
			}
		} catch (Exception e) {
			throw new IncorrectAccNo();
		}
		return result;
	}

	@Override
	public AccountDetails deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo {
		double finalBalance = 0;
		AccountDetails result = null;
		try {
			if (customerData.containsKey(accountNum)) {

				AccountDetails customer = customerData.get(accountNum);
				customer.setBalance(customer.getBalance() + amountToTransfer);
				finalBalance = customer.getBalance();

				result = customer;
			}
			Usertransaction fundTransfer = new Usertransaction(transactionId++, accountNum, 0, amountToTransfer,
					new Date(), finalBalance, "Deposit");
			transaction.put(fundTransfer, accountNum);
		} catch (Exception e) {
			throw new IncorrectAccNo();
		}
		return result;
	}

	@Override
	public AccountDetails withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo{
		AccountDetails result = null;
		double finalBalance = 0;
		try {
			if (customerData.containsKey(accountNum)) {
				if (customerData.get(accountNum).getBalance() > amountToTransfer) {
					AccountDetails customer = customerData.get(accountNum);
					customer.setBalance(customer.getBalance() - amountToTransfer);
					finalBalance = customer.getBalance();
					result = customer;
					Usertransaction fundTransfer = new Usertransaction(transactionId++, 0, accountNum, amountToTransfer,
							new Date(), finalBalance, "Withdrawal");
					transaction.put(fundTransfer, accountNum);
				} else {
					throw new AlertsException();
				}
			}
		} catch (Exception e) {
			throw new IncorrectAccNo();
		}
		return result;
	}

	@Override
	public ArrayList<Usertransaction> transactionHistory() {
		Set<Usertransaction> transactionsDone = transaction.keySet();
		ArrayList<Usertransaction> list = new ArrayList<Usertransaction>();
		list.addAll(transactionsDone);
		return list;

	}

	@Override
	public AccountDetails accountDetails(long accountNum) throws IncorrectAccNo {
		AccountDetails result = null;
		try {
			if (customerData.containsKey(accountNum)) {
				AccountDetails r1 = new AccountDetails(accountNum);
				r1.toString();
				result = r1;
			}
		} catch (Exception e) {
			throw new IncorrectAccNo();
		}
		return result;
	}

	

}

