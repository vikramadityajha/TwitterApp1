package com.tweetapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {

	public static Connection create() {

		Connection con = null;

		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection..
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/tweetdata";

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		return con;
	}
}
