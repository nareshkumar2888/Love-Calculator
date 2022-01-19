package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.Validator.EmailValidator;
import com.seleniumexpress.lc.Validator.UserNameValidator;
import com.seleniumexpress.lc.api.UserRegistrationDTO;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmailValidator validator;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO dto) {
		System.out.println("inside show registration page method");

		return "user-registration-page";

	}

	@RequestMapping("/registration-success")
	public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto, BindingResult result) {

		//calling emailValidator method
		validator.validate(dto, result);
		
		if (result.hasErrors()) {
			System.out.println("My page has errors");
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "user-registration-page";
		}
		System.out.println("ok..");
		return "registration-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside the init binder method");
		//binder.setDisallowedFields("name");
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);
		
		//binder.setDisallowedFields("name");
		//UserNameValidator validator=new UserNameValidator();
		binder.addValidators(new UserNameValidator());
		
		//binder.addValidators(new EmailValidator());
		
	}

}
