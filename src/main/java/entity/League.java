package entity;

import java.util.Objects;

public abstract class League {
    private Long id;
    private String name;
    private String SportType;
    private String fromDate;
    private String thruDate;

    public League(Long id, String name, String sportType, String fromDate, String thruDate) {
        this.id = id;
        this.name = name;
        SportType = sportType;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getThruDate() {
        return thruDate;
    }

    public void setThruDate(String thruDate) {
        this.thruDate = thruDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return Objects.equals(id, league.id) && Objects.equals(name, league.name) && Objects.equals(SportType, league.SportType) && Objects.equals(fromDate, league.fromDate) && Objects.equals(thruDate, league.thruDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, SportType, fromDate, thruDate);
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SportType='" + SportType + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", thruDate='" + thruDate + '\'' +
                '}';
    }
}
