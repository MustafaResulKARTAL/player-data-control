package com.project.player_data_control.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.player_data_control.entityes.Bomb;
import com.project.player_data_control.repository.BombRepository;
@Service
public class BombService {

	@Autowired 
	private BombRepository bombRepository;
	


	public List<Bomb> getAllBombs() {
		return bombRepository.findAll();
	}


	public Bomb getOneBombById(Long bombId) {
		return bombRepository.findById(bombId).orElse(null);
	}


	public Bomb createOneBomb(Bomb newBomb) {
		return bombRepository.save(newBomb);
		
	}


	public Bomb updateOneBombById(Long bombId,Bomb newBomb) {
		
		Optional<Bomb> bomb =bombRepository.findById(bombId);
		if(bomb.isPresent()) {
			Bomb foundBomb=bomb.get();
			foundBomb.setBombType(newBomb.getBombType());
			bombRepository.save(foundBomb);
			return foundBomb;
		}
		return null;
	}


	public void deleteOneBombById(Long bombId) {
		bombRepository.deleteById(bombId);
	}

	
}
