package com.ProjetoSpring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoSpring.dslist.dto.GameDTO;
import com.ProjetoSpring.dslist.dto.GameMinDTO;
import com.ProjetoSpring.dslist.services.GameService;

@RestController
@RequestMapping(value="/games")
public class GameControler {
	
	@Autowired
	private GameService gameService ;
	
	@GetMapping(value="/{id}")
	public GameDTO findbyid(@PathVariable Long id){
		GameDTO result=gameService.findbyid(id);
		return result;
	}
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result=gameService.findAll();
		return result;
	}
}
