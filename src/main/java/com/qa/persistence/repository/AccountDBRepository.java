package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getAccountByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String createAccount(String accout) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
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
