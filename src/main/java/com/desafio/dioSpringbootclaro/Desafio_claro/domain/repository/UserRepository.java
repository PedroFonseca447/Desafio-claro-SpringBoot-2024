package com.desafio.dioSpringbootclaro.Desafio_claro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dioSpringbootclaro.Desafio_claro.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{



}
