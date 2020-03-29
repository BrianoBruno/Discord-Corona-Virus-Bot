package com.corona.chan.discord.bot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deaths {
    @JsonProperty("new")
    private Integer newDeaths;

    private Integer total;

    public Integer getNumberOfNewDeaths() {
        return newDeaths;
    }

    public void setNumberOfNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Deaths{ " +
                " New: " + newDeaths +
                " Total: " + total +
                '}';
    }
}
