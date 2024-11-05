package com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{



}
