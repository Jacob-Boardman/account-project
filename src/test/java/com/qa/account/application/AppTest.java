package com.qa.account.application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.account.application.Account;
import com.qa.account.service.Service;

public class AppTest {

	private Service service;
	private Account a;
	private String name = "Jacob"; 

	@Before
	public void setUP() {
		service = new Service();
		a = new Account(name, "Boardman", 123);
	}

	@Test
	public void testMakingAccs() {

		assertEquals(name, a.getFirstName());
		assertEquals("Boardman", a.getLastName());
		assertEquals(123, a.getAccountNumber());
		assertEquals("Account: FirstName=Jacob, LastName=Boardman, Account Number=123", a.toString());
	}

	@Test
	public void testAddAccountToMap() {
		service.addAccount(a);
		assertEquals(false, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testRemovingAccountFromMap() {
		service.addAccount(a);
		service.removeAccount(123);
		assertEquals(true, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testGettingAccountFromMap() {
		service.addAccount(a);
		assertEquals(name, service.getAccount(123).getFirstName());
	}
}
