package com.abhishek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.service.UserService;
import com.abhishek.app.model.User;
@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> userList(){
		return userService.userList();
	}
	
	@RequestMapping("/list/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public User findOne(@PathVariable Long id) {
		return userService.findOne(id);
	}
	
	@RequestMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteUser(@PathVariable Long id) {
		
		return userService.deleteUser(id);
	}  
	

}
