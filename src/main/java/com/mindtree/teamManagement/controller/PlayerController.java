package com.mindtree.teamManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.teamManagement.entity.Player;
import com.mindtree.teamManagement.exception.TeamNotFoundException;
import com.mindtree.teamManagement.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(method = RequestMethod.POST, value = "/player/{id}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player, @PathVariable int id) {
		String message = "";
		try {
			message = playerService.addPlayer(player, id);
		} catch (TeamNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(message, HttpStatus.CREATED);
	}

	@RequestMapping("/player/playerByTeamName/{name}")
	public ResponseEntity getplayerByTeamName(@PathVariable String name) {
		List<Player> playerList;
		try {
			playerList = playerService.getPlayerByTeamName(name);
		} catch (TeamNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(playerList, HttpStatus.OK);
	}
	

}
