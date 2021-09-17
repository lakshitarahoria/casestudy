package com.accountmanangement.exceptions;

@SuppressWarnings("serial")
public class MinBalException extends Exception {

	@Override
	public String toString() {
		return "Sorry! Minimum opening balance should be 5000.";
	}

}
