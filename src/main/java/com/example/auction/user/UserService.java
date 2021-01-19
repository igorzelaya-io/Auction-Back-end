package com.example.auction.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	private UserRepository userRepo;

	public Optional<User> getUserById(String userID){
		Optional<User> user = userRepo.findById(userID);
		if(user.isPresent()) {
			return user;
		}
		return null;
	}
	
	public Optional<User> getUserByName(String userName){
		 Optional<User> user = userRepo.findUserByName(userName);
		 if(user.isPresent()) {
			 return user;
		 }
		 return null;
	}
	
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<>();
		userList = userRepo.findAll();
		return userList;
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public void saveAllUsers(List<User> userList) {
		Iterable<User> users = userList;
		userRepo.saveAll(users);
	}

	public void deleteUserById(String userID) {
		userRepo.deleteById(userID);
	}
	
	public void deleteAllUsers(List<User> userList) {
		userRepo.deleteAll(userList);
	}
}