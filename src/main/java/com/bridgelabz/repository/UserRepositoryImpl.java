package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;


public class UserRepositoryImpl implements UserRepository {

	
	/**
	 * Function to establish connection with database and create platform
	 */
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=vodka");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed to establish DataBase Connection");
		}
		return connection;
	}
	
	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		User user = new User();
		String query = "SELECT * from user_database.user_information where Email_Id = ?;";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			resultset = statement.executeQuery();
			if(resultset.next()) {
				user.setUserId(resultset.getInt(1));
				user.setUserName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPassword(resultset.getString(4));
				user.setContactNumber(resultset.getString(5));
			}
			else {
				user = null;
				System.out.println("Invalid User");
			}
			
		} catch (SQLException e) {
			System.out.println("Error in creating platform");
		}
		finally {
			if(resultset != null) {
				try {
					resultset.close();
				}
				catch(SQLException e) {
					System.out.println("Error in result set");
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					System.out.println("Error in creating platform");
				}
			}
		}
		System.out.println(user);
		return user;
		
		
	}

	@Override
	public boolean regUser(User user) {
		// TODO Auto-generated method stub
		
		Connection connection = getConnection();
		PreparedStatement statement = null;
		boolean value = false;
		String query = "INSERT INTO user_database.user_information (User_Id, name, Email_Id, Password, PhoneNumber)\n" + 
				"values (?, ?, ?, ?, ?);";
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, 0);
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getContactNumber());
			statement.executeUpdate();
			System.out.println("User registered");
			value = true;
		}
		catch(SQLException e) {
			System.out.println("Error in registering new user");
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch(SQLException e) {
					System.out.println("Error in creating platform");
				}
			}
		}
		return value;
	}
		
}


