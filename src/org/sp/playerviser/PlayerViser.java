package org.sp.playerviser;

import org.bukkit.Server;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


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
        getConfig().options().copyDefaults(true);
        saveConfig();
        conf = new Config(getConfig());
        pluginman.registerEvents(new GeneralPlayerListener(this), this);
    }
}
