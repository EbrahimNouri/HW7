package repository;

import entity.Club;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubRepository extends Club {


    public ClubRepository(Long clubId, String name, int allGames, int wins, int equals, int lost, int score, Long playedVsId) {
        super(clubId, name, allGames, wins, equals, lost, score, playedVsId);
    }

    public static void createTable() throws SQLException {
        String sql = "create table if not exists club_table(" +
                "id serial primary key," +
                "name varchar(255) unique not null," +
                "all_games int," +
                "wins int," +
                "equals int," +
                "lost int," +
                "score int)";
        Statement stm = ApplicationConstant.getConnection().createStatement();
        stm.executeUpdate(sql);
    }

    public static void updateClub(Club club) throws SQLException {
        String sql = "update club_table set all_games = ?, wins= ?, equals = ? , lost = ?, score = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setInt(1, club.getAllGames());
        ps.setInt(2, club.getWins());
        ps.setInt(3, club.getEquals());
        ps.setInt(4, club.getLost());
        ps.setInt(5, club.getScore());
        int check = ps.executeUpdate();
        if (check == 1) {
            System.out.println("\""+club.getName()+"\" with id :\""+ club.getClubId()+ "\" successfully updated ");
        }
    }

    public static void matchClubUpdate(Club club, int win, int lost, int equal, int score) throws SQLException {
        String sql = "update club_table set all_games = ?, wins= ?, equals = ? , lost = ?, score = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setInt(1, club.getAllGames() + 1 );
        ps.setInt(2, club.getWins() + win);
        ps.setInt(3, club.getEquals() + equal);
        ps.setInt(4, club.getLost() + lost);
        ps.setInt(5, club.getScore() + score);
        int check = ps.executeUpdate();
        if (check == 1) {
            System.out.println("\""+club.getName()+"\" with id :\""+ club.getClubId()+ "\" successfully updated ");
        }
    }

    public static Club findClubWithName(String name) throws SQLException {
        Club club = new Club();
        String sql = "select * from club_table where name = ?";
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            club.setClubId(rs.getLong(1));
            club.setName(name);
            club.setAllGames(rs.getInt(3));
            club.setWins(rs.getInt(4));
            club.setEquals(rs.getInt(5));
            club.setLost(rs.getInt(6));
            club.setScore(rs.getInt(7));
            club.setPlayedVsId(rs.getLong(8));
        }
        return club;
    }


}
