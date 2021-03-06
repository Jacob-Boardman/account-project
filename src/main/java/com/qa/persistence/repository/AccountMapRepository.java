package com.qa.persistence.repository;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	@Inject
	private AccountsMap accounts;

	@Inject
	private JSONUtil json;

	private Long counter = (long) 0;
	private int mapCounter = 0;

	@Override
	public String getAllAccounts() {
		return json.getJSONForObject(accounts.getAccounts().values());
	}

	@Override
	public String createAccount(String acc) {
		counter = counter + 1;
		Account account = json.getObjectForJSON(acc, Account.class);
		accounts.getAccounts().put(counter, account);
		return "Created an Account";
	}

	@Override
	public String deleteAccount(Long accountNum) {
		accounts.getAccounts().remove(accountNum);
		return "Account deleted";
	}

	@Override
	public String getAccountByID(Long mapKey) {

		return json.getJSONForObject(accounts.getAccounts().get(mapKey));
	}

	@Override
	public String updateAccount(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public int returnTheAccountsSize() {

		return accounts.getAccounts().size();
	}

	public boolean findValueInMap(String name) {
		boolean isfound = false;

		for (Account account : accounts.getAccounts().values()) {
			if (account.getFirstName().equals(name)) {
				isfound = true;
			}
		}

		return isfound;
	}

	public int countThroughAccounts(String name) {

		for (Account account : accounts.getAccounts().values()) {
			if (account.getFirstName().equals(name)) {
				this.mapCounter++;
			}
		}

		return this.mapCounter;
	}

	public AccountsMap getAccs() {
		return accounts;
	}

}
