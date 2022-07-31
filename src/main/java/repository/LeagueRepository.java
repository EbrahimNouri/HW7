package repository;

import entity.Club;
import entity.League;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LeagueRepository extends League {
    public LeagueRepository(Long id, String name, String sportType, String fromDate, String thruDate) {
        super(id, name, sportType, fromDate, thruDate);
    }

    public static void CreatTable() throws SQLException {
        String sql = "create table if not exists League_table(" +
                "id serial primary key ," +
                "name varchar(255)," +
                "sport_type varchar(255)," +
                "from_date Date," +
                "thru_date date)";
        Statement stm = ApplicationConstant.getConnection().createStatement();
        stm.executeUpdate(sql);
    }

    public void addClub(Club club) {
        //String sql = "insert into ";
        //PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);

    }

    public void removeClub(Club club) {

    }

    public int VSgames(Club club1, Club club2) {
        return 0;
    }

    public void clubInfo(Club club) {

    }

    public void ShowTableSortByScore(Club club) {

    }

}
