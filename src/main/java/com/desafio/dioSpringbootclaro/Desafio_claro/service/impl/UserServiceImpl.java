package com.desafio.dioSpringbootclaro.Desafio_claro.service.impl;

import org.springframework.stereotype.Service;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.repository.UserRepository;
import com.desafio.dioSpringbootclaro.Desafio_claro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public User create(User userToCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
