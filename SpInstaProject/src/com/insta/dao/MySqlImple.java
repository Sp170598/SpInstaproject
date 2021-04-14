package com.insta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.insta.user.UserModel;

public class MySqlImple implements Dao {

	private String url = "jdbc:mysql://localhost:3306/";
	private String dbname = "instadb";
	private String dbusername = "root";
	private String dbuserpwd = "root";
	@SuppressWarnings("unused")
	private Statement stmt;
	private PreparedStatement ps;
	private Connection con;

	private String insertUser = "insert into instadb.users values(?,?,?,?,?,?,?,?)";
	private String UserByEmail = "select email,pwd from instadb.users where email = ?";
	private String UserByMob = "select mob,pwd from instadb.users where mob = ?";
	private String delteUserbyemail = "delete from instadb.users where email = ?";
	private String delteUserbymob = "delete from instadb.users where mob = ?";
	private String getUserProfile = "select * from instadb.users where email = ?";
	private String getUserProfileByMob = "select * from instadb.users where mob = ?";
	private String editUserProfileName = "update instadb.users set name = ? where email = ?";
	private String editUserProfileBio = "update instadb.users set bio = ? where email = ?";
	private String getAllUserProfile = "select * from instadb.users";

	@Override
	public void initDB() throws SQLException {

		con = DriverManager.getConnection(url + dbname, dbusername, dbuserpwd);
		stmt = con.createStatement();
	}

	@Override
	public int insert(UserModel u1) throws SQLException {

		ps = con.prepareStatement(insertUser);
		ps.setInt(1, 0);
		ps.setString(2, u1.getName());
		ps.setString(3, u1.getEmail());
		ps.setString(4, u1.getMob());
		ps.setString(5, u1.getPwd());
		ps.setString(6, u1.getDob());
		ps.setString(7, u1.getGender());
		ps.setString(8, u1.getBio());

		int count = ps.executeUpdate();

		return count;
	}

	@Override
	public int updateName(String email, String name) throws SQLException {

		ps = con.prepareStatement(editUserProfileName);
		ps.setString(1, name);
		ps.setString(2, email);
		int count = ps.executeUpdate();

		return count;

	}

	@Override
	public int updateBio(String email, String bio) throws SQLException {

		ps = con.prepareStatement(editUserProfileBio);
		ps.setString(1, bio);
		ps.setString(2, email);
		int count = ps.executeUpdate();

		return count;
	}

	@Override
	public int deleteByEmail(String email) throws SQLException {

		ps = con.prepareStatement(delteUserbyemail);
		ps.setString(1, email);
		int count = ps.executeUpdate();

		return count;
	}

	@Override
	public int deleteByMob(String mob) throws SQLException {

		ps = con.prepareStatement(delteUserbymob);
		ps.setString(1, mob);
		int count = ps.executeUpdate();

		return count;
	}

	@Override
	public UserModel selectUserByEmail(String email) throws SQLException {

		ps = con.prepareStatement(UserByEmail);
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		rs.next();

		UserModel u1 = new UserModel();
		u1.setEmail(rs.getString(1));
		u1.setPwd(rs.getString(2));

		return u1;
	}

	@Override
	public UserModel selectUserByMob(String mob) throws SQLException {

		ps = con.prepareStatement(UserByMob);
		ps.setString(1, mob);

		ResultSet rs = ps.executeQuery();
		rs.next();

		UserModel u1 = new UserModel();
		u1.setMob(rs.getString(1));
		u1.setPwd(rs.getString(2));

		return u1;
	}

	@Override
	public UserModel getUserProfileByEmail(String email) throws SQLException {

		ps = con.prepareStatement(getUserProfile);
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		rs.next();

		UserModel u1 = new UserModel();
		u1.setName(rs.getString(2));
		u1.setEmail(rs.getString(3));
		u1.setMob(rs.getString(4));
		u1.setDob(rs.getString(6));
		u1.setGender(rs.getString(7));
		u1.setBio(rs.getString(8));

		return u1;
	}

	@Override
	public UserModel getUserByMob(String Mob) throws SQLException {

		ps = con.prepareStatement(getUserProfileByMob);
		ps.setString(1, Mob);

		ResultSet rs = ps.executeQuery();
		rs.next();

		UserModel u1 = new UserModel();
		u1.setName(rs.getString(2));
		u1.setEmail(rs.getString(3));
		u1.setMob(rs.getString(4));
		u1.setDob(rs.getString(6));
		u1.setGender(rs.getString(7));
		u1.setBio(rs.getString(8));

		return u1;
	}

	@Override
	public UserModel[] AllUsersProfile() throws SQLException {

		ps = con.prepareStatement(getAllUserProfile);

		ResultSet rs = ps.executeQuery();

		String countRecords = "select count(*) from instadb.users";

		PreparedStatement ps2 = con.prepareStatement(countRecords);
		ResultSet rs2 = ps2.executeQuery();

		rs2.next();
		int len = rs2.getInt(1);

		UserModel[] users = new UserModel[len];

		int index = 0;
		while (rs.next() == true) {

			users[index] = new UserModel();
			users[index].setName(rs.getString(2));
			users[index].setEmail(rs.getString(3));
			users[index].setMob(rs.getString(4));
			users[index].setDob(rs.getString(6));
			users[index].setGender(rs.getString(7));
			users[index].setBio(rs.getString(8));

			index++;
		}
		return users;
	}

	@Override
	public List<UserModel> AllUsersProfile2() throws SQLException {

		ps = con.prepareStatement(getAllUserProfile);

		ResultSet rs = ps.executeQuery();

		List<UserModel> userlist = new ArrayList<UserModel>();

		while (rs.next()) {
			int colindex = 2;

			UserModel u1 = new UserModel();
			String name = rs.getString(colindex);

			u1.setName(name);
			colindex++;

			u1.setEmail(rs.getString(colindex++));
			u1.setMob(rs.getString(colindex++));
			u1.setPwd(rs.getString(colindex++));
			u1.setDob(rs.getString(colindex++));
			u1.setGender(rs.getString(colindex++));
			u1.setBio(rs.getString(colindex++));

			userlist.add(u1);
		}
		return userlist;

	}

	@Override
	public void closeDB() throws SQLException {

		con.close();
	}

}
