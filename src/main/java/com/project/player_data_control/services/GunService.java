package com.project.player_data_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Gun;
import com.project.player_data_control.repository.GunRepository;

@Service

public class GunService {

	@Autowired 
	private GunRepository gunRepository;
	

	public List<Gun> getAllGun() {
		return gunRepository.findAll();
	}

	public Gun getOneGunById(Long gunId) {
		return gunRepository.findById(gunId).orElse(null);
	}

	public Gun createOneGun(Gun newGun) {
		return gunRepository.save(newGun);
	}
	
	public Gun updateOneGunById(Long gunId, Gun newGun) {
		Optional<Gun> gun=gunRepository.findById(gunId);
		if(gun.isPresent()) {
			Gun foundGun=gun.get();
			foundGun.setGunName(newGun.getGunName());
			foundGun.setGunType(newGun.getGunType());
			foundGun.setGunClipCapasity(newGun.getGunClipCapasity());
			gunRepository.save(foundGun);
			return foundGun;
		}
		return null;
	}

	public void deleteOneGunById(Long gunId) {
		gunRepository.deleteById(gunId);
		
	}

	

	
	
}
