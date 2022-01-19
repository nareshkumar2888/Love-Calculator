package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone>
{

	
	public String print(Phone object, Locale locale) {
		
		return null;
	}

	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		System.out.println("inside the parse method of PhoneNumber Formatter");
		String[] phoneNumberArray=completePhoneNumber.split("-");
		
		Phone phone=new Phone();
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setUserNumber(phoneNumberArray[1]);
		
		return phone;
	}

}
