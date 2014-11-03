package com.bondar.RestLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bondar.RestLogin.data.UserDao;
import com.bondar.RestLogin.model.User;

@Controller @RequestMapping("/")
public class BaseController {
	
	@Autowired UserDao userDao;
	@Autowired	BCryptPasswordEncoder encoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String getMessage() {
		return "Unsecured zone";
	}

	@RequestMapping(value="first", method=RequestMethod.GET)
	public @ResponseBody User getAllUsers() {
		return userDao.findUserById(1);
	}

	@RequestMapping(value="encode/{pass}", method=RequestMethod.GET)
	public @ResponseBody String encodePass(@PathVariable String pass) {
		return encoder.encode(pass);
	}
}
