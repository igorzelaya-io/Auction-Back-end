package com.example.auction.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping(value = "usersapi")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/users/search", params = "userID")
	public ResponseEntity<?> getUserById(@RequestParam(required = true)String userID) throws ResourceNotFoundException{
		Optional<User> user = Optional.of(userService.getUserById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("Not found") ));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<?> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		if(userList.isEmpty()) {
			return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/users/save")
	public ResponseEntity<?> saveuser(@RequestBody(required = true) User user){
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/users/save")
	public ResponseEntity<?> saveAllUser(@RequestBody(required = true) List<User> userList){
		if(userList.isEmpty()) {
			return new ResponseEntity<>("Invalid Input", HttpStatus.BAD_REQUEST);
		}
		userService.saveAllUsers(userList);
		return new ResponseEntity<>("Users saved successfully", HttpStatus.OK);
	}
	

}
