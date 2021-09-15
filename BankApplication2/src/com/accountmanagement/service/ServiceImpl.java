package com.accountmanagement.service;

import java.util.ArrayList;

import com.accountmanagement.dao.Dao;
import com.accountmanagement.dao.DaoInterface;
import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.model.Usertransaction;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;

public class ServiceImpl implements Service{
private DaoInterface dao=new Dao();

	@Override
	public boolean checkCustomerName(String name) {
		if(name.matches("[A-Z][a-zA-Z]*"))
		{
			System.out.println("Good");
			return true;
		}
		else
		{
			System.out.println("First name should be UpperCase");
			System.out.println("Enter the valid name");
			
			return false;
			
		}
	}

	@Override
	public boolean checkContactNumber(long contactnumber) {
		String contactNumber=Long.toString(contactnumber);
		if(contactNumber.matches("[6-9][0-9]{9}"))
		{
			System.out.println("Good");
			return true;
		}
		else
		{
			System.out.println("Number should start with 8 or 9");
			System.out.println("Enter the valid number and should contains 10 digit");
			return false;
			
		}
	}

	@Override
	public boolean checkAccountType(String typeOfAccount) {
		
		if(typeOfAccount.equalsIgnoreCase("savings") || typeOfAccount.equalsIgnoreCase("current"))
		{
			return true;
		}
		else
		{
			System.out.println("Enter either savings or current account type");
			
			return false;
		}
		
	}

	@Override
	public void accountCreation(AccountDetails name) {
		dao.accountCreation(name);
		
	}

	@Override
	public AccountDetails transfer(long debitorAccNum, long creditorAccNum, double amountToTransfer) throws Exception, AlertsException {
		return dao.transfer(debitorAccNum, creditorAccNum, amountToTransfer);
	}

	@Override
	public AccountDetails deposit(long accountNum, double amountToTransfer) throws Exception {
		return dao.deposit(accountNum, amountToTransfer);
	}

	@Override
	public AccountDetails withdraw(long accountNum, double amountToTransfer) throws IncorrectAccNo {
		
		return dao.withdraw(accountNum, amountToTransfer);
	}

	@Override
	public ArrayList<Usertransaction> transactionHistory() {
		
		return dao.transactionHistory();
	}

	@Override
	public AccountDetails accountDetails(long accountNum) throws IncorrectAccNo {
		return dao.accountDetails(accountNum);
	}
	
	

	 	
		
	
	
}
	
	

