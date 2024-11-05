package com.desafio.dioSpringbootclaro.Desafio_claro.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
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
        return userRepository.getUserGames(userId);
    }

    @Transactional
    @Override
    public User addGamesToUser(Long userId, List<Game> gamesToAdd) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        // Adicione as novas partidas à lista de jogos do usuário
        user.getGames().addAll(gamesToAdd);

        // Salve o usuário com a lista de partidas atualizada
        return userRepository.save(user);
    }
}
