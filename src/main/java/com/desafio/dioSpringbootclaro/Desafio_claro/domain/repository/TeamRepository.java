package com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Métodos personalizados, como encontrar um time pelo nome
    Optional<Team> findByName(String name);
}