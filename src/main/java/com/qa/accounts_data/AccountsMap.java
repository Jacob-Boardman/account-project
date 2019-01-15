package com.qa.accounts_data;

import java.util.Map;

import com.qa.account_application.Account;

import java.util.HashMap;

public class AccountsMap {

	private Map<Integer, Account> accounts = new HashMap<Integer, Account>();

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

}
