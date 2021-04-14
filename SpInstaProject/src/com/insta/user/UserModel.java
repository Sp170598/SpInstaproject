package com.insta.user;

public class UserModel {

	private int id;
	private String name;
	private String email;
	private String mob;
	private String pwd;
	private String dob;
	private String gender;
	private String bio;

	public UserModel() {

	}

	public UserModel(int id, String name, String email, String mob, String pwd, String dob, String gender, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.pwd = pwd;
		this.dob = dob;
		this.gender = gender;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public String setMob(String mob) {
		return this.mob = mob;
	}

	public String getPwd() {
		return pwd;
	}

	public String setPwd(String pwd) {
		return this.pwd = pwd;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {

		return id;
	}

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", mob=" + mob + ", pwd=" + pwd + ", dob=" + dob
				+ ", gender=" + gender + ", bio=" + bio + "]";
	}

}
