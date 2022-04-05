package com.project.player_data_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Armor;
import com.project.player_data_control.repository.ArmorRepository;

@Service

public class ArmorService {
	@Autowired 
	private ArmorRepository armorRepository;
	
	public List<Armor> getAllArmor() {
		return armorRepository.findAll();
	}

	public Armor getOneArmorById(Long armorId) {
		return armorRepository.findById(armorId).orElse(null);
	}

	public Armor createOneArmor(Armor newArmor) {
		return armorRepository.save(newArmor);
	}

	public Armor updateOneArmorById(Long armorId, Armor newArmor) {
		Optional<Armor> armor=armorRepository.findById(armorId);
		if(armor.isPresent()) {
			Armor foundArmor=armor.get();
			foundArmor.setArmorName(newArmor.getArmorName());
			foundArmor.setArmorWeight(newArmor.getArmorWeight());
			armorRepository.save(foundArmor);
			return foundArmor;
		}
		return null;
		
	}

	public void deleteOneArmorById(Long armorId) {
		armorRepository.deleteById(armorId);
		
	}

	
	
	
	
	
	
	
	
}
