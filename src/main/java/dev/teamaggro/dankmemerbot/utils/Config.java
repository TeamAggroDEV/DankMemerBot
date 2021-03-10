package dev.teamaggro.dankmemerbot.utils;

import java.io.*;
import java.util.Properties;

public class Config {

    public String token, channelid, autopayid;
    public boolean beg_enabled, autopay_enabled, fish_enabled, postmeme_enabled, hunt_enabled, trivia_enabled, type_check_enabled;

    public void loadProperties() throws Exception {
        File configFile = new File("config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            token = props.getProperty("token");
            channelid = props.getProperty("channelid");
            autopayid = props.getProperty("autopay_userid");
            beg_enabled = Boolean.parseBoolean(props.getProperty("beg_enabled"));
            fish_enabled = Boolean.parseBoolean(props.getProperty("fish_enabled"));
            hunt_enabled = Boolean.parseBoolean(props.getProperty("hunt_enabled"));
            postmeme_enabled = Boolean.parseBoolean(props.getProperty("postmeme_enabled"));
            trivia_enabled = Boolean.parseBoolean(props.getProperty("trivia_enabled"));
            autopay_enabled = Boolean.parseBoolean(props.getProperty("autopay_enabled"));
            type_check_enabled = Boolean.parseBoolean(props.getProperty("type_check_enabled"));
            reader.close();
        } catch (FileNotFoundException ex) {
            createConfig();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void createConfig() throws IOException {
        File configFile = new File("config.properties");
        if (!configFile.exists()) {
            configFile.createNewFile();
        }
        try {
            Properties props = new Properties();
            props.setProperty("token", "INSERT_CLIENT_TOKEN");
            props.setProperty("channelid", "818848381798449173");
            props.setProperty("autopay_userid", "765944420674568224");
            props.setProperty("autopay_enabled", "true");
            props.setProperty("fish_enabled", "true");
            props.setProperty("postmeme_enabled", "true");
            props.setProperty("trivia_enabled", "true");
            props.setProperty("hunt_enabled", "true");
            props.setProperty("beg_enabled", "true");
            props.setProperty("type_check_enabled", "true");
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "DankMemer Selfbot Settings");
            writer.close();
            loadProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
