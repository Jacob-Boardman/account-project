package com.qa.account.application;

public class Account {

	private String firstName;
	private String lastName;
	private int accountNumber;

	public Account(String firstName, String lastName, int accountNumber) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAccountNumber(accountNumber);
	}

	@Override
	public String toString() {
		return "Account: FirstName=" + firstName + ", LastName=" + lastName + ", Account Number=" + accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
