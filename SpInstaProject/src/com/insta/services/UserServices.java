package com.insta.services;

import java.sql.SQLException;
import java.util.List;

import com.insta.dao.MySqlImple;
import com.insta.user.UserModel;

public class UserServices {

	private MySqlImple ms = new MySqlImple();

	public void LoginByEmail(String entemail, String entpwd) throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		UserModel u1 = ms.selectUserByEmail(entemail);

		String dbEmail = u1.getEmail();
		String dbPwd = u1.getPwd();
		if (dbEmail.equals(entemail) && dbPwd.equals(entpwd)) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Error");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}

	public void LoginByMob(String entmob, String entpwd) throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		UserModel u1 = ms.selectUserByMob(entmob);

		String dbMob = u1.getMob();
		String dbPwd = u1.getPwd();

		if (entmob.equals(dbMob) && entpwd.equals(dbPwd)) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Error");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}

	public void Signup(UserModel u1) throws SQLException {

		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		int count = ms.insert(u1);
		if (count > 0) {
			System.out.println(count + " Data Inserted");
		} else {
			System.out.println("Error");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");

	}

	public void EditProfileName(String entemail, String entname) throws SQLException {

		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		int count = ms.updateName(entemail, entname);
		if (count > 0) {
			System.out.println("User Profile Updated");
		} else {
			System.out.println("Error in Updating");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");

	}

	public void EditProfileBio(String entemail, String entBio) throws SQLException {

		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		int count = ms.updateBio(entemail, entBio);
		if (count > 0) {
			System.out.println("User Profile Updated");
		} else {
			System.out.println("Error in Updating");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");

	}

	public void DeleteProfileByEmail(String email) throws SQLException {

		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		int count = ms.deleteByEmail(email);

		if (count > 0) {
			System.out.println("User Profile DELETED");
		} else {
			System.out.println("Error while deleting User Profile");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");

	}

	public void DeleteProfileByMob(String mob) throws SQLException {

		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		int count = ms.deleteByMob(mob);

		if (count > 0) {
			System.out.println("User Profile DELETED");
		} else {
			System.out.println("Error while deleting User Profile");
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");

	}

	public void showProfileByEmail(String email) throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		UserModel u1 = ms.getUserProfileByEmail(email);

		System.out.println(u1.toString());

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}

	public void showProfileByMob(String Mob) throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		UserModel u1 = ms.getUserByMob(Mob);

		System.out.println(u1.toString());

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}

	public void showAllUsers() throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		UserModel[] users = ms.AllUsersProfile();

		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}

	public void showAllUsers2() throws SQLException {
		ms.initDB();
		// System.out.println("CONNECTED TO DB");

		List<UserModel> u1 = ms.AllUsersProfile2();
		u1.forEach(UserModel -> System.out.println(UserModel));

		ms.closeDB();
		// System.out.println("DISCONNECTED FROM DB");
	}
}
