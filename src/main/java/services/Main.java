package services;

import entity.Club;
import repository.ClubRepository;
import repository.LeagueRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //ApplicationConstant.getConnection();
       // ClubRepository.createTable("Football");
        LeagueRepository.CreatTable();
    }
}
