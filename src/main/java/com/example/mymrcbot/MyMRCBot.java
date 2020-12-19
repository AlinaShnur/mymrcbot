package com.example.mymrcbot;

import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

public class MyMRCBot extends TelegramWebhookBot {
    private String webHook;
    private String botName;
    private String botToken;

    public void setWebHook(String webHook) {
        this.webHook = webHook;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        long chat_id = update.getMessage().getChatId();
        String msg = update.getMessage().getText();
        if(update.getMessage() != null && update.getMessage().hasText()) {
            try {
                response(chat_id, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotPath() {
        return webHook;
    }

    public void response(long chat_id, String msg) throws Exception {
        switch (msg) {
            case"/file": {
                String filePath = "src/main/resources/static/subbota_znamenatel_21.11.2020_2 (11).pdf";
                File file = new File(filePath);
                SendDocument document = new SendDocument();
                document.setDocument(file);
                document.setChatId(chat_id);
                execute(document);
            }
            default: {
                execute(new SendMessage(chat_id, "Хочешь узнать расписание? /file"));
            }
        }
    }
}
