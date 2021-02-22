package com.mindtree.teamManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindtree.teamManagement.entity.Player;
import com.mindtree.teamManagement.entity.Team;
import com.mindtree.teamManagement.exception.TeamNotFoundException;
import com.mindtree.teamManagement.repository.PlayerRepository;
import com.mindtree.teamManagement.repository.TeamRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepo;
	@Autowired
	private TeamRepository teamRepo;

	public String addPlayer(Player player, int id) throws TeamNotFoundException {

		Team team = teamRepo.findById(id);
		if (team == null) {
			throw new TeamNotFoundException("No team with this id is present");
		}
		team.getPlayerList().add(player);
		teamRepo.save(team);
		String message = "Student addedd successfully";
		return message;
	}

	public List<Player> getPlayerByTeamName(String name) throws TeamNotFoundException  {
		List<Team> teamList=new ArrayList<>();
		List<Player> playerList=new ArrayList<>();
		teamRepo.findAll().forEach(teamList :: add);
		
		for(Team team : teamList )
		{
			if(team.getName().equals(name))
			{
				playerList=team.getPlayerList();
			}
		}
		if(playerList.size()==0)
		{
			throw new TeamNotFoundException("No team with this name");
		}
		return playerList;
	}
	
	

}
