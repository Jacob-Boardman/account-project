package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
		Account checkAccount = util.getObjectForJSON(account, Account.class);
		Long accountNum = checkAccount.getAccountNumber();
		if (checkAccountNumber(accountNum)) {
			return "{Message : Can't add that account}";
		}
		return repo.createAccount(account);

	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String getAccountByID(Long id) {
		return repo.getAccountByID(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		Account checkAccount = util.getObjectForJSON(account, Account.class);
		Long accountNum = checkAccount.getAccountNumber();
		if (checkAccountNumber(accountNum)) {
			return "{Message : Can't add that account}";
		}
		return repo.updateAccount(id, account);

	}

	public Boolean checkAccountNumber(Long id) {
		if (id == 9999) {
			return true;
		}

		return false;
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
