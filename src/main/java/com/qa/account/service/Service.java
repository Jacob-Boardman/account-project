package com.qa.account.service;

import com.qa.account.application.Account;
import com.qa.accounts.data.AccountsMap;
import com.qa.accounts.util.JSONUtil;

public class Service {

	private AccountsMap accounts = new AccountsMap();
	private JSONUtil json = new JSONUtil(); 

	public void addAccount(Account acc) {

		accounts.getAccounts().put(acc.getAccountNumber(), acc);
	}

	public AccountsMap getAccs() {
		return accounts;
	}

	public void removeAccount(int accountNum) {
		accounts.getAccounts().remove(accountNum);
	}

	public Account getAccount(int accountNum) {
		
		return accounts.getAccounts().get(accountNum);
	}

	public Object getJSON() {
		return json.getJSONForObject(accounts);
	}

	public int countAccounts(String string) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
