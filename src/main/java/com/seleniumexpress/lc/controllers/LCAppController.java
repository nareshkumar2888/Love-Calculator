package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.lc.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LCAppService;

@Controller
@SessionAttributes("user")
public class LCAppController {
	@Autowired
	LCAppService lcappService;
	
	@RequestMapping("/")
	public String showPage(Model model) {
		
		model.addAttribute("user", new UserInfoDTO());
		
		/*
		 * Cookie[] cookies=request.getCookies(); for(Cookie temp:cookies) {
		 * if("lcApp.userName".equals(temp.getName())) { String
		 * myUserName=temp.getValue(); userInfodto.setUserName(myUserName); } }
		 */
		
		return "home-page";
	}


	@RequestMapping("/process-homepage")
	public String showResultPage(Model model,@Valid UserInfoDTO user,BindingResult br)
	{
		
		model.addAttribute("user", user);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+ "user", br);
		
		System.out.println(user.isTermAndCondition());
		if(br.hasErrors()) {
			List<ObjectError> allErrors=br.getAllErrors();
			for(ObjectError error:allErrors) {
				System.out.println(error);
			}
			
			return "home-page";
		}
		System.out.println("ok..");
		
		/*
		 * HttpSession session=request.getSession(); session.setAttribute("userName",
		 * user.getUserName());
		 */
		
		//create a cookie for the user name
		
		/*
		 * Cookie theCookie=new Cookie("lcApp.userName", user.getUserName());
		 * theCookie.setMaxAge(60*60*24); response.addCookie(theCookie);
		 */
		//write a service which will calculate the love % between the user and crush
		
		String appResult = lcappService.calculate(user.getUserName(), user.getCrushName());
		user.setResult(appResult);
		
		return "result-page";
	}
}
