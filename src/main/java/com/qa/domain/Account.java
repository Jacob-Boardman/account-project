package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private Long accountNumber;

	public Account(String firstName, String lastName, Long accountNumber) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAccountNumber(accountNumber);
	}

	public Account() {

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

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
