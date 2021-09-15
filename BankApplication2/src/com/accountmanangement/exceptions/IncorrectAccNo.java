package com.accountmanangement.exceptions;

import com.accountmanagement.ui.Client;

@SuppressWarnings("serial")
public class IncorrectAccNo extends Exception {

	public IncorrectAccNo() {
		System.out.println("Incorrect Account Number(s). Exiting...");
		new Client();
	}
}
