package com.desafio.dioSpringbootclaro.Desafio_claro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.GameRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.TeamRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Game create(Game gameToCreate) {
        // Verifica e define o homeTeam
        Team homeTeam = gameToCreate.getHomeTeam();
        if (homeTeam.getId() != null) {
            // Busca pelo ID se ele estiver presente
            Team finalHomeTeam = homeTeam;
            homeTeam = teamRepository.findById(homeTeam.getId()).orElseGet(() -> teamRepository.save(finalHomeTeam));
        } else if (homeTeam.getName() != null) {
            // Busca pelo nome se o ID não está presente
            Team finalHomeTeam = homeTeam;
            homeTeam = teamRepository.findByName(homeTeam.getName()).orElseGet(() -> teamRepository.save(finalHomeTeam));
        } else {
            // Salva o homeTeam se não tiver nenhuma identificação
            homeTeam = teamRepository.save(homeTeam);
        }
        gameToCreate.setHomeTeam(homeTeam);

        // Verifica e define o awayTeam
        Team awayTeam = gameToCreate.getAwayTeam();
        if (awayTeam.getId() != null) {
            Team finalAwayTeam = awayTeam;
            awayTeam = teamRepository.findById(awayTeam.getId()).orElseGet(() -> teamRepository.save(finalAwayTeam));
        } else if (awayTeam.getName() != null) {
            Team finalAwayTeam = awayTeam;
            awayTeam = teamRepository.findByName(awayTeam.getName()).orElseGet(() -> teamRepository.save(finalAwayTeam));
        } else {
            awayTeam = teamRepository.save(awayTeam);
        }
        gameToCreate.setAwayTeam(awayTeam);

        // Salva o jogo com os times já persistidos
        return gameRepository.save(gameToCreate);
    }


   
}