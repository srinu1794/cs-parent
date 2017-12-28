package com.capgemini.service;

public class Cart {
	private String userId;

	private String name;

	private String password;

	private String education;

	private String primarySkill;

	private String secondarySkill;

	private String experience;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getSecondarySkill() {
		return secondarySkill;
	}

	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", name=" + name + ", password=" + password + ", education=" + education
				+ ", primarySkill=" + primarySkill + ", secondarySkill=" + secondarySkill + ", experience=" + experience
				+ "]";
	}

}
