package dev.teamaggro.dankmemerbot;

import org.javacord.api.DiscordApi;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executors;

public class TriviaGuesser implements Runnable {


    @Override
    public void run() {
        final int startDelay = new Random().nextInt(10000);
        DankMemerBot.getInstance().discordApi.addMessageCreateListener(event -> {
            if (event.getMessage().isServerMessage()
                    && event.getChannel().getIdAsString().equalsIgnoreCase(DankMemerBot.getInstance().textChannel.getIdAsString())
                    && event.getMessageAuthor().getIdAsString().equalsIgnoreCase("270904126974590976") && !event.getMessage().getEmbeds().isEmpty()) {
                if (event.getMessage().getEmbeds().get(0).getTitle().orElse("a").contains("trivia")
                        && event.getMessage().getEmbeds().get(0).getTitle().orElse("a").contains(DankMemerBot.getInstance().discordApi.getYourself().getName())) {
                    final String[] types = new String[] {"A", "B", "C", "D"};
                    new Thread(() -> {
                        try {
                            Thread.sleep(45000 + new Random().nextInt(1500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DankMemerBot.getInstance().textChannel.sendMessage("pls trivia").join();
                        Thread.currentThread().interrupt();
                    }).start();
                    event.getChannel().sendMessage(types[new Random().nextInt(5)]).join();

                }
            }
        });
        try {
            Thread.sleep(startDelay);
            DankMemerBot.getInstance().textChannel.sendMessage("pls trivia").join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
