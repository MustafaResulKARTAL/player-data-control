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
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String userName;
	String userPassword;
	String userEmail;
	String userLocation;
	String role;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition = "inventory_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Inventory inventory;

}
