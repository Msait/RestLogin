package com.bondar.RestLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bondar.RestLogin.data.UserDao;
import com.bondar.RestLogin.model.User;

@Controller @RequestMapping("/protected")
public class UserController {
	
	@Autowired UserDao userDao;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable long id) {
		return userDao.findUserById(id);
	}
	
	@PreAuthorize("hasRole('manager')")
	@RequestMapping(value="/userId/{id}", method=RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable long id) {
		return userDao.findUserById(id);
	}
}
