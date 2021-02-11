package com.revature.dao;

import com.revature.model.Account;

public interface AccountDAO {

	public Account getAccountByID(int id);
	public Account updateAccount(Account account);
	public Account createAccount(Account account);
}
