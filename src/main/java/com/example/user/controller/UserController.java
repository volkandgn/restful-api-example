package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUser() {
		return (List<User>) userService.findAll();
	}
	
	@RequestMapping(value = "/users/{lastname}", method = RequestMethod.GET)
	public User getUserByLastname(@PathVariable("lastname") String lastname) {
		return userService.findByLastname(lastname);
	}
	
	@RequestMapping(value = "/users/{name}/{id}", method = RequestMethod.GET)
	public User getUserByNameAndId(@PathVariable("name") String name,@PathVariable("id") Long id) {
		return userService.findUserByNameAndId(name, id);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable("id") Long id) {
		 userService.deleteById(id);
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
	
			userService.save(user);
		
	}
	

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void saveUser(@RequestBody User user) throws Exception {
		if (user.getId() == null )
			userService.save(user);
		else
			throw new Exception("Not accept id");
	}

}
