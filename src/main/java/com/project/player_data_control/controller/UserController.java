package com.project.player_data_control.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.player_data_control.entityes.User;
import com.project.player_data_control.requests.UserCreateRequest;
import com.project.player_data_control.requests.UserUpdateRequest;
import com.project.player_data_control.services.UserService;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/{userId}")
	public User getOneUserById(@PathVariable Long userId) {
		return userService.getOneUserById(userId);
	}
	@PostMapping
	public User createOneUser(@RequestBody UserCreateRequest newUserRequest) {
		return userService.createOneUser(newUserRequest);
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUserById(@PathVariable Long userId) {
		userService.deleteOneUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUserById(@PathVariable Long userId,
			@RequestBody UserUpdateRequest newUserRequest) {
		
		return userService.updateOneUserById(userId,newUserRequest);
		
	}
	
	
	
	
}
