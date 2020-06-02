package com.corona.chan.discord.bot.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public void getHealth() {
    }
}