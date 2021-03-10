package dev.teamaggro.dankmemerbot.commands;

import dev.teamaggro.dankmemerbot.DankMemerBot;

public class TypeListener implements Runnable {


    @Override
    public void run() {
        DankMemerBot.getInstance().discordApi.addMessageCreateListener(event -> {
            if (event.getMessage().isServerMessage()
                    && event.getChannel().getIdAsString().equalsIgnoreCase(DankMemerBot.getInstance().textChannel.getIdAsString())
                    && event.getMessageAuthor().getIdAsString().equalsIgnoreCase("270904126974590976")) {
                if (event.getMessageContent().contains(DankMemerBot.getInstance().discordApi.getYourself().getMentionTag())
                        && event.getMessageContent().contains("Type `")) {
                    String typecontent = event.getMessageContent().split("Type `")[1].replace("`", "");
                    event.getChannel().sendMessage(typecontent).join();
                }
            }
        });
    }
}
