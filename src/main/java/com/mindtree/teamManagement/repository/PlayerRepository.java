package com.mindtree.teamManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.teamManagement.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	public Player findById(int id);
	
}
