package dev.teamaggro.dankmemerbot;

import dev.teamaggro.dankmemerbot.commands.*;
import dev.teamaggro.dankmemerbot.utils.Config;
import org.javacord.api.AccountType;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerTextChannel;

public class DankMemerBot {

    private static DankMemerBot INSTANCE;
    public final DiscordApi discordApi;
    public final ServerTextChannel textChannel;
    public final String channelID;
    public final String autopayID;
    public boolean isRunning;

    public DankMemerBot(Config config) throws Exception {
        INSTANCE = this;
        System.out.println("Logging in with token '" + config.token + "'...");
        discordApi = new DiscordApiBuilder().setAccountType(AccountType.CLIENT).setToken(config.token).login().join();
        System.out.println("Logged in as " + discordApi.getYourself().getDiscriminatedName() + "!");
        textChannel = discordApi.getServerTextChannelById(config.channelid).get();
        System.out.println("Starting Threads...");
        isRunning = true;
        channelID = config.channelid;
        autopayID = config.autopayid;
        //They can start instantly
        if (config.type_check_enabled) {
            Thread typeThread = new Thread(new TypeListener());
            typeThread.start();
        }
        if (config.beg_enabled) {
            Thread begThread = new Thread(new Begger());
            begThread.start();
        }
        if (config.hunt_enabled) {
            Thread huntThread = new Thread(new Hunter());
            huntThread.start();
        }
        if (config.fish_enabled) {
            Thread fishThread = new Thread(new Fisher());
            fishThread.start();
        }
        if (config.postmeme_enabled) {
            Thread.sleep(10000);
            Thread pmThread = new Thread(new MemePoster());
            pmThread.start();
        }
        if (config.trivia_enabled) {
            Thread.sleep(10000);
            Thread triviaThread = new Thread(new TriviaGuesser());
            triviaThread.start();
        }
        if (config.autopay_enabled) {
            Thread.sleep(10000);
            Thread autoTransfer = new Thread(new AutoSUS());
            autoTransfer.start();
        }
    }

    public static DankMemerBot getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        Config conf = new Config();
        conf.loadProperties();
        new DankMemerBot(conf);
    }

    public boolean isRunning() {
        return isRunning;
    }
}
