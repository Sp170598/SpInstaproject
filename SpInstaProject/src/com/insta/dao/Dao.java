package com.insta.dao;

import java.sql.SQLException;
import java.util.List;

import com.insta.user.UserModel;

public interface Dao {
	public void initDB() throws SQLException;

	public int insert(UserModel u1) throws SQLException;

	public int updateName(String email, String name) throws SQLException;

	public int updateBio(String email, String bio) throws SQLException;

	public int deleteByEmail(String email) throws SQLException;

	public int deleteByMob(String mob) throws SQLException;

	public UserModel selectUserByEmail(String email) throws SQLException;

	public UserModel selectUserByMob(String mob) throws SQLException;

	public UserModel getUserByMob(String Mob) throws SQLException;

	public UserModel getUserProfileByEmail(String Email) throws SQLException;

	public UserModel[] AllUsersProfile() throws SQLException;

	public List<UserModel> AllUsersProfile2() throws SQLException;

	public void closeDB() throws SQLException;
}
