package com.qa.account.application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.account.application.Account;
import com.qa.account.service.Service;

public class ServiceTest {

	private Service service;
	private Account account1;
	private Account account2;
	private Account account3;
	private String name = "Jacob"; 

	@Before
	public void setUP() {
		service = new Service();
		account1 = new Account(name, "Boardman", 123);
		account2 = new Account(name, "Springfield", 456);
		account3 = new Account("Joseph", "Gurney", 789);
	}

	@Test
	public void testMakingAccs() {

		assertEquals(name, account1.getFirstName());
		assertEquals("Boardman", account1.getLastName());
		assertEquals(123, account1.getAccountNumber());
		assertEquals("Account: FirstName=Jacob, LastName=Boardman, Account Number=123", account1.toString());
	}

	@Test
	public void testAddAccountToMap() {
		service.addAccount(account1);
		assertEquals(false, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testRemovingAccountFromMap() {
		service.addAccount(account1);
		service.removeAccount(1);
		assertEquals(true, service.getAccs().getAccounts().isEmpty());
	}

	@Test
	public void testGettingAccountFromMap() {
		service.addAccount(account1);
		assertEquals(name, service.getAccount(1).getFirstName());
	}
	
	@Test
	public void testConvertToJSON() {
		service.addAccount(account1);
		assertEquals("{\"accounts\":{\"1\":{\"firstName\":\"Jacob\",\"lastName\":\"Boardman\",\"accountNumber\":123}}}", service.getJSON());
	}
	
	@Test
	public void testReturnTheAccountsSize() {
		service.addAccount(account1);
		assertEquals(1,service.returnTheAccountsSize());
	}
	
	
	@Test 
	public void testIteratingThroughMapToFindValueBasedOnName()
	{
		service.addAccount(account1);
		service.addAccount(account2);
		service.addAccount(account3);
		assertEquals(true, service.returnBoolIfFoundValueInMap(name));
	}
	
	@Test 
	public void testFinalMethodToCountThroughMapBasedOnName()
	{
		service.addAccount(account1);
		service.addAccount(account2);
		service.addAccount(account3);
		assertEquals(2, service.countThroughAccounts(name));
	}
}
