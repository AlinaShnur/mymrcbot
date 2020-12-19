package com.example.mymrcbot.appconfig;

import com.example.mymrcbot.MyMRCBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHook;
    private String botName;
    private String botToken;

    @Bean
    public MyMRCBot myMRCBot() {
        MyMRCBot bot = new MyMRCBot();
        bot.setBotName(botName);
        bot.setWebHook(webHook);
        bot.setBotToken(botToken);
        return bot;
    }

}
