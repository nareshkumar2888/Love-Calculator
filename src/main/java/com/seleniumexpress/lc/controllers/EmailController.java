package com.seleniumexpress.lc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.seleniumexpress.lc.api.EmailDTO;
import com.seleniumexpress.lc.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailServiceImpl;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {

		model.addAttribute("emailDTO", new EmailDTO());
		//model.addAttribute("userName", userName.toUpperCase());
		return "send-email-page";
	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("user")UserInfoDTO user,@ModelAttribute("emailDTO") EmailDTO emailDTO)
	{
		lcAppEmailServiceImpl.sendEmail(user.getUserName(),emailDTO.getUserEmail(),user.getResult());
		return "process-email-page";
	}

}
