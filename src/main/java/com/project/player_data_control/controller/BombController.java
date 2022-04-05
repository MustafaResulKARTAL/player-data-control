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

import com.project.player_data_control.entityes.Bomb;
import com.project.player_data_control.services.BombService;

@RestController
@RequestMapping("/bombs")
public class BombController {
	
	@Autowired 
	private BombService bombService;
	
	@GetMapping
	public List<Bomb> getAllBombs(){
		return bombService.getAllBombs();
	}
	
	@GetMapping("/{bombId}")
	public Bomb getOneBombById(@PathVariable Long bombId) {
		return bombService.getOneBombById(bombId);
	}
	
	@PostMapping 
	public Bomb createOneBomb(@RequestBody Bomb newBomb) {
		return bombService.createOneBomb(newBomb);
	}
	
	@PutMapping("/{bombId}")
	public Bomb updateOneBombById(@PathVariable Long bombId,@RequestBody Bomb newBomb) {
		return bombService.updateOneBombById(bombId,newBomb);
	}
	
	@DeleteMapping("/{bombId}")
	public void deleteOneBombById(@PathVariable Long bombId) {
	     bombService.deleteOneBombById(bombId);
		
	}
	
	
	
	
	
	
	
}
