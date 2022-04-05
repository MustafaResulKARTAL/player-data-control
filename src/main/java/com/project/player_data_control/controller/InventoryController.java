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

import com.project.player_data_control.entityes.Inventory;
import com.project.player_data_control.requests.InventoryCreateRequest;
import com.project.player_data_control.requests.InventoryUpdateRequest;
import com.project.player_data_control.services.InventoryService;

@RequestMapping("/inventory")
@RestController

public class InventoryController {
	
	@Autowired 
	private InventoryService inventoryService;
	
	
	@GetMapping
	public List<Inventory> getAllInventory(){
		return inventoryService.getAllInventory();
	}
	@GetMapping("/{inventoryId}")
	public Inventory getOneInventoryById(@PathVariable Long inventoryId) {
		return inventoryService.getOneInventoryById(inventoryId);
	}
	@PostMapping
	public Inventory createOneInventory(@RequestBody InventoryCreateRequest newInvontoryRequest ) {
		return inventoryService.createOneInventory(newInvontoryRequest);
	}
	@PutMapping("/{inventoryId}")
	public Inventory updateOneInventoryById(@PathVariable Long inventoryId,
			@RequestBody InventoryUpdateRequest newInventoryRequest) {
		return inventoryService.updateOneInventoryById(inventoryId,newInventoryRequest);
	}
	
	@DeleteMapping("/{inventoryId}")
	public void deleteOneInventoryById(@PathVariable Long inventoryId) {
		inventoryService.deleteOneInventoryById(inventoryId);
	}
	
	
	

}
