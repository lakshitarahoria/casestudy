package com.accountmanagement.service;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;


public interface Service {
	boolean checkCustomerName(String name);

	boolean checkContactNumber(long contactnumber);

	boolean checkAccountType(String typeOfAccount);
	
	void accountCreation(AccountDetails name);

	AccountDetails transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws Exception, AlertsException;

	AccountDetails deposit(long accountNum, double amountToTransfer) throws Exception;

	AccountDetails withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo;
	
	AccountDetails accountDetails(long accountNum) throws IncorrectAccNo;

	ArrayList<Usertransaction> transactionHistory();
	


}
