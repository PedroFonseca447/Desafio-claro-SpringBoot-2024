package com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u.team FROM User u WHERE u.id = :id")
    Optional<Team> getUserTeam(@Param("id") Long id);

    @Query("SELECT u.games FROM User u WHERE u.id = :id")
    List<Game> getUserGames(@Param("id") Long id);

}
