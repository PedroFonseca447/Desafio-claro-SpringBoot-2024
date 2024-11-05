package com.desafio.dioSpringbootclaro.Desafio_claro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.model.Tournament;
@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    // Métodos adicionais, como busca de torneio por nome
    Optional<Tournament> findByName(String name);
}