package com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // Pode incluir métodos como encontrar jogos por data ou times participantes
    List<Game> findByHomeTeamNameOrAwayTeamName(String homeTeam, String awayTeam);
}