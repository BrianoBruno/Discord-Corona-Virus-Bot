package com.corona.chan.discord.bot.entity;

public class CountryResponse {

    private String country;
    private Cases cases;
    private Deaths deaths;
    private String day;
    private String time;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Cases getCases() {
        return cases;
    }

    public void setCases(Cases cases) {
        this.cases = cases;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "country='" + country + '\'' +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
