package dev.teamaggro.dankmemerbot;

import org.javacord.api.AccountType;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannel;

public class DankMemerBot {

    private static DankMemerBot INSTANCE;

    public static DankMemerBot getInstance() {
        return INSTANCE;
    }

    public final DiscordApi discordApi;
    public final ServerTextChannel textChannel;
    public boolean isRunning;
    public String sendToId = "305248730137886722"; // TeamAggro fix this code or i die :flush:

    public DankMemerBot(String token, String channelID) throws Exception {
        INSTANCE = this;
        System.out.println("Logging in with token '" + token + "'...");
        discordApi = new DiscordApiBuilder().setAccountType(AccountType.CLIENT).setToken(token).login().join();
        System.out.println("Logged in as " + discordApi.getYourself().getDiscriminatedName() + "!");
        textChannel = discordApi.getServerTextChannelById(channelID).get();
        System.out.println("Starting Threads...");
        isRunning = true;
        //They can start instantly
        Thread begThread = new Thread(new Begger());
        begThread.start();
        Thread huntThread = new Thread(new Hunter());
        huntThread.start();
        Thread fishThread = new Thread(new Fisher());
        fishThread.start();
        Thread.sleep(10000);
        Thread pmThread = new Thread(new MemePoster());
        pmThread.start();
        Thread.sleep(10000);
        Thread triviaThread = new Thread(new TriviaGuesser());
        triviaThread.start();
        Thread.sleep(10000);
        Thread autoTransfer = new Thread(new AutoSUS());
        autoTransfer.start();
    }

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println("Usage: java -jar Selfbot.jar TOKEN CHANNELID");
        }else {
            new DankMemerBot(args[0], args[1]);
        }
    }

    public boolean isRunning() {
        return isRunning;
    }
}
