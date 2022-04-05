package com.project.player_data_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Armor;
import com.project.player_data_control.entityes.Bomb;
import com.project.player_data_control.entityes.Gun;
import com.project.player_data_control.entityes.Inventory;
import com.project.player_data_control.repository.InventoryRepository;
import com.project.player_data_control.requests.InventoryCreateRequest;
import com.project.player_data_control.requests.InventoryUpdateRequest;

@Service

public class InventoryService {
	@Autowired
	private BombService bombService;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private ArmorService armorService;
	@Autowired
	private GunService gunService;


	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	public Inventory getOneInventoryById(Long inventoryId) {
		return inventoryRepository.findById(inventoryId).orElse(null);
	}

	public Inventory createOneInventory(InventoryCreateRequest newInvontoryRequest) {
		Bomb bomb=bombService.getOneBombById(newInvontoryRequest.getBombId());
		Gun gun =gunService.getOneGunById(newInvontoryRequest.getGunId());
		Armor armor=armorService.getOneArmorById(newInvontoryRequest.getArmorId());
		if(bomb != null && gun != null && armor!=null) {
			Inventory inventoryToSave=new Inventory();
			inventoryToSave.setArmor(armor);
			inventoryToSave.setBomb(bomb);
			inventoryToSave.setGun(gun);
			return inventoryRepository.save(inventoryToSave);
		}
		else {
			System.out.println("nesnelerden 1 i boş");
			return null;
		}
		
		
		
	}

	public Inventory updateOneInventoryById(Long inventoryId, 
			InventoryUpdateRequest newInventoryRequest) {
		Optional<Inventory> inventory=inventoryRepository.findById(inventoryId);
		if(inventory.isPresent()) {
			Bomb bomb=bombService.getOneBombById(newInventoryRequest.getBombId());
			Gun gun =gunService.getOneGunById(newInventoryRequest.getGunId());
			Armor armor=armorService.getOneArmorById(newInventoryRequest.getArmorId());
			if(bomb != null && gun != null && armor!=null) {
				Inventory inventoryToUpdate=inventory.get();
				inventoryToUpdate.setArmor(armor);
				inventoryToUpdate.setBomb(bomb);
				inventoryToUpdate.setGun(gun);
				return inventoryRepository.save(inventoryToUpdate);
			}
			return null;
		}
		
		return null;
	}

	public void deleteOneInventoryById(Long inventoryId) {
		inventoryRepository.deleteById(inventoryId);
		
	}







}
