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
	long key = 1000;

	@Override
	public long accountCreation(AccountDetails account) {
		// TODO Auto-generated method stub

		customerData.put(++key, account);
		return key;

	}

	@Override
	public double transfer(long debitAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException {
		double finalBalance = 0;
			if (customerData.containsKey(debitAccNum) && customerData.containsKey(creditorAccNum)) {
				AccountDetails debiter = customerData.get(debitAccNum);
				AccountDetails creditor = customerData.get(creditorAccNum);
				if (debiter.getBalance() < amountToTransfer) {
					throw new AlertsException();
				}
				else {
					debiter.setBalance(debiter.getBalance() - amountToTransfer);
					creditor.setBalance(creditor.getBalance() + amountToTransfer);
					finalBalance = debiter.getBalance();
					Usertransaction fundTransfer = new Usertransaction(transactionId++, debitAccNum, creditorAccNum,
							amountToTransfer, new Date(), finalBalance, "Deposit");
					transaction.put(fundTransfer, debitAccNum);}
			}
			else {
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

		Usertransaction fundTransfer = new Usertransaction(transactionId++, accountNum, 0, amountToTransfer, new Date(),
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
				Usertransaction fundTransfer = new Usertransaction(transactionId++, 0, accountNum, amountToTransfer,
						new Date(), finalBalance, "Withdrawal");
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

	// defining our data structure to be used, and operations related with the same

}
