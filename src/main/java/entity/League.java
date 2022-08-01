package entity;

import java.util.Objects;

public abstract class  League {
    private Long id;
    private String name;
    private String SportType;
    private Club clubHome;
    private Club clubAway;
    private boolean home_win;
    private boolean away_win;
    private String matchDate;

    public League(Long id, String name, String sportType, Club clubHome, Club clubAway, boolean home_win, boolean away_win, String matchDate) {
        this.id = id;
        this.name = name;
        SportType = sportType;
        this.clubHome = clubHome;
        this.clubAway = clubAway;
        this.home_win = home_win;
        this.away_win = away_win;
        this.matchDate = matchDate;
    }

    public League() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportType() {
        return SportType;
    }

    public void setSportType(String sportType) {
        SportType = sportType;
    }

    public Club getClubHome() {
        return clubHome;
    }

    public void setClubHome(Club clubHome) {
        this.clubHome = clubHome;
    }

    public Club getClubAway() {
        return clubAway;
    }

    public void setClubAway(Club clubAway) {
        this.clubAway = clubAway;
    }

    public boolean isHome_win() {
        return home_win;
    }

    public void setHome_win(boolean home_win) {
        this.home_win = home_win;
    }

    public boolean isAway_win() {
        return away_win;
    }

    public void setAway_win(boolean away_win) {
        this.away_win = away_win;
    }



    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return home_win == league.home_win && away_win == league.away_win && Objects.equals(id, league.id) && Objects.equals(name, league.name) && Objects.equals(SportType, league.SportType) && Objects.equals(clubHome, league.clubHome) && Objects.equals(clubAway, league.clubAway) && Objects.equals(matchDate, league.matchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, SportType, clubHome, clubAway, home_win, away_win, matchDate);
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SportType='" + SportType + '\'' +
                ", clubHome=" + clubHome +
                ", clubAway=" + clubAway +
                ", home_win=" + home_win +
                ", away_win=" + away_win +
                ", matchDate='" + matchDate + '\'' +
                '}';
    }
}
