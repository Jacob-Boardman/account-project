package com.qa.account.application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.account.application.Account;
import com.qa.account.service.Service;

public class AppTest {

	private Service service;
	private Account account;
	private String name = "Jacob"; 

	@Before
	public void setUP() {
		service = new Service();
		account = new Account(name, "Boardman", 123);
	}

	@Test
	public void testMakingAccs() {

		assertEquals(name, account.getFirstName());
		assertEquals("Boardman", account.getLastName());
		assertEquals(123, account.getAccountNumber());
		assertEquals("Account: FirstName=Jacob, LastName=Boardman, Account Number=123", account.toString());
	}

	@Test
	public void testAddAccountToMap() {
		service.addAccount(account);
		assertEquals(false, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testRemovingAccountFromMap() {
		service.addAccount(account);
		service.removeAccount(123);
		assertEquals(true, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testGettingAccountFromMap() {
		service.addAccount(account);
		assertEquals(name, service.getAccount(123).getFirstName());
	}
	
	@Test
	public void testConvertToJSON() {
		service.addAccount(account);
		assertEquals("{\"accounts\":{\"123\":{\"firstName\":\"Jacob\",\"lastName\":\"Boardman\",\"accountNumber\":123}}}", service.getJSON());
	}
}
