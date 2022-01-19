package com.seleniumexpress.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserInfoDTO {
	@NotBlank(message = " * user name can't be blank ")
	@Size(min = 3, max = 15, message = "{userName.size}")
	private String userName;
	@NotBlank(message = " * crush name can't be blank ")
	@Size(min = 3, max = 15, message = "your name should have atleast 3 characters")
	private String crushName;
	@AssertTrue(message=" agree to use our app")
	private boolean termAndCondition;
	
	private String result;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermAndCondition() {
		return termAndCondition;
	}

	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
