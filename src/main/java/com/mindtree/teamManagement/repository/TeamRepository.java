package com.mindtree.teamManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.teamManagement.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
		public Team findById(int id);
}
