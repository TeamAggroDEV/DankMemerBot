package dev.teamaggro.dankmemerbot.commands;

import dev.teamaggro.dankmemerbot.DankMemerBot;

import java.util.Random;

public class Fisher implements Runnable {


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
                DankMemerBot.getInstance().textChannel.sendMessage("pls fish").join();
                Thread.sleep(45000 + new Random().nextInt(1500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
