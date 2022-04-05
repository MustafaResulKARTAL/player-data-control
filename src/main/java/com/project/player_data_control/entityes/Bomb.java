package com.project.player_data_control.entityes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="bomb")

public class Bomb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String bombType;
	
}
