package com.ProjetoSpring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoSpring.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long> {

}
