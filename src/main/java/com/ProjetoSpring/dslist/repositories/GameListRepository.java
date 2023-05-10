package com.ProjetoSpring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoSpring.dslist.entities.Game;
import com.ProjetoSpring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{

}
