package com.desafio.dioSpringbootclaro.Desafio_claro.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Tournament;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.GameRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.TeamRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.TournamentRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.UserRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    private final TournamentRepository tournamentRepository;

    private final GameRepository gameRepository;

    public UserServiceImpl(UserRepository userRepository, TeamRepository teamRepository, TournamentRepository tournamentRepository, GameRepository gameRepository){
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.tournamentRepository = tournamentRepository;
        this.gameRepository = gameRepository;

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException ::new );
    }

    @Override
    public User create(User userToCreate) {
        // Verifique se o ID está presente e já existe
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        
        // Salve o usuário sem se preocupar com o ID, ele será gerado automaticamente
        return userRepository.save(userToCreate);
    }

    @Override
    public Team getUserTeam(Long id) {
        return userRepository.getUserTeam(id)
                             .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Game> getUserGames(Long userId) {
        User user = userRepository.findById(userId)
                      .orElseThrow(() -> new NoSuchElementException("User not found"));
    
        // Inicializa a lista de jogos para evitar LazyInitializationException
        List<Game> games = user.getGames();
        games.size(); // Força a inicialização
    
        return games;
    }

    @Transactional
    @Override
    public List<Game> addGamesToUser(Long userId, List<Game> gamesToAdd) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found"));

    for (Game game : gamesToAdd) {
      
        Team homeTeam = game.getHomeTeam();
        if (homeTeam != null && homeTeam.getName() != null) {
            final Team finalHomeTeam = homeTeam;
            homeTeam = teamRepository.findByName(homeTeam.getName())
                       .orElseGet(() -> teamRepository.save(finalHomeTeam));
            game.setHomeTeam(homeTeam); 
        } else {
            throw new IllegalArgumentException("Home team name must not be null");
        }

       
        Team awayTeam = game.getAwayTeam();
        if (awayTeam != null && awayTeam.getName() != null) {
            final Team finalAwayTeam = awayTeam;
            awayTeam = teamRepository.findByName(awayTeam.getName())
                       .orElseGet(() -> teamRepository.save(finalAwayTeam));
            game.setAwayTeam(awayTeam);  
        } else {
            throw new IllegalArgumentException("Away team name must not be null");
        }

      
        Tournament tournament = game.getTournament();
        if (tournament != null && tournament.getName() != null) {
            final Tournament finalTournament = tournament;

            tournament = tournamentRepository.findByName(tournament.getName())
                          .orElseGet(() -> tournamentRepository.save(finalTournament));
            game.setTournament(tournament);  
        } else {
            throw new IllegalArgumentException("Tournament name must not be null");
        }

        
        game.setUser(user);
        gameRepository.save(game);  
    }
    
    user.getGames().addAll(gamesToAdd);
    userRepository.save(user);  

    return gamesToAdd;  
    }

    @Override
    public User delete(Long id) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("User not found"));

        userRepository.delete(user);
       return user;
    }

}

