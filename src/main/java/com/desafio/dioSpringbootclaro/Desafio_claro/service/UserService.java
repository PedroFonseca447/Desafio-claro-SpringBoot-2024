package com.desafio.dioSpringbootclaro.Desafio_claro.service;

import java.util.List;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;

public interface UserService {

    User findById(Long id);//funfa

    User create(User userToCreate);//funfa

    Team getUserTeam(Long id);//funfa

    List<Game> getUserGames(Long id);//funfa

    List<Game> addGamesToUser(Long userId, List<Game> gamesToAdd);//funfa

    User delete(Long id);
}
