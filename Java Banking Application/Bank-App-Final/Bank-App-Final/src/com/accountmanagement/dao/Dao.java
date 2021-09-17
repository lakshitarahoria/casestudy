package com.accountmanagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

/**
* The DAO program implements an interface that
* deals with data access and managing data source structures and operations
*/


public class Dao implements DaoInterface {

	int transactionId = 100; // Transaction ID initialization
	
	public final int minBalance = 5000; // Minimum Opening Balance = 5000
	
	
	//Collections for storing customer data and transaction Data
	HashMap<Long, AccountDetails> customerData = new HashMap<Long, AccountDetails>();
	HashMap<Usertransaction, Long> transaction = new HashMap<Usertransaction, Long>();
	
	long key = 1000; //Account Number initialization

	@Override
	public long accountCreation(AccountDetails account) {
		customerData.put(++key, account); //auto-updating account number
		return key;

	}

	@Override
	public double transfer(long debitAccNum, long creditorAccNum, double amountToTransfer)
			throws IncorrectAccNo, AlertsException {
		
		double finalBalance = 0;
		
		if (customerData.containsKey(debitAccNum) && customerData.containsKey(creditorAccNum)) {
			AccountDetails debiter = customerData.get(debitAccNum);
			AccountDetails creditor = customerData.get(creditorAccNum);
			
			if (debiter.getBalance() < amountToTransfer) {
				throw new AlertsException();
			} else {
				debiter.setBalance(debiter.getBalance() - amountToTransfer);
				creditor.setBalance(creditor.getBalance() + amountToTransfer);
				finalBalance = debiter.getBalance();
				Usertransaction fundTransfer = new Usertransaction(new Date(),transactionId++, debitAccNum, creditorAccNum,
						amountToTransfer,  finalBalance, "Deposit");
				transaction.put(fundTransfer, debitAccNum);
			}
		} else {
			throw new IncorrectAccNo();
		}
		return finalBalance;
	}

	@Override
	public double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo {
		double finalBalance = 0;
		double result = 0;
		if (customerData.containsKey(accountNum)) {

			AccountDetails customer = customerData.get(accountNum);
			customer.setBalance(customer.getBalance() + amountToTransfer);
			finalBalance = customer.getBalance();

			result = finalBalance;
		}

		else {
			throw new IncorrectAccNo();
		}

		Usertransaction fundTransfer = new Usertransaction(new Date(),transactionId++, accountNum, 0, amountToTransfer, 
				finalBalance, "Deposit");
		transaction.put(fundTransfer, accountNum);
		return result;
	}

	
	
	@Override
	public double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException {
		double result = 0;
		double finalBalance = 0;
		if (customerData.containsKey(accountNum)) { 
			if (customerData.get(accountNum).getBalance() > amountToTransfer) { 
				AccountDetails customer = customerData.get(accountNum);
				customer.setBalance(customer.getBalance() - amountToTransfer);
				finalBalance = customer.getBalance();
				result = finalBalance;
				Usertransaction fundTransfer = new Usertransaction(new Date(),transactionId++, 0, accountNum, amountToTransfer,
						 finalBalance, "Withdrawal");
				transaction.put(fundTransfer, accountNum);
			} else {
				throw new AlertsException();
			}

		} else {
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
	public AccountDetails getUserData(long accountNumber) {

		return customerData.get(accountNumber);
	}

}
