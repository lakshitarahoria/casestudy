package com.accountmanagement.ui;

import java.util.Scanner;

import com.accountmanagement.model.AccountDetails;
import com.accountmanagement.service.ServiceImpl;
import com.accountmanangement.exceptions.AlertsException;
import com.accountmanangement.exceptions.IncorrectAccNo;
import com.accountmanangement.exceptions.MinBalException;

// End User Interaction

public class Client {
	public static void main(String[] args) throws AlertsException, IncorrectAccNo, MinBalException {

		ServiceImpl ca = new ServiceImpl();
		Scanner sc = new Scanner(System.in);
		String cust_name;
		long mob_number;
		String acc_type;
		long accountnum = 0;
		long transferAccountnum;
		String branch;
		float balance;
		double deposit_amount, withdraw_amount, amountToTransfer;
		boolean exit = false;
		while (exit != true) {
			System.out.println("********** WELCOME TO BANK APP **********\n");
			System.out.println(
					"\n\n1.Create Account\n2.Deposit\n3.Withdrawal\n4.Transfer\n5.Transaction History\n6.Show Details\n7.Exit\n");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1: // Account creation
				System.out.println("Enter the Customer name: ");
				cust_name = sc.next();
				while (ca.checkCustomerName(cust_name) == false) {
					cust_name = sc.next();
				}
				System.out.println("Enter the Mobile Number: ");
				mob_number = sc.nextLong();
				while (ca.checkContactNumber(mob_number) == false) {
					mob_number = sc.nextLong();
				}
				System.out.println("Enter the Account Type 'savings' or 'current'  : ");
				acc_type = sc.next();
				while (ca.checkAccountType(acc_type) == false) {
					acc_type = sc.next();
				}
				System.out.println("Enter the Branch: ");
				branch = sc.next();
				System.out.println("Enter the Balance: ");
				balance = sc.nextFloat();
				if (balance < 5000) {
					System.out.println(new MinBalException());
				} else {
					// String accountType,String bankBranch,float balance,int contactNumber,String
					// name
					AccountDetails account = new AccountDetails(accountnum, cust_name, branch, acc_type, balance,
							mob_number);
					accountnum = ca.accountCreation(account);
					System.out.println("\nAccount generated with account number: " + accountnum);
				}
				break;

			case 2: // Deposit amount
				System.out.println("Enter Account Number: ");
				accountnum = sc.nextInt();
				System.out.println("Enter Deposit Amount: ");
				deposit_amount = sc.nextInt();
				try {
					System.out.println("Balance is Rs." + ca.deposit(accountnum, deposit_amount));
					System.out.println("Amount Deposit successful\n");
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				break;

			case 3: // Withdraw amount
				System.out.println("Enter Account Number: ");
				accountnum = sc.nextInt();
				System.out.println("Enter Withdrawal Amount: ");
				withdraw_amount = sc.nextInt();

				try {
					System.out.println("Remaining Balance is: " + ca.withdraw(accountnum, withdraw_amount));
					System.out.println("Amount Withdrawal successful!");
				} catch (IncorrectAccNo e) {
					System.out.println(e.toString());
				} catch (AlertsException e) {
					System.out.println(e.toString());
				}
				break;

			case 4:// Transfer amount
				System.out.println("Enter sender's Account Number: ");
				accountnum = sc.nextInt();
				System.out.println("Enter receiver's Account Number: ");
				transferAccountnum = sc.nextInt();
				System.out.println("Enter Transfer Amount: ");
				amountToTransfer = sc.nextInt();
				try {
					double bal = ca.transfer(accountnum, transferAccountnum, amountToTransfer);
					System.out.println("Amount Transfer successful! Remaining Balance is: Rs." + bal);
				} catch (IncorrectAccNo e) {
					System.out.println(e.toString());
				} catch (AlertsException e) {
					System.out.println(e.toString());
				}
				break;

			case 5: // Show Transaction History

				System.out.println("Transaction History:\n");
				System.out.println("Date & Time "+"\t\t\t\t" +"Transaction Id" +"\t\t" + "DebitAccNo" + " \t" +"CreditAccNo" +"\t" +"Amount" + "\t\t" +"Balance" +"\t\t" + "Type of Transfer" + "\n");

				System.out.println(ca.transactionHistory());
				break;

			case 6: // Getting user's account details

				System.out.println("Enter Account Number: ");
				accountnum = sc.nextInt();

				System.out.println("Details: \n");
				System.out.println(ca.getUserData(accountnum));
				break;

			case 7: // Exit the program
				exit = true;
				break;
				
			default:
				System.out.println("Thank you");
				System.exit(0);
				break;
			}
		}

		sc.close();

	}
}