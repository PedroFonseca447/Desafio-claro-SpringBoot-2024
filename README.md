# Claro dev SpringBoot
Java RESTful API criada para finalizar o curso Springboot claro

Uma api criada como exemplo de estudos e com algo que é de meu cotidiano( salvar partidas de futebol que já vi em minha vida, junto de torneios e times), além de oferecer uma classe de time favorito. Esse projeto fez parte do curso de SpringBoot da claro com a plataforma DIO. Essa api está para rodar tanto local como na nuvem usando Railway

```mermaid
classDiagram
    class User {
        +String name
        +Team team
        +Game[] games
        +Tournament[] tournaments
    }

    class Team {
        +String name
        +String city
        +String stadium
        +String[] players
    }

    class Game {
        +String date
        +Team homeTeam
        +Team awayTeam
        +String score
        +Tournament tournament
    }

    class Tournament {
        +String name
        +String country
    }

   
    User "1" --> "1" Team : favorite team
    User "1" --> "0..*" Game : attends
    Game "1" --> "1" Team : homeTeam
    Game "1" --> "1" Team : awayTeam
    Game "1" --> "1" Tournament : part of
```
