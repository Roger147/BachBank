package com.revature.ui;

import java.util.Scanner;

public class MainMenu implements Menu {


	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("MAIN MENU");
			System.out.println("=========");
			System.out.println("1.) Exit Application");
			System.out.println("2.) Log In");
			System.out.println("3.) Create New Account");
			System.out.println("Enter a choice between 1 and 3");
			
			try {
				choice = Integer.parseInt(Menu.sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
				case 1:
					break;
				case 2:
					Menu login = new LoginMenu();
					login.display();
					break;
				case 3:
					Menu create = new CreateMenu();
					create.display();
					break;
				default:
					System.out.println("No valid choice entered, please try again");
			}
			
		} while (choice != 1);
	}
}