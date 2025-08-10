package com.sb21java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb21java.model.User;
import com.sb21java.repository.UserRepository;

@Service
public class UserService {
 @Autowired
 private UserRepository userRepo;
 
 	//add user
 	public User addUser(User user) {
		return userRepo.save(user);
	}

 	//get all user
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	// get user by id
	public User getUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}
 
	//delete by id
	public void deleteById(int id)
	{
		userRepo.deleteById(id);
	}
	
	//update user by id
	public User updateUserById(int id, User user)
	{
		User userBean = userRepo.findById(id).get();
			if(user.getUsername()!=null)
				userBean.setUsername(user.getUsername());
		
			if(user.getPassword()!=null)
				userBean.setPassword(user.getPassword());
				
		return userRepo.save(userBean);
	}
}
