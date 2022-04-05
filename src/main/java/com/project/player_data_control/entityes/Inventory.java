package com.project.player_data_control.entityes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import lombok.Data;

@Entity
@Data
@Table(name="inventory")

public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bomb_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Bomb bomb;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="gun_id",nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	Gun gun;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="armor_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Armor armor;

}
