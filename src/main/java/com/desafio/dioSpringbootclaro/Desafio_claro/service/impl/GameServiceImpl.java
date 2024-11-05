package com.desafio.dioSpringbootclaro.Desafio_claro.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Tournament;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.GameRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.TeamRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.TournamentRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

     @Autowired
    private TournamentRepository tournamentRepository;

    @Override
        public Game create(Game gameToCreate) {
            // Verifique e configure o homeTeam pelo nome
            Team homeTeam = gameToCreate.getHomeTeam();
            if (homeTeam.getName() != null) {
                Optional<Team> existingHomeTeam = teamRepository.findByName(homeTeam.getName());
                if (existingHomeTeam.isPresent()) {
                    homeTeam = existingHomeTeam.get();
                } else {
                    homeTeam = teamRepository.save(homeTeam);
                }
            } else {
                throw new IllegalArgumentException("Home team name must not be null");
            }
            gameToCreate.setHomeTeam(homeTeam);

            // Verifique e configure o awayTeam pelo nome
            Team awayTeam = gameToCreate.getAwayTeam();
            if (awayTeam.getName() != null) {
                Optional<Team> existingAwayTeam = teamRepository.findByName(awayTeam.getName());
                if (existingAwayTeam.isPresent()) {
                    awayTeam = existingAwayTeam.get();
                } else {
                    awayTeam = teamRepository.save(awayTeam);
                }
            } else {
                throw new IllegalArgumentException("Away team name must not be null");
            }
            gameToCreate.setAwayTeam(awayTeam);

            // Verifique e configure o tournament pelo nome
            Tournament tournament = gameToCreate.getTournament();
            if (tournament.getName() != null) {
                Optional<Tournament> existingTournament = tournamentRepository.findByName(tournament.getName());
                if (existingTournament.isPresent()) {
                    tournament = existingTournament.get();
                } else {
                    tournament = tournamentRepository.save(tournament);
                }
            } else {
                throw new IllegalArgumentException("Tournament name must not be null");
            }
            gameToCreate.setTournament(tournament);

            // Salva o jogo com os times e o torneio já verificados e configurados
            return gameRepository.save(gameToCreate);
        }


   
}