package com.seleniumexpress.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	public boolean supports(Class<?> clazz) 
	{

		return UserRegistrationDTO.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		//to check if the feild is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "User Name can't be Empty");
		
		//the String should contain a_
		String userName=((UserRegistrationDTO)target).getUserName();
		if(!userName.contains("_")) {
			errors.rejectValue("userName", "userName.invalidString", "String must contain a '-'");
		}
	}

}
