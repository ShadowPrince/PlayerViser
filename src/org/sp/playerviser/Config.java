package org.sp.playerviser;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:30
 * at IntelliJ IDEA.
 */
public class Config {
    static FileConfiguration config;
    List loggers = new Vector(1);
    public Config(FileConfiguration _config) {
        config = _config;
    }

    public void setDefaults(){
        config.getStringList("log");
        config.getStringList("players");

    }
    public static boolean isLogged(String eventtype){
        return config.getList("log").contains(eventtype.toLowerCase());
    }
    public static boolean isLogged(Player player) {
        if (!player.hasPermission("playerviser.log"))
            return Config.getPlayers().contains(player.getName().toLowerCase());
        else return config.getBoolean("permission-log");
    }
    public static List getPlayers() {
        return config.getList("players");
    }

}
