package com.project.player_data_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.player_data_control.entityes.Gun;

public interface GunRepository extends JpaRepository<Gun, Long> {

}
