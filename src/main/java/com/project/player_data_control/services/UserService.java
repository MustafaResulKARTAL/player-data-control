package com.project.player_data_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Inventory;
import com.project.player_data_control.entityes.User;
import com.project.player_data_control.repository.InventoryRepository;
import com.project.player_data_control.repository.UserRepository;
import com.project.player_data_control.requests.UserCreateRequest;
import com.project.player_data_control.requests.UserUpdateRequest;
@Service

public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User createOneUser(UserCreateRequest newUserRequest) {
		
		Inventory inventory=inventoryRepository.getById(newUserRequest.getInventoryId());
		if(inventory!=null) {
			User userToSave=new User();
			userToSave.setUserName(newUserRequest.getUserName());
			userToSave.setUserPassword(passwordEncoder.encode(newUserRequest.getUserPassword()));
			userToSave.setUserEmail(newUserRequest.getUserEmail());
			userToSave.setUserLocation(newUserRequest.getUserLocation());
			userToSave.setRole(newUserRequest.getRole());
			userToSave.setInventory(inventory);
			return userRepository.save(userToSave);
		}
		else {
			System.out.println("Boş envanter secimi");
			return null;
		}
		
	}

	public User updateOneUserById(Long userId, UserUpdateRequest newUserRequest) {
		
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			Inventory inventory=inventoryService.getOneInventoryById(newUserRequest.getInventoryId());
			
			if(inventory!=null) {
				User userToUpdate=user.get();
				userToUpdate.setInventory(inventory);
				userToUpdate.setUserName(newUserRequest.getUserName());
				userToUpdate.setUserPassword(passwordEncoder.encode(newUserRequest.getUserPassword()));
				userToUpdate.setUserEmail(newUserRequest.getUserEmail());
				userToUpdate.setUserLocation(newUserRequest.getUserLocation());
				userToUpdate.setRole(newUserRequest.getRole());
				return userRepository.save(userToUpdate);
			}
			return null;
		}
		return null;
	}
	
	
	
	
	public void deleteOneUserById(Long userId) {
		userRepository.deleteById(userId);
		
	}

	public void saveOneUser(User user) {
		userRepository.save(user);
		
	}

	public Object getOneUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
		
	}

	public Object getOneUserByUserEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}
	

}
