package com.qa.persistence.repository;

import java.util.Map;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{

	private AccountsMap accounts = new AccountsMap();
	private JSONUtil json = new JSONUtil();
	private Long counter = (long) 0;
	private int mapCounter = 0;

	public String createAccount(String acc) {
		counter = counter+1; 
		Account account = json.getObjectForJSON(acc, Account.class);
		accounts.getAccounts().put(counter, account);
		return "Created an Account";
	}

	public AccountsMap getAccs() {
		return accounts;
	}
	
	@Override
	public String deleteAccount(Long accountNum) {
		accounts.getAccounts().remove(accountNum);
		return "Account deleted";
	}

	public String getAccountByID(Long mapKey) {

		return json.getJSONForObject(accounts.getAccounts().get(mapKey));
	}

	public int returnTheAccountsSize() {

		return accounts.getAccounts().size();
	}
	
	public String getAllAccounts()
	{
		return json.getJSONForObject(accounts.getAccounts().values());
	}

	public boolean findValueInMap(String name) {
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
