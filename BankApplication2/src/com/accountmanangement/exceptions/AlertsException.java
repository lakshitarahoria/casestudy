package com.accountmanangement.exceptions;

import com.accountmanagement.ui.Client;

@SuppressWarnings("serial")
public class AlertsException extends Exception{

	public AlertsException() {
		System.out.println("Insufficient Balance. Exiting...");
		new Client();
		
	}
}
