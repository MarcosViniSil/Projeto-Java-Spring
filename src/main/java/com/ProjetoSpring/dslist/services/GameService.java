package com.ProjetoSpring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ProjetoSpring.dslist.dto.GameMinDTO;
import com.ProjetoSpring.dslist.entities.Game;
import com.ProjetoSpring.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository ;
	
	@GetMapping
  public List<GameMinDTO> findAll(){
	 List<Game> result=gameRepository.findAll();
	 List<GameMinDTO> dto=result.stream().map(x -> new GameMinDTO(x)).toList();
	 return dto;
	 
  }
}
