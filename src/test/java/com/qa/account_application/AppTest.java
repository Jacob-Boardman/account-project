package com.qa.account_application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.account_service.Service;

public class AppTest {

	Service service;
	Account a;

	@Before
	public void setUP() {
		service = new Service();
		a = new Account("Jacob", "Boardman", 123);
	}

	@Test
	public void testMakingAccs() {

		assertEquals("Jacob", a.getFirstName());
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
		assertEquals("Jacob", service.getAccount(123).getFirstName());
	}
}
