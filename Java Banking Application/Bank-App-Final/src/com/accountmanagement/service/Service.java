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

	long accountCreation(AccountDetails name);

	double transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo;

	double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	ArrayList<Usertransaction> transactionHistory();

	AccountDetails getUserData(long accountNumber);

}
