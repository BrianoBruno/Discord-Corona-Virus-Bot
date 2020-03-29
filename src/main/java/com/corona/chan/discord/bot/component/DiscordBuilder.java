package com.corona.chan.discord.bot.component;

import com.corona.chan.discord.bot.listener.CoronaListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Component
public class DiscordBuilder {

    @Value("${discord.bot.token}")
    private String botToken;

    @Autowired
    private CoronaListener coronaListener;

    @PostConstruct
    public void buildDiscordBot() throws LoginException {
        JDA jda= JDABuilder.createDefault(botToken).build();
        jda.addEventListener(coronaListener);

    }
}
