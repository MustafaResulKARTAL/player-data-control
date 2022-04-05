package com.project.player_data_control.requests;

import lombok.Data;

@Data
public class InventoryCreateRequest {
	
	Long bombId; 
	Long gunId;
	Long armorId;
	
}
