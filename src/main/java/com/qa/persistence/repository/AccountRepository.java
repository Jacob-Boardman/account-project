package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String getAccountByID(Long id);
	String createAccount(String accout);
	String deleteAccount(Long id);

}