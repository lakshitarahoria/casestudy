package com.accountmanagement.service;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public interface Service {
	
	//Interface for processing of our application's data.

	
	//Method for checking customer name format
	boolean checkCustomerName(String name);

	//Method for checking contact number format
	boolean checkContactNumber(long contactnumber);

	//Method for checking account type format
	boolean checkAccountType(String typeOfAccount);

	//Functionality for new user account creation
	long accountCreation(AccountDetails name);

	//Functionality for fund transfer
	double transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	//Method for depositing funds
	double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo;

	//Method for withdrawing funds
	double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	//Functionality to show all customer transaction details
	ArrayList<Usertransaction> transactionHistory();

	//Method to get a customer's account details
	AccountDetails getUserData(long accountNumber);

}
