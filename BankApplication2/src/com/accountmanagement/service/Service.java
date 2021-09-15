package com.accountmanagement.service;

import java.util.ArrayList;
import java.util.Map;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;


public interface Service {
	boolean checkCustomerName(String name);

	boolean checkContactNumber(long contactnumber);

	boolean checkAccountType(String typeOfAccount);
	
	void accountCreation(AccountDetails name);

	AccountDetails transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer);

	AccountDetails deposit(long accountNum, double amountToTransfer);

	AccountDetails withdraw(long accountNum, double amountToTransfer);

	ArrayList<Usertransaction> transactionHistory();
	


}
