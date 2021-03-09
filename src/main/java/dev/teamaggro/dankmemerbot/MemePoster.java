package dev.teamaggro.dankmemerbot;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executors;

public class MemePoster implements Runnable {


    @Override
    public void run() {
        final int startDelay = new Random().nextInt(10000);
        DankMemerBot.getInstance().discordApi.addMessageCreateListener(event -> {
            if (event.getMessage().isServerMessage()
                    && event.getChannel().getIdAsString().equalsIgnoreCase(DankMemerBot.getInstance().textChannel.getIdAsString())
                    && event.getMessageAuthor().getIdAsString().equalsIgnoreCase("270904126974590976")) {
                    if (event.getMessageContent().toLowerCase(Locale.ROOT).contains("what type of meme do you want to post?")
                            && event.getMessageContent().toLowerCase(Locale.ROOT).contains(DankMemerBot.getInstance().discordApi.getYourself().getMentionTag())) {
                        final String[] types = new String[] {"f", "r", "i", "c", "k"};
                        new Thread(() -> {
                            try {
                                Thread.sleep(45000 + new Random().nextInt(1500));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            DankMemerBot.getInstance().textChannel.sendMessage("pls postmeme").join();
                            Thread.currentThread().interrupt();
                        }).start();
                        event.getChannel().sendMessage(types[new Random().nextInt(5)]).join();

                    }
            }
        });
        try {
            Thread.sleep(startDelay);
            DankMemerBot.getInstance().textChannel.sendMessage("pls postmeme").join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
