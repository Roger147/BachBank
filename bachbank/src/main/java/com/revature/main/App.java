package com.revature.main;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.exceptions.InvalidTransferException;
import com.revature.model.Account;
import com.revature.model.Login;
import com.revature.util.ConnectionUtility;
import com.revature.dao.AccountDAOImp;


public class App {

	public static void main(String[] args) throws InvalidTransferException {
		try {
			ConnectionUtility.getConnection();
		} catch (DatabaseConnectionException e) {
	}
		AccountDAOImp accdao = new AccountDAOImp();
		Account acc = accdao.getAccountByID(1);
		System.out.println(acc.getBalance());
		acc.deposit(20);
		accdao.updateAccount(acc);
		Account acc2 = accdao.getAccountByID(1);
		System.out.println(acc2.getBalance());
		
		Login log = new Login("bob","smith", 4);
		log.createAccount(500, "smit");
		
}	
}