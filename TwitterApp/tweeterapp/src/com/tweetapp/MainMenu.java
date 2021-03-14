package com.tweetapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.tweetapp.dao.TweetDao;
import com.tweetapp.dao.UserDao;

public class MainMenu {

	Register register = new Register();

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("=============== Welcome to Twitter App =================");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Boolean exit=false;
		String isLoginEmail=null;
		while (true) {
			exit=false;
			System.out.println("\n\t\tPRESS 1 to Login");
			System.out.println("\t\tPRESS 2 to Registration");
			System.out.println("\t\tPRESS 3 to Reset Password");
			System.out.println("\t\tPRESS 4 to Exit app");
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				try  {
					Scanner sc = new Scanner(System.in);
					System.out.println(" \tEnter username => ");
					String email = sc.nextLine();
					// register.setEmail(username);

					System.out.println(" \tEnter password");
					String password = sc.nextLine();

					boolean answer = UserDao.validateLoginDb(email, password);
					if(answer){
						isLoginEmail=email;
					}else{
						isLoginEmail=null;
					}

					// register.setPassword(password);

					// boolean flag = register(register);
					if (answer) {
						System.out.println("\tSucessfully Logged In");
						while (true) {
							System.out.println("\n\t\tPRESS 1 to Post tweets");
							System.out.println("\t\tPRESS 2 to View all tweets");
							System.out.println("\t\tPRESS 3 to View my tweets");
							System.out.println("\t\tPRESS 4 to Logout app");
							BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
							int d = Integer.parseInt(sc.nextLine());
							if (d == 1) {
								try  {
									Scanner sd = new Scanner(System.in);
									System.out.println(" \t Enter tweet");
									String messages = sd.nextLine();

//									System.out.println(" \n Enter userId");
//									String userId = sd.nextLine();
									String time = LocalDateTime.now().toString();
									boolean flag = TweetDao.insertInDb(messages, isLoginEmail, time );
									System.out.println(flag);
									if (flag) {
										System.out.println("\tTweet is posted..");
									} else {
										System.out.println("\tSomething went wrong..");
									}

								}finally{
									
								}

							}
							else if(d==2)
							{
								System.out.println("\t\tShow all tweet");
								ViewAllTweet.viewAllTweet();
							//	break;
							}
							else if(d==3)
							{
								System.out.println("\t\tShow my tweet");
								ViewMyTweet.viewMyTweet(isLoginEmail);
							//	break;
							}
							else if(d==4)
							{
								System.out.println("\t\t Yoh have successfully logged out of the application");
								isLoginEmail=null;
								break;
							}

						}
					} else {

						System.out.println(("\tSomething went wrong "));
					}
					//break;
				}finally{
					System.out.println("hello");
				}
			

				// create student object to store student
				// Student st = new Student(name, phone, city);
				// boolean answer = StudentDao.insertStudentToDB(st);
			} else if (c == 2) {

				System.out.println("\tEnter first name :");
				String name = br.readLine();

				System.out.println("\tEnter last name");
				String lname = br.readLine();

				System.out.println("\tEnter gender");
				String city = br.readLine();

				System.out.println("\tEnter dob");
				String dob = br.readLine();

				System.out.println("\tEnter email");
				String email = br.readLine();

				System.out.println("\tEnter password");
				String password = br.readLine();

				Register register = new Register(name, lname, city, dob, email, password);
				boolean answer = UserDao.insertUserToDb(register);
				// create student object to store student
				if (answer) {
					System.out.println("\tSucessfully inserted data into the database..");
				} else {
					System.out.println("\tSomething went wrong...");
				}
				
			} else if (c == 3) {
				System.out.println("\tEnter user name :");
				String email = br.readLine();

				System.out.println("\tEnter new password");
				String password = br.readLine();
				boolean answer = UserDao.resetPasswordDb(email, password);
				if (answer) {
					System.out.println("\tReset Password is successfull");
				} else {
					System.out.println("\tSomething went wrong");
				}
				//exit = false;
				
			} else if (c == 4) {
				// exit
				exit = true;
				break;
			} else {

			}
			if(exit==true){
				
				break;
			}
		
		}
		

	}

}

/*
 * private static boolean register(Register register) { // TODO Auto-generated
 * method stub boolean flag = false; if ("ramesh".equals(register.getEmail()) &&
 * "password".equals(register.getPassword())) {
 * 
 * flag = true; } else {
 * 
 * flag = false; } return flag; }
 */
