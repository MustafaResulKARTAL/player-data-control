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

import com.project.player_data_control.entityes.Armor;
import com.project.player_data_control.services.ArmorService;

@RestController
@RequestMapping("/armors")

public class ArmorController {
	@Autowired 
	private ArmorService armorService;
	
	@GetMapping
	public List<Armor> getAllArmor(){
		return armorService.getAllArmor();
	}
	
	@GetMapping("/{armorId}")
	public Armor getOneArmorById(@PathVariable Long armorId) {
		return armorService.getOneArmorById(armorId);
	}
	@PostMapping
	public Armor createOneArmor(@RequestBody Armor newArmor) {
		return armorService.createOneArmor(newArmor);
	}
	@PutMapping("/{armorId}")
	public Armor updateOneArmorById(@PathVariable Long armorId,@RequestBody Armor newArmor) {
		return armorService.updateOneArmorById(armorId,newArmor);
	}
	@DeleteMapping("/{armorId}")
	public void deleteOneArmorById(@PathVariable Long armorId) {
		armorService.deleteOneArmorById(armorId);
	}
	
	
	
	
	

}
