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

import com.project.player_data_control.entityes.Gun;
import com.project.player_data_control.services.GunService;

@RequestMapping("/guns")
@RestController

public class GunController {
	
	@Autowired 
	private GunService gunServive;

	
	@GetMapping
	public List<Gun> getAllGuns(){
		return gunServive.getAllGun();
	}
	
	@GetMapping("/{gunId}")
	public Gun getOneGunById(@PathVariable Long gunId) {
		return gunServive.getOneGunById(gunId);
	}
	
	@PostMapping
	public Gun createOneGun(@RequestBody Gun newGun) {
		return gunServive.createOneGun(newGun);
	}
	@PutMapping("/{gunId}")
	public Gun updateOneGunById(@PathVariable Long gunId,@RequestBody Gun newGun) {
		return gunServive.updateOneGunById(gunId,newGun);
	}
	@DeleteMapping("/{gunId}")
		public void deleteOneGunById(@PathVariable Long gunId) {
			gunServive.deleteOneGunById(gunId);
	}
	
	
	
	
	
	
}
