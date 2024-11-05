package com.desafio.dioSpringbootclaro.Desafio_claro.service;

import java.util.List;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    Team getUserTeam(Long id);

    List<Game> getUserGames(Long id);

    User addGamesToUser(Long userId, List<Game> gamesToAdd);
}
