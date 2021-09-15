package com.accountmanagement.dao;

import java.util.ArrayList;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;

public interface DaoInterface {
	void accountCreation(AccountDetails name);

	AccountDetails transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer);

	AccountDetails deposit(long accountNum, double amountToTransfer);

	AccountDetails withdraw(long accountNum, double amountToTransfer);

	ArrayList<Usertransaction> transactionHistory();
}
