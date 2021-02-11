package com.revature.main;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.exceptions.InvalidTransferException;
import com.revature.model.Account;
import com.revature.model.Login;
import com.revature.ui.MainMenu;
import com.revature.ui.Menu;
import com.revature.util.ConnectionUtility;
import com.revature.dao.AccountDAOImp;


public class App {

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.display();
		
}	
}