package com.revature.ui;

import java.util.Scanner;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImp;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InvalidTransferException;
import com.revature.model.Account;
import com.revature.model.Login;

public class LoginMenu implements Menu {
	
	public LoginMenu() {
	}
	
	@Override
	public void display() throws InvalidTransferException {
			System.out.println("LOGIN");
			System.out.println("=======");
			System.out.println("Enter your username and password on separate lines");
			
				String user = sc.nextLine();
				String pass = sc.nextLine();
				LoginDAO logdao = new LoginDAOImp();
				Account account = logdao.getAccount(user, pass);
				

			System.out.println("LOGGED IN");
			System.out.println("=======");
			System.out.println("Enter an action");
			int choice = 0;
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
				case 1:
					break;
				case 2:
					long mon = sc.nextLong();
					account.deposit(mon);
					break;
				case 3:
					long mon2 = sc.nextLong();
					account.withdraw(mon2);
					break;
				default:
					System.out.println("No valid choice entered, please try again");
			}
		} 
		
}	
	