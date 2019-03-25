package com.nnt.backend.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
/***
 * created by Nay Nyein Tun
 * March 19 2019
 ***/

@Component
public class Validation {
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
	
	// check email validation
    public boolean checkEmail(String email) {              
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)  return false;
		return pat.matcher(email).matches();
	}
    // check phone validation
    public boolean checkPhone(String phone) {
    	return false;
    }
}
