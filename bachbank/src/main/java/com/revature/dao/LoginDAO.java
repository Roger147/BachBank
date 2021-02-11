package com.revature.dao;

import com.revature.model.Account;
import com.revature.model.Login;

public interface LoginDAO {

	public Account getAccount(String username, String password);
	public Login createLogin(Login login);

}



