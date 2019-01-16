package com.qa.account.service;

import com.qa.account.application.Account;
import com.qa.accounts.data.AccountsMap;
import com.qa.accounts.util.JSONUtil;

public class Service {

	private AccountsMap accounts = new AccountsMap();
	private JSONUtil json = new JSONUtil();
	private int counter = 0;
	private int mapCounter = 0;

	public void addAccount(Account acc) {
		counter = counter+1; 
		accounts.getAccounts().put(counter, acc);
	}

	public AccountsMap getAccs() {
		return accounts;
	}

	public void removeAccount(int accountNum) {
		accounts.getAccounts().remove(accountNum);
	}

	public Account getAccount(int mapKey) {

		return accounts.getAccounts().get(mapKey);
	}

	public Object getJSON() {
		return json.getJSONForObject(accounts);
	}

	public int returnTheAccountsSize() {

		return accounts.getAccounts().size();
	}

	public boolean returnBoolIfFoundValueInMap(String name) {
		boolean isfound = false;
		
		for(Account account : accounts.getAccounts().values())
		{
			if(account.getFirstName().equals(name))
			{
				isfound = true;
			}
		}
		
		return isfound;
	}
	
	public int countThroughAccounts(String name) {
		
		for(Account account : accounts.getAccounts().values())
		{
			if(account.getFirstName().equals(name))
			{
				this.mapCounter++;
			}
		}
		
		return this.mapCounter;
	}
	

}
