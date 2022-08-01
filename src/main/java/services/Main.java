package services;

import entity.Club;
import entity.League;
import repository.ClubRepository;
import repository.LeagueRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Club real = new Club(2l, "real", 25, 12, 12, 1, 3l);
        Club barca = new Club(2l, "barca", 25, 12, 12, 1, 3l);
        LeagueRepository league = new LeagueRepository(1l, "Spania", "football", real, barca,true, false, "2002/02/09");
        //ApplicationConstant.getConnection();
       // ClubRepository.createTable("Football");
        //LeagueRepository.creatTable();
        LeagueRepository leagueRepository = new LeagueRepository();
        ClubRepository.createTable();
        LeagueRepository.creatTable();
//        LeagueRepository.addGameToLeague(league, real, barca);

    }
}
