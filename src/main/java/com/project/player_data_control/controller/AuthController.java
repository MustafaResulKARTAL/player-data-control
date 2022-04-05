package com.project.player_data_control.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.player_data_control.requests.UserCreateRequest;
import com.project.player_data_control.requests.UserRequest;
import com.project.player_data_control.responses.AuthResponse;
import com.project.player_data_control.services.AuthService;



@RestController
@RequestMapping("/auth")
public class AuthController {
	private AuthService authService;



	public AuthController(AuthService authService) {
		this.authService=authService;
	}
	
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody UserRequest loginRequest) {
		return authService.login(loginRequest);
	}
	
	
	@PostMapping("/register")
	
	public ResponseEntity<String> register(@RequestBody UserCreateRequest registerRequest){
		
		return authService.register(registerRequest);
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
