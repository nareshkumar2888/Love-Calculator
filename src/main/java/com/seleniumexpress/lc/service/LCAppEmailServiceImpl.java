package com.seleniumexpress.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	private JavaMailSender javaMailSenderImpl;
	
	

	public void sendEmail(String userName, String userEmail, String result) {

		SimpleMailMessage newMail = new SimpleMailMessage();
		newMail.setTo(userEmail);
		newMail.setSubject("Love Calculation Application Result");
		newMail.setText("Hi "+userName+" the Result Predicted by the LCApp is "+result);
		
		javaMailSenderImpl.send(newMail);
		
	}

	

}
