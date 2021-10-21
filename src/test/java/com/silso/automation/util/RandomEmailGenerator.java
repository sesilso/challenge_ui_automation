package com.silso.automation.util;

import java.util.Random;

public class RandomEmailGenerator {
	
	public static String get() {
		String email = "agent%s@selfmail.com";
		String id = randomNumber(11111111,99999999);
		return String.format(email, id);
	}
	
	private static String randomNumber (int min, int max) {
		Random r= new Random();
		return String.valueOf(r.nextInt((max - min) + 1)+ min);
				
	} 

}
