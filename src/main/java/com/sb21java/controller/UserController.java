package com.sb21java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb21java.model.User;
import com.sb21java.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return new ResponseEntity<String>("User Added Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id)
	{
		User userBean = userService.getUserById(id);
		return new ResponseEntity<User>(userBean,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id)
	{
		userService.deleteById(id);
		return new ResponseEntity<String>("User Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUserById(@PathVariable int id, @RequestBody User user)
	{
		userService.updateUserById(id,user);
		return new ResponseEntity<String>("User Updated Successfully",HttpStatus.CREATED);
	}	
}