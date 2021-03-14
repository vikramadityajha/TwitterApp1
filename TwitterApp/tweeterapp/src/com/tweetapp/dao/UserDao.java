package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tweetapp.CP;
import com.tweetapp.Register;

public class UserDao {

	public static boolean insertUserToDb(Register register) {
		boolean f = false;
		try {
			Connection con = CP.create();
			String q = "insert into user(first_name, last_name, gender, dob, email, password) values(?,?,?,?,?,?)";
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameters
			pstmt.setString(1, register.getFirst_name());
			pstmt.setString(2, register.getLast_name());
			pstmt.setString(3, register.getGender());
			pstmt.setString(4, register.getDob());
			pstmt.setString(5, register.getEmail());
			pstmt.setString(6, register.getPassword());

			// execute
			pstmt.executeUpdate();
			f = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}

	public static boolean validateLoginDb(String email, String password) {

		boolean flag = false;
		try {
			Connection con = CP.create();
			String queryString = " select count(*) as \"exists\" from user where email=? and password=?";
			// set this values using PreparedStatement
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet results = ps.executeQuery();

			if (results.next()) {
				int i = results.getInt("exists");
				if (i == 1) {
					// System.out.println("Username and Password exist");
					flag = true;
				} else {
					flag = false;
					// System.out.println("Please Check Username and Password ");
				}
			}
		} catch (SQLException sql) {

			System.out.println(sql);
		}
		return flag;
	}

	public static boolean resetPasswordDb(String email, String password) {

		boolean f = false;
		try {
			Connection con = CP.create();
			String q = "update user set password = ? where email = ?";
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameters
			pstmt.setString(1, password);
			pstmt.setString(2, email);

			// execute
			pstmt.executeUpdate();
			f = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;
	}

}
