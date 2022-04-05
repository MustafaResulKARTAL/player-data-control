package com.project.player_data_control.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {

	String userName;
	String userPassword;
	String userEmail;
	String userLocation;
	String role;
	Long inventoryId;
	
}
