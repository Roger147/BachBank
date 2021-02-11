package com.revature.model;

import com.revature.exceptions.InvalidTransferException;

public class Account {
	private int accountId;
	private String name;
	private long balance;
	
	public Account() {
		super();
	}
	
	public Account(int id, String name, long balance) throws InvalidTransferException {
		setID(id);
		setName(name);
		firstdeposit(balance);
	}
	
	public int getID() {
		return accountId;
	};
	
	private void setID(int id) {
		if (id > 0) this.accountId = id;
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public long getBalance( ) {
		return balance;
	}
	
	private void firstdeposit(long money) throws InvalidTransferException {
		if (money >= 100) this.balance = balance + money;
		else { throw new InvalidTransferException("Invalid Initial Deposit Amount");
		}
		
	}
	public void deposit(long money) throws InvalidTransferException {
		if (money > 0) this.balance = balance + money;
		else { throw new InvalidTransferException("Invalid Deposit Amount");
		}
	}
			
	public void withdraw(long money) throws InvalidTransferException {
		if (money > 0 && balance - money > 0) this.balance = balance - money;
		else { throw new InvalidTransferException("Invalid Withdrawal Amount");
		}
	}
}