package org.sp.playerviser;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:23
 * at IntelliJ IDEA.
 */
public class PlayerViser extends JavaPlugin{
    public Server server;
    public PluginManager pluginman;

    public GeneralPlayerListener gpl = new GeneralPlayerListener(this);
    public GeneralEntityListener gel = new GeneralEntityListener(this);
    public Config conf;

    public static boolean debug = true;
    public void onDisable(){}
    public void onEnable(){
        server = this.getServer();
        pluginman = server.getPluginManager();
        conf = new Config(new File(this.getDataFolder() + "/config.yml"));
        for (Object logger : conf.loggers) {
            if (logger.toString().startsWith("PLAYER")) {
                Log.debug(String.format("Event %s registered with player listener!", logger.toString()));
                pluginman.registerEvent((Event.Type) logger, gpl, Event.Priority.Lowest, this);
            } else if (logger.toString().startsWith("ENTITY")) {
                Log.debug(String.format("Event %s registered with entity listener!", logger.toString()));
                pluginman.registerEvent((Event.Type) logger, gel, Event.Priority.Lowest, this);
            }
        }
    }
}
