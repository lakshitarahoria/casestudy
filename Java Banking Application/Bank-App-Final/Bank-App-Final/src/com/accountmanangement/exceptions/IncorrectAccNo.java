package com.accountmanangement.exceptions;

@SuppressWarnings("serial")
public class IncorrectAccNo extends Exception {

	@Override
	public String toString() {
		return "Incorrect Account Number(s)";
	}

}
