package com.insta.main;

import java.util.Scanner;

import com.insta.services.UserServices;
import com.insta.user.UserModel;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		UserServices us = new UserServices();

		Scanner sc1 = new Scanner(System.in);

		System.out.println("1. Menu");
		System.out.println("Any key to Exit");

		String optn = sc1.next();

		if (optn.equals("1") == false) {
			System.out.println("Thank you");
			System.exit(0);
		}

		while (true) {

			try {
				System.out.println("1. Signup");
				System.out.println("2. Login");
				System.out.println("3. Delete Profile");
				System.out.println("4. Edit Profile");
				System.out.println("5. Show Profile");
				System.out.println("6. Show All Profiles");
				System.out.println("7. Show All Profiles");
				System.out.println("Any Key for Logout");

				String choice = sc1.next();

				switch (choice) {
				case "1":
					UserModel u1 = new UserModel();
					System.out.println("Enter Name:");
					u1.setName(sc1.next());

					System.out.println("Enter Email:");
					u1.setEmail(sc1.next());

					System.out.println("Enter Password:");
					u1.setPwd(sc1.next());

					System.out.println("Enter Mobile No: ");
					u1.setMob(sc1.next());

					System.out.println("Enter DOB:");
					u1.setDob(sc1.next());

					System.out.println("Enter Gender:");
					u1.setGender(sc1.next());

					System.out.println("Enter Bio:");
					u1.setBio(sc1.nextLine());

					us.Signup(u1);

					break;

				case "2":
					while (true) {
						System.out.println("1. Login By Email");
						System.out.println("2. Login By Mob");
						System.out.println("Any Key for Exit");

						// Scanner sc1 = new Scanner(System.in);
						String ch1 = sc1.next();

						switch (ch1) {
						case "1":
							System.out.println("Enter Email Id:");
							String entEmail = sc1.next();

							System.out.println("Enter Password:");
							String entPwd = sc1.next();

							us.LoginByEmail(entEmail, entPwd);
							System.exit(0);
							break;
						case "2":
							System.out.println("Enter Mobile No:");
							String entMob = sc1.next();

							System.out.println("Enter Password:");
							String entPwd1 = sc1.next();

							us.LoginByMob(entMob, entPwd1);
							System.exit(0);
							break;

						default:
							System.out.println("Wrong Input");
							System.exit(0);
						}
					}

				case "3":
					while (true) {
						System.out.println("1. Delete By Email");
						System.out.println("2. Delete By Mob");
						System.out.println("Any Key for Exit");

						// Scanner sc1 = new Scanner(System.in);
						String ch3 = sc1.next();

						switch (ch3) {
						case "1":
							System.out.println("Enter Email Id:");
							String entEmaili = sc1.next();

							us.DeleteProfileByEmail(entEmaili);
							System.exit(0);
							break;
						case "2":
							System.out.println("Enter Mobile No:");
							String entMob1 = sc1.next();

							us.DeleteProfileByMob(entMob1);
							System.exit(0);
							break;

						default:
							System.out.println("Wrong Input");
							System.exit(0);
						}
					}

				case "4":
					while (true) {
						System.out.println("1. Update Name");
						System.out.println("2. Update Bio");
						System.out.println("Any Key for Exit");

						// Scanner sc1 = new Scanner(System.in);
						String ch4 = sc1.next();

						switch (ch4) {
						case "1":
							System.out.println("Enter Email Id:");
							String entEmailid = sc1.next();

							System.out.println("Enter New Name:");
							String entname = sc1.next();

							us.EditProfileName(entEmailid, entname);
							System.exit(0);
							break;
						case "2":
							System.out.println("Enter Email Id:");
							String entEmailid3 = sc1.next();

							System.out.println("Enter New Bio:");
							String entBio = sc1.next();

							us.EditProfileBio(entEmailid3, entBio);
							System.exit(0);
							break;
						default:
							System.out.println("Wrong Input");
							System.exit(0);
						}
					}

				case "5":
					while (true) {
						System.out.println("1. Show Profile By Email");
						System.out.println("2. Show Profile By Mobile");
						System.out.println("Any Key for Exit");

						// Scanner sc1 = new Scanner(System.in);
						String ch5 = sc1.next();

						switch (ch5) {
						case "1":
							System.out.println("Enter Email Id:");
							String entEmail2 = sc1.next();

							us.showProfileByEmail(entEmail2);
							System.exit(0);
							break;
						case "2":
							System.out.println("Enter Mobile No:");
							String entMob1 = sc1.next();

							us.showProfileByMob(entMob1);
							System.exit(0);
							break;
						default:
							System.out.println("Wrong Input");
							System.exit(0);
						}
					}
				case "6":
					us.showAllUsers();
					System.exit(0);
					break;

				case "7":
					us.showAllUsers2();
					System.exit(0);
					break;
				default:
					System.out.println("User Logged Out");
					System.exit(0);
				}

			} catch (Exception sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
