package com.project.player_data_control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.player_data_control.entityes.Bomb;

public interface BombRepository extends JpaRepository <Bomb,Long> {


}
