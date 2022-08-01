package repository;

import entity.Club;
import entity.League;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LeagueRepository extends League {


    public LeagueRepository(Long id, String name, String sportType, Club clubHome, Club clubAway, boolean home_win, boolean away_win, String matchDate) {
        super(id, name, sportType, clubHome, clubAway, home_win, away_win, matchDate);
    }

    public LeagueRepository() {
        super();
    }

    public static void creatTable() throws SQLException {
        String sql = "create table if not exists league_table(" +
                "id serial primary key ," +
                "name varchar(255)," +
                "sport_type varchar(255)," +
                "home_club_name varchar(255)," +
                "away_club_name varchar(255)," +
                "home_win bool," +
                "away_win bool," +
                "match_date date)";
        Statement stm = ApplicationConstant.getConnection().createStatement();
        stm.executeUpdate(sql);
    }

    public static League addGameToLeague(League league, Club homeClub, Club awayClub) throws SQLException {
        String sql = "insert into league_table(name, sport_type, home_club_name,away_club_name,home_win, away_win, match_date)values (?,?,?,?,?,?,to_date(?,'yyy,mm,dd'))";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, league.getName());
        ps.setString(2, league.getSportType());
        ps.setString(3, homeClub.getName());
        ps.setString(4, awayClub.getName());
        ps.setBoolean(5, league.isHome_win());
        ps.setBoolean(6, league.isAway_win());
        ps.setString(7, league.getMatchDate());
        ps.executeUpdate();
        if (ps.getGeneratedKeys().next()) {
            league.setId(ps.getGeneratedKeys().getLong(1));
        }
        if(league.isHome_win() && !league.isAway_win()){
            ClubRepository.matchClubUpdate(homeClub,+1,0,0,+1);
            ClubRepository.matchClubUpdate(awayClub,0,+1,0,-1);
        } else if (league.isAway_win() && !league.isHome_win()) {
            ClubRepository.matchClubUpdate(homeClub,0,+1,0,-1);
            ClubRepository.matchClubUpdate(awayClub,1,0,0,+1);
        }else {
            ClubRepository.matchClubUpdate(homeClub,0,0,1,0);
            ClubRepository.matchClubUpdate(awayClub,0,0,1,0);
        }
        return league;

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
