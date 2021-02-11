package com.revature.ui;

import java.util.Scanner;

import com.revature.exceptions.InvalidTransferException;

public interface Menu {

	public static Scanner sc = new Scanner(System.in);
	
	public void display() throws InvalidTransferException;
	
}