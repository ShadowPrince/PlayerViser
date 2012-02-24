package org.sp.playerviser;


import org.bukkit.event.Event;
import org.bukkit.util.config.Configuration;

import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:30
 * at IntelliJ IDEA.
 */
public class Config {
    Configuration config;
    List loggers = new Vector(1);
    public Config(File path){
        config = new Configuration(path);
        config.load();
        setDefaults();
        config.save();
        prepareLoggers();
        preparePlayers();
    }

    public void setDefaults(){
        List defined = new Vector(1);
        defined.add("player_command_preprocess");
        defined.add("player_chat");
        defined.add("player_pickup_item");
        defined.add("player_drop_item");
        config.getStringList("log", defined);
        
        defined = new Vector(1);
        defined.add("5Shadow7Prince");
        config.getStringList("players", defined);

    }

    public List getPlayers() {
        return config.getList("players");
    }
    public void preparePlayers(){
        List players = new Vector(1);
        for (Object player : config.getList("players")) {
            players.add(player.toString().toLowerCase());            
        }
        config.setProperty("players", players);
    }
    public void prepareLoggers(){
        List defloggers = config.getList("log");
        for (Object logger : defloggers) {
            try {
                loggers.add(Event.Type.valueOf(logger.toString().toUpperCase()));
            } catch (IllegalArgumentException iae){
                Log.warning(String.format("Logger %s not found!", logger.toString()));
            } catch (NullPointerException npe) {
                Log.warning(String.format("Logger %s not found!", logger.toString()));
            }
        }
    }
}
