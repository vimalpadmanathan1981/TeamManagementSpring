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
import com.mindtree.teamManagement.entity.Team;
import com.mindtree.teamManagement.exception.PlayerNotFoundException;
import com.mindtree.teamManagement.exception.TeamNotFoundException;
import com.mindtree.teamManagement.service.PlayerService;
import com.mindtree.teamManagement.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(method = RequestMethod.POST, value = "/team")
	public ResponseEntity<?> addTeam(@RequestBody Team team) {
		String message = "";

		message = teamService.addTeam(team);

		return new ResponseEntity(message, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/team/{id}")
	public ResponseEntity updateTeamLocation(@PathVariable int id, @RequestBody Team team) {
		String message;
		try {
			message = teamService.updateTeamLocation(id, team);
		} catch (TeamNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(message, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/student/deletePlayer/{id}/{teamId}")
	public ResponseEntity deletePlayer(@PathVariable int id,@PathVariable int teamId) {
		String message;
		try {
			message = teamService.deletePlayer(id,teamId);
		} catch (TeamNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(message, HttpStatus.OK);
	}

}
