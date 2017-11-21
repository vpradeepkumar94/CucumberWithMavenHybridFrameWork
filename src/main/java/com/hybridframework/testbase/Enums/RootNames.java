package com.enums;

public enum RootNames {
	STUDENTS("Students"), USERS("Users");

	String type;

	private RootNames(String type) {
		this.type = type;
	}

	public String getThePageInstanceType() {
		return type;
	}
}
