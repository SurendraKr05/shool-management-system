package com.abhi.school_data_management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {	
	
	/*
	 *This method is used to achieve connection with the database 
	 * */

	public static Connection getConnection() {
		Connection con = null;
		String url = AppConstants.DB_URL;
		String user = AppConstants.DB_USERNAME;
		String pass = AppConstants.DB_PASSWORD;

		try {
			Class.forName(AppConstants.DRIVERNAME);
			con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
