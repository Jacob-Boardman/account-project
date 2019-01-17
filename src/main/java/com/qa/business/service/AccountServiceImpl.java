package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
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
		return repo.updateAccount(id, account);
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
