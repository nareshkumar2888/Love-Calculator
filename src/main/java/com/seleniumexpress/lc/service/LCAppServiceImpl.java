package com.seleniumexpress.lc.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LC_APP_FORMULA="FLAME";
	
	public String calculate(String userName, String crushName) {

		int userAndCrushNameCount=(userName+crushName).toCharArray().length;
		
		int formulaCount=LC_APP_FORMULA.toCharArray().length;
		

		int rem = userAndCrushNameCount % formulaCount;
		
		char resultChr = LC_APP_FORMULA.charAt(rem);
		
		String result = whatsBetweenUs(resultChr);
		
		return result;
		
	}
	public String whatsBetweenUs(char calculationResult) {
		
		String result = null;
		
		if(calculationResult == 'F') {
			
			result= LoveCalculatorConstants.F_CHAR_MEANING;
			
		}else if(calculationResult == 'L') {
			
			result= LoveCalculatorConstants.L_CHAR_MEANING;
			
		}else if(calculationResult == 'A') {
			
			result= LoveCalculatorConstants.A_CHAR_MEANING;
			
		}else if(calculationResult == 'M') {
			
			result= LoveCalculatorConstants.M_CHAR_MEANING;
			
		}else if(calculationResult == 'E') {
			
			result= LoveCalculatorConstants.E_CHAR_MEANING;
			
		}else if(calculationResult == 'S') {
			
			result= LoveCalculatorConstants.S_CHAR_MEANING;
		}
		
		return result;
	}
	
}
