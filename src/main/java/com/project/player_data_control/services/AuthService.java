package com.project.player_data_control.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Inventory;
import com.project.player_data_control.entityes.User;
import com.project.player_data_control.repository.InventoryRepository;
import com.project.player_data_control.requests.UserCreateRequest;
import com.project.player_data_control.requests.UserRequest;
import com.project.player_data_control.responses.AuthResponse;

@Service

public class AuthService {

	private AuthenticationManager authenticationManager;
	private UserService userService;
	private InventoryRepository inventoryRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthService(AuthenticationManager authenticationManager,UserService userService,
			InventoryRepository inventoryRepository,PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userService=userService;
		this.inventoryRepository=inventoryRepository;
		this.passwordEncoder=passwordEncoder;
	}

	public AuthResponse login(UserRequest loginRequest) {
			
		UsernamePasswordAuthenticationToken authToken=
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword());
		Authentication auth=authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		User user=(User) userService.getOneUserByUserName(loginRequest.getUserName());
		AuthResponse authResponse=new AuthResponse();
		authResponse.setUserId(user.getId());
		authResponse.setUserName(user.getUserName());
		authResponse.setUserRole(user.getRole());
		System.out.println(user.getId());
		System.out.println(user.getUserName());
		System.out.println(user.getRole());
		return authResponse;
	}

	public ResponseEntity<String> register(UserCreateRequest registerRequest) {
		
		if(userService.getOneUserByUserName(registerRequest.getUserName()) != null) {
			return new ResponseEntity<>("User Name alredy in use ",HttpStatus.BAD_REQUEST);
		}
		else if(userService.getOneUserByUserEmail(registerRequest.getUserEmail()) != null) {
			return new ResponseEntity<>("Email alredy in use ",HttpStatus.BAD_REQUEST);
		}
		Inventory inventory=inventoryRepository.getById((long) 1);
		User user=new User();
		user.setUserName(registerRequest.getUserName());
		user.setUserPassword(passwordEncoder.encode( registerRequest.getUserPassword()));
		user.setUserEmail(registerRequest.getUserEmail());
		user.setUserLocation(registerRequest.getUserLocation());
		user.setRole("USER");
		user.setInventory(inventory);
		userService.saveOneUser(user);
		return new ResponseEntity<>("User Successfully registered ",HttpStatus.CREATED);

	}
	

}
