package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.exceptions.InvalidTransferException;
import com.revature.model.Account;
import com.revature.util.ConnectionUtility;

public class AccountDAOImp implements AccountDAO {
	
	@Override
	public Account getAccountByID(int id) {
		Account account = null;
		try (Connection connection = ConnectionUtility.getConnection()) {
			
			String sql = "SELECT * FROM bachbank.accountsuser WHERE accountid = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				try {
				int accountId = rs.getInt("accountid");
				String name = rs.getString("name");
				long balance = rs.getLong("balance");
				
				account = new Account(accountId, name, balance);
				} catch (InvalidTransferException e) {
			}
			}
			} catch (DatabaseConnectionException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return account;
	}

	@Override
	public Account updateAccount(Account account) {		    
		try (Connection connection = ConnectionUtility.getConnection()) {
			
			String sql = "UPDATE bachbank.accountsuser SET name = ?, balance = ? WHERE accountid = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setLong(2, account.getBalance());
			pstmt.setInt(3, account.getID());
			
			pstmt.executeUpdate();
			
			}
			catch (DatabaseConnectionException | SQLException e) {
				System.out.println(e.getMessage());
			}
			
		return null;
	}

	@Override
	public Account createAccount(Account account) {
		try (Connection connection = ConnectionUtility.getConnection()) {
			
			String sql = "INSERT INTO bachbank.accountsuser VALUES (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(2, account.getName());
			pstmt.setLong(3, account.getBalance());
			pstmt.setInt(1, account.getID());
			
			pstmt.executeUpdate();
			
			}
			catch (DatabaseConnectionException | SQLException e) {
				System.out.println(e.getMessage());
	}
		return null;
	
	}
}
