package com.qa.persistence.repository;

import java.util.Map;

import com.qa.domain.Account;

import java.util.HashMap;

public class AccountsMap {

	private Map<Long, Account> accounts = new HashMap<>();

	public AccountsMap() {

	}

	public Map<Long, Account> getAccounts() {
		return accounts;
	}

}
