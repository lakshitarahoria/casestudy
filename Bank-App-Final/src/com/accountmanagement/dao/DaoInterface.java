package com.accountmanagement.dao;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public interface DaoInterface {
	public long accountCreation(AccountDetails AccountDetails);

	double transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo;

	double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException;

	ArrayList<Usertransaction> transactionHistory();

	AccountDetails getUserData(long accountNumber);

}
