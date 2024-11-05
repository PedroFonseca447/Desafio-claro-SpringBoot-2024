package com.desafio.dioSpringbootclaro.Desafio_claro.service;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
