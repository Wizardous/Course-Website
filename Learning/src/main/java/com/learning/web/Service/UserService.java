package com.learning.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.web.Entity.User;
import com.learning.web.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}

	public User getUserByEmail(String email) {
		return userRepo.findByEmailAddress(email);
	}

}
