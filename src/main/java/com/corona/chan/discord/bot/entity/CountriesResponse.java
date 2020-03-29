package com.corona.chan.discord.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesResponse {

    Integer results;
    List<String> response;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CountriesResponse{" +
                "results=" + results +
                ", response=" + response +
                '}';
    }
}
