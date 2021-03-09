package dev.teamaggro.dankmemerbot;

import java.util.Random;

public class Begger implements Runnable {

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
            DankMemerBot.getInstance().textChannel.sendMessage("pls beg").join();
            Thread.sleep(50000 + new Random().nextInt(1500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
