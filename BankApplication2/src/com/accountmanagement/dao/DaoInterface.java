package com.accountmanagement.dao;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public interface DaoInterface {
	void accountCreation(AccountDetails name);

	AccountDetails transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws Exception, AlertsException;

	AccountDetails deposit(long accountNum, double amountToTransfer) throws Exception, IncorrectAccNo;

	AccountDetails withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo;
	
	AccountDetails accountDetails(long accountNum) throws IncorrectAccNo;

	ArrayList<Usertransaction> transactionHistory();
}
