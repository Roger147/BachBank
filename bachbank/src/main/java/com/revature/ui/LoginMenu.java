package com.revature.ui;

import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImp;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.model.Account;
import com.revature.model.Login;

public class LoginMenu implements Menu {
	
	public LoginMenu() {
	}
	
	@Override
	public void display() {
			System.out.println("LOGIN");
			System.out.println("=======");
			System.out.println("Enter your username and password on separate lines");
			
				String user = sc.nextLine();
				String pass = sc.nextLine();
				LoginDAO logdao = new LoginDAOImp();
				Account account = logdao.getAccount(user, pass);
				
			
	}
		} 
		
		
	