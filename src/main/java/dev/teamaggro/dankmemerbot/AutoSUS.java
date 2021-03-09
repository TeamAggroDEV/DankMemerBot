package dev.teamaggro.dankmemerbot;

import java.util.Random;

public class AutoSUS implements Runnable {

    @Override
    public void run() {
        final int startDelay = new Random().nextInt(10000);
        String userID = "797073397598257162";   // teamaggro now has to replace this with good code
        try {
            Thread.sleep(startDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (DankMemerBot.getInstance().isRunning()) {
            try {
            DankMemerBot.getInstance().textChannel.sendMessage("pls with all").join();
            DankMemerBot.getInstance().textChannel.sendMessage("pls give <@" + userID + "> all");
            Thread.sleep(100000 + new Random().nextInt(1500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
