package repository;

import entity.Club;
import services.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubRepository extends Club {
    public ClubRepository(Long clubId, String name, int allGames, int wins, int lost, int score, Long playedVsId) {
        super(clubId, name, allGames, wins, lost, score, playedVsId);
    }

    public static void createTable(String name) throws SQLException {
        String sql = "create table if not exists ? (" +
                "id serial primary key not null," +
                "name varchar(255) uniqe not null," +
                "all_games int," +
                "wins int," +
                "lost int," +
                "score int not null";
        Statement ps = ApplicationConstant.getConnection().createStatement();
        ps.setCursorName(name);
        ps.executeUpdate(sql);
    }
}
