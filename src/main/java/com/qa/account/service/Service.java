package com.qa.account.service;

import com.qa.account.application.Account;
import com.qa.accounts.data.AccountsMap;

public class Service {

	private AccountsMap accounts = new AccountsMap();

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
	
	

}
