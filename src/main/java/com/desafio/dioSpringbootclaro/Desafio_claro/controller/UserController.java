package com.desafio.dioSpringbootclaro.Desafio_claro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Game;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.Team;
import com.desafio.dioSpringbootclaro.Desafio_claro.domain.model.User;
import com.desafio.dioSpringbootclaro.Desafio_claro.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    //funciona em principío
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
         //path de onde o usuario foi criado e retorna ele funcionando
        return ResponseEntity.created(location).body(userCreated);
    }
    //funciona
    @GetMapping("{id}/team")
    public ResponseEntity<Team> getUserTeam(@PathVariable Long id){
        var team = userService.getUserTeam(id);
        return ResponseEntity.ok(team);
    }
    // deu problema 
    @GetMapping("{id}/games")
    public ResponseEntity<List<Game>> getUserGames(@PathVariable Long id) {
        List<Game> games = userService.getUserGames(id);
        return ResponseEntity.ok(games);
    }
    
    //funciona
    @PostMapping("/{id}/games")
    public User addGamesToUser(@PathVariable Long id, @RequestBody List<Game> gamesToAdd) {
        return userService.addGamesToUser(id, gamesToAdd);
    }

}
