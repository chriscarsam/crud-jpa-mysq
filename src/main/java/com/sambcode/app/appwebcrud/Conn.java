package com.sambcode.app.appwebcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

	private Connection connection = null;

	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbappwebcrud","maria","clave");

		} catch (ClassNotFoundException e) {
			System.out.println("The class for the databse was not found");
		} catch (SQLException e) {
			System.out.println("Error in Driver Manager");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred in the connection");
		}
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (Exception e) {
				System.out.println("The connection could not be closed");
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
