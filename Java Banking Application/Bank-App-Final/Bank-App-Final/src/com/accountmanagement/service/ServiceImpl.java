package com.accountmanagement.service;

import java.util.ArrayList;

import com.accountmanagement.dao.Dao;
import com.accountmanagement.dao.DaoInterface;
import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public class ServiceImpl implements Service {
	private DaoInterface dao = new Dao();

	@Override
	public boolean checkCustomerName(String name) {
		if (name.matches("[A-Z][a-zA-Z]*")) {
			System.out.println("Next");
			return true;
		} else {
			System.out.println("First name should be UpperCase");
			System.out.println("Enter the valid name");

			return false;

		}
	}

	@Override
	public boolean checkContactNumber(long contactnumber) {
		
		String contactNumber = Long.toString(contactnumber);
		if (contactNumber.matches("[6-9][0-9]{9}")) {
			System.out.println("Next");
			return true;
		} else {
			System.out.println("Number should start with a number between 6 & 9");
			System.out.println("Enter the valid number and should contains 10 digit");
			return false;

		}
	}

	@Override
	public boolean checkAccountType(String typeOfAccount) {

		if (typeOfAccount.equalsIgnoreCase("savings") || typeOfAccount.equalsIgnoreCase("current")) {
			return true;
		} else {
			System.out.println("Enter either savings or current account type");

			return false;
		}

	}

	@Override
	public long accountCreation(AccountDetails account) {
		return dao.accountCreation(account);

	}

	@Override
	public double transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws IncorrectAccNo, AlertsException {
		return dao.transfer(debitorAccNum, creditorAccNum, amountToTransfer);
	}

	@Override
	public double deposit(long accountNum, double amountToTransfer) throws IncorrectAccNo {
		return dao.deposit(accountNum, amountToTransfer);
	}

	@Override
	public double withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo, AlertsException {

		return dao.withdraw(accountNum, amountToTransfer);
	}

	@Override
	public ArrayList<Usertransaction> transactionHistory() {

		return dao.transactionHistory();
	}

	@Override
	public AccountDetails getUserData(long accountNumber) {
		// TODO Auto-generated method stub
		return dao.getUserData(accountNumber);
	}

}
