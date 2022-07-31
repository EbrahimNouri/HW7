package entity;

import java.util.Objects;

public abstract class Club  {
    private Long clubId;
    private String name;
    private int allGames;
    private int wins;
    private int lost;
    private int score;
    private Long playedVsId;

    public Club(Long clubId, String name, int allGames, int wins, int lost, int score, Long playedVsId) {
        this.clubId = clubId;
        this.name = name;
        this.allGames = allGames;
        this.wins = wins;
        this.lost = lost;
        this.score = score;
        this.playedVsId = playedVsId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllGames() {
        return allGames;
    }

    public void setAllGames(int allGames) {
        this.allGames = allGames;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getPlayedVsId() {
        return playedVsId;
    }

    public void setPlayedVsId(Long playedVsId) {
        this.playedVsId = playedVsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return allGames == club.allGames && wins == club.wins && lost == club.lost && score == club.score && playedVsId == club.playedVsId && clubId.equals(club.clubId) && name.equals(club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, name, allGames, wins, lost, score, playedVsId);
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId=" + clubId +
                ", name='" + name + '\'' +
                ", allGames=" + allGames +
                ", wins=" + wins +
                ", lost=" + lost +
                ", score=" + score +
                ", playedVsId=" + playedVsId +
                '}';
    }
}
