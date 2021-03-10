package dev.teamaggro.dankmemerbot.commands;

import dev.teamaggro.dankmemerbot.DankMemerBot;

import java.util.Random;

public class AutoSUS implements Runnable {

    @Override
    public void run() {
        final int startDelay = new Random().nextInt(10000);
        try {
            Thread.sleep(startDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (DankMemerBot.getInstance().isRunning()) {
            try {
            DankMemerBot.getInstance().textChannel.sendMessage("pls with all").join();
            DankMemerBot.getInstance().textChannel.sendMessage("pls give <@" + DankMemerBot.getInstance().autopayID + "> all");
            Thread.sleep(100000 + new Random().nextInt(1500));
            //DankMemerBot.getInstance().textChannel.sendMessage("pls gift all banknote <@" + DankMemerBot.getInstance().autopayID + ">");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
