package com.accountmanagement.model;

import java.util.Date;


public class Usertransaction  {
	private int transactionId;
	private long depositerAccNo;
	private long creditorAccNo;
	private double amount;
	private Date date;
	private double balance;
	private String type;
	public Usertransaction(Date date, int transactionId, long depositerAccNo, long creditorAccNo, double amount, 
			double balance, String type) {
		super();
		this.transactionId = transactionId;
		this.depositerAccNo = depositerAccNo;
		this.creditorAccNo = creditorAccNo;
		this.amount = amount;
		this.date = date;
		this.balance = balance;
		this.type = type;
	}
	@Override
	public String toString() {
		return ""+ date+"\t\t\t" +transactionId +"\t\t" + depositerAccNo + "\t\t" +creditorAccNo +"\t\t" +amount + "\t\t" +balance +"\t\t" + type + "\n";
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getDepositerAccNo() {
		return depositerAccNo;
	}
	public void setDepositerAccNo(long depositerAccNo) {
		this.depositerAccNo = depositerAccNo;
	}
	public long getCreditorAccNo() {
		return creditorAccNo;
	}
	public void setCreditorAccNo(long creditorAccNo) {
		this.creditorAccNo = creditorAccNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	
	
	
}