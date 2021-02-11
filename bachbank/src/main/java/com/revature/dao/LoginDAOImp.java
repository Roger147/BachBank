package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.DatabaseConnectionException;
import com.revature.model.Account;
import com.revature.model.Login;
import com.revature.util.ConnectionUtility;

public class LoginDAOImp implements LoginDAO {

	@Override
	public Account getAccount(String username, String password) {
		int id = 0;
		
		try (Connection connection = ConnectionUtility.getConnection()) {
			
			String sql = "SELECT * FROM bachbank.login WHERE username = ? AND password = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {	
			int accountId = rs.getInt("accountid");
			String user = rs.getString("username");
			String pass = rs.getString("password");
				
			Login login = new Login(user, pass, accountId);
			id = login.getId();
			}}
			 catch (DatabaseConnectionException | SQLException e) {
			System.out.println(e.getMessage());
		}
			AccountDAO accdao = new AccountDAOImp();
			Account acc = accdao.getAccountByID(id);
			return acc;
		
			}

	@Override
	public Login createLogin(Login login) {
			try (Connection connection = ConnectionUtility.getConnection()) {
				
				String sql = "INSERT INTO bachbank.login VALUES (?, ?, ?)";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, login.getUser());
				pstmt.setString(2, login.getPass());
				pstmt.setInt(3, login.getId());
				
				pstmt.executeUpdate();
				
				}
				catch (DatabaseConnectionException | SQLException e) {
					System.out.println(e.getMessage());
		}
			return null;
	}

}
