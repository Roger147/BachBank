package com.revature.model;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImp;
import com.revature.exceptions.InvalidTransferException;

public class Login {
	private String username;
	private String password;
	private int accountid;
	
	public Login(String username, String password, int accountid) {
		this.username = username;
		this.password = password;
		this.accountid = accountid;
		}
	
	public int getId() {
		return accountid;
	}
	
	public String getUser(){
		return username;
	}
	
	public String getPass(){
		return password;
	}
	
	public void checkAccount(String username, String password) {
	
	}
	
	public void createAccount(long balance, String pass) throws InvalidTransferException {
		AccountDAO accdao = new AccountDAOImp();
		Account acc = new Account(accountid, username, balance);
		if (pass == password)
		accdao.createAccount(acc);
		else System.out.println("Wrong password!");
	}

}
