package com.corona.chan.discord.bot.listener;

import com.corona.chan.discord.bot.entity.CountryResponse;
import com.corona.chan.discord.bot.entity.StatisticsResponse;
import com.corona.chan.discord.bot.service.CoronaService;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CoronaListener extends ListenerAdapter {

    private final CoronaService coronaService;

    public CoronaListener(CoronaService coronaService) {
        this.coronaService = coronaService;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }

        if(event.getMessage().getAuthor().isBot())
            return;

        String content = event.getMessage().getContentDisplay();

        if (content.contains("!help")) {
            help(event);
        } else if (content.contains("!statistics")) {
            fetchStatistics(event);
        }

    }

    private void help(MessageReceivedEvent event){
        event.getChannel().sendMessage("Hi! type !statistics CountryName for information by country").queue();
    }

    private void fetchStatistics(MessageReceivedEvent event){
        String message = event.getMessage().getContentDisplay();
        String array[]=message.split("\\s+");
        System.out.println(array[1]);
        String country = array[1];

        Optional<String> validatedCountry = coronaService.getAllCountries()
                .getResponse()
                .stream()
                .filter(matchedCountry -> matchedCountry.equals(country))
                .peek(matchedCountry-> System.out.println(matchedCountry))
                .findFirst();

        if(validatedCountry.isPresent()) {
            StatisticsResponse stats=coronaService.getStatisticsForCountry(validatedCountry.get());
            CountryResponse response = stats.getResponseList().get(0);
            event.getChannel().sendMessageFormat("Country : ["+ response.getCountry() + "] \n" + response.getCases().toString() + " \n" + response.getDeaths().toString()).queue();
        }else{
            event.getChannel().sendMessage("Country did not match avaliable countries").queue();
        }
    }

}
