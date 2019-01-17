package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	@Override
	public String getAccountByID(Long id) {
		Query query = manager.createQuery("SELECT a FROM Account a WHERE id = id");
		Account account = (Account) query.getResultList();
		return util.getJSONForObject(account);
	}

	@Transactional(REQUIRED)
	@Override
	public String createAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(newAccount);
		return "{Message : Account is created and added}";
	}
	
	@Transactional(REQUIRED)
	@Override
	public String deleteAccount(Long id) {
		Account account = findAccount(id);
		 if(account != null){
			manager.remove(account);
			return "{Message : Deleted an account}";
		 	}
		 return "{Message : No account found}";
	}
	
	@Transactional(REQUIRED)
	@Override
	public String updateAccount(Long id, String account) {
		
		Account foundAccount = findAccount(id);
		Account JSONAccount = util.getObjectForJSON(account, Account.class);
		if(foundAccount != null) {
			
			manager.remove(foundAccount);
			manager.persist(JSONAccount);
			
			return "{Message : Account updated";
		}
		
		return "{Message : No account with that id";
		
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
