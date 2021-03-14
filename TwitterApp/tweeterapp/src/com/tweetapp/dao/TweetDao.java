package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.CP;
import com.tweetapp.Tweet;


public class TweetDao {


	public static boolean insertInDb(String messages, String email, String createAt) {
		boolean f = false;
		try {
			Connection con = CP.create();
			String q = "insert into tweet(messages, email, createAt) values(?,?,?)";
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameters
			pstmt.setString(1, messages);
			pstmt.setString(2, email);
			pstmt.setString(3, createAt);

			// execute
			pstmt.executeUpdate();
			f = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return f;// TODO Auto-generated method stub
	}

	public static List<Tweet> showAllTweets() {
		List<Tweet> allTweet = new ArrayList<>();
		try {
			ResultSet resultSet = null;
			
			Connection con = CP.create();
			String q = "select * from tweet";
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			// set the value of parameters
			resultSet = pstmt.executeQuery();
			//System.out.println("\ttweetId\t=====Messages=====\tUserid");
			//System.out.println("\t\t\t");

			while (resultSet.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweetId(resultSet.getInt(1));
				tweet.setMessages(resultSet.getString(2));
				tweet.setEmail(resultSet.getString(3));
				tweet.setCreateAt(resultSet.getString(4));
				allTweet.add(tweet);
				System.out.println(tweet.toString());
				//	System.out.println("\t"+ resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getString(3) + "\t\t\t" + resultSet.getString(4));
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return allTweet;
	}

	public static List<Tweet> showMyTweets(String email) {
		// TODO Auto-generated method stub
		List<Tweet> myTweet = new ArrayList<>();
		try {
			ResultSet resultSet = null;
			
			Connection con = CP.create();
			String q = "select * from tweet where email = ?";
			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, email);
			// set the value of parameters
			resultSet = pstmt.executeQuery();
			System.out.println("\ttweetId\t=====Messages=====\tUserid");
			System.out.println("\t\t\t");

			while (resultSet.next()) {
				Tweet tweet = new Tweet();
				tweet.setTweetId(resultSet.getInt(1));
				tweet.setMessages(resultSet.getString(2));
				tweet.setEmail(resultSet.getString(3));
				tweet.setCreateAt(resultSet.getString(4));
				myTweet.add(tweet);
				//System.out.println("\t"+ resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getString(3) + "\t\t\t" + resultSet.getString(4));
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return myTweet;
		
	}

}
