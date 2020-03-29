package com.corona.chan.discord.bot.service;

import com.corona.chan.discord.bot.entity.CountriesResponse;
import com.corona.chan.discord.bot.entity.StatisticsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@PropertySource("classpath:APIKeys.properties")
public class CoronaService {

    @Value("${x.rapidapi.key}")
    private String apikey;

    private CountriesResponse avaliableCountries;

    @PostConstruct
    public CountriesResponse getAllCountries() {
        if(avaliableCountries==null) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://covid-193.p.rapidapi.com/countries";
            HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders());
            ResponseEntity<CountriesResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, CountriesResponse.class);
            avaliableCountries=response.getBody();
            System.out.println(avaliableCountries.toString());
            return avaliableCountries;
        }else{
            return avaliableCountries;
        }
    }

    public StatisticsResponse getStatisticsForCountry(String countryName){
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://covid-193.p.rapidapi.com/statistics?country={country}";
            HttpEntity<String> entity = new HttpEntity<String>("parameters", getHeaders());
            ResponseEntity<StatisticsResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, StatisticsResponse.class,countryName);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody().toString());
            return response.getBody();

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.add("x-rapidapi-key",apikey);
        return headers;
    }

}
