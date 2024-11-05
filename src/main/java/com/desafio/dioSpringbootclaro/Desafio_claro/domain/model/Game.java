package com.desafio.dioSpringbootclaro.Desafio_claro.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

     @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;
    private String score;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tournament_id") // Define a coluna de chave estrangeira para o torneio
    private Tournament tournament;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
// {
//     "name": "Pedro Seco",
//     "idade": 22,
//     "cidade": "Porto Alegre",
//     "team": {
//         "name": "Gremio",
//         "city": "Rio Grande do Sul",
//         "stadium": "ARENA DO GREMIO",
//         "anoFundacao": 1903
//     },
//     "games": []
// }

// [
//   {
//     "date": "2024-11-28",
//     "homeTeam": {
//       "name": "Gremio",
//       "city": "Porto Alegre",
//       "stadium": "ARENA DO GREMIO",
//       "anoFundacao": 1903
//     },
//     "awayTeam": {
//       "name": "ATL Goianiense",
//       "city": "Goiania",
//       "stadium": "Olimpico de Goias",
//       "anoFundacao": 1940
//     },
//     "score": "3-1",
//     "tournament": {
//       "name": "Brasileirão",
//       "country": "Brasil"
//     }
//   }
// ]