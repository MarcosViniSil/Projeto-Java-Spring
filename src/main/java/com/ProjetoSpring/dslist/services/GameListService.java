package com.ProjetoSpring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetoSpring.dslist.dto.GameListDTO;
import com.ProjetoSpring.dslist.entities.GameList;
import com.ProjetoSpring.dslist.projections.GameMinProjection;
import com.ProjetoSpring.dslist.repositories.GameListRepository;
import com.ProjetoSpring.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository ;
	
	@Autowired
	private GameRepository gameRepository ;
	
	   @Transactional(readOnly=true)
	   public List<GameListDTO> findAll(){
	 	 List<GameList> result=gameListRepository.findAll();
	 	 List<GameListDTO> dto=result.stream().map(x -> new GameListDTO(x)).toList();
	 	 return dto;
	 	 
	   }
	   @Transactional
	   public void move(Long listId,int sourceIndex,int destionationIndex) {
		   List<GameMinProjection> list=gameRepository.searchByList(listId);
		   
		   GameMinProjection obj=list.remove(sourceIndex);
		   list.add(destionationIndex,obj);
		   
		   int min=sourceIndex<destionationIndex ? sourceIndex:destionationIndex;
		   int max=sourceIndex<destionationIndex ? destionationIndex:sourceIndex;
		   
		   for (int i = min; i <=max; i++) {
			   gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	   }
}
