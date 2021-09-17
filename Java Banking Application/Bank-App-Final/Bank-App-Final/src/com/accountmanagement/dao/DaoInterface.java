package com.accountmanagement.dao;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

//Interface to manage data access objects and abstracting the details of data source structure.

public interface DaoInterface {
	
	//Method for New User Account Creation
	public long accountCreation(AccountDetails AccountDetails);

	//Method for fund transfer from one account to other
	double transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	// Method for depositing fund in a given account number
	double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo;

	// Method for withdrawing funds from a given account number
	double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	//Shows the transaction history of all users
	ArrayList<Usertransaction> transactionHistory();

	//Method for showing user account information 
	AccountDetails getUserData(long accountNumber);

}
