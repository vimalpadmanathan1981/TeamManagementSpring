package com.mindtree.teamManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.teamManagement.entity.Player;
import com.mindtree.teamManagement.entity.Team;
import com.mindtree.teamManagement.exception.TeamNotFoundException;
import com.mindtree.teamManagement.repository.PlayerRepository;
import com.mindtree.teamManagement.repository.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private PlayerRepository playerRepo;
	public String addTeam(Team team) {
		teamRepo.save(team);
		String message="Team added successfully";
		return message;
		
	}
	public String updateTeamLocation(int id, Team team) throws TeamNotFoundException {
		Team teamObj = teamRepo.findById(id);
		if(teamObj==null)
		{
			throw new TeamNotFoundException("No team with this id present");
		}
		teamObj.setLocation(team.getLocation());
		teamRepo.save(teamObj);
		String message="Location updated successfully";
		return message;
	}
	public String deletePlayer(int id,int teamId) throws TeamNotFoundException {
		Team team = teamRepo.findById(teamId);
		if(team==null)
		{
			throw new TeamNotFoundException("n team with given id is present");
		}
		List<Player> playerList = team.getPlayerList();
		for(int i=0;i<playerList.size();i++)
		{
			if(playerList.get(i).getId()==id)
			{	
				team.getPlayerList().remove(i);
				break;
			}
		}
		teamRepo.save(team);
		String message="Deleted successfully";
		return message;
		
		
	}
	


	
}
