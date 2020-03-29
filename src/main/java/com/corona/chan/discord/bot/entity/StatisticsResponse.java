package com.corona.chan.discord.bot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsResponse {
    private Integer results;

    @JsonProperty("response")
    private List<CountryResponse> responseList;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<CountryResponse> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<CountryResponse> responseList) {
        this.responseList = responseList;
    }

    @Override
    public String toString() {
        return "StatisticsResponse{" +
                "results=" + results +
                ", responseList=" + responseList +
                '}';
    }
}
