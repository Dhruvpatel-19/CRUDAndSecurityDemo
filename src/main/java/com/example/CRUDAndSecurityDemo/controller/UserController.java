package com.example.CRUDAndSecurityDemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDAndSecurityDemo.entity.User;
import com.example.CRUDAndSecurityDemo.service.UserService;

@RestController
public class UserController {
	//add user
	//get user, get all users
	//update user
	//delete user
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user, @RequestParam String departmentName) {
		return userService.addUser(user, departmentName);
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
		return userService.updateUser(id, updatedUser);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
