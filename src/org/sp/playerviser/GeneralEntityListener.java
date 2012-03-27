package org.sp.playerviser;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 22:50
 * at IntelliJ IDEA.
 */
public class GeneralEntityListener implements Listener {
    PlayerViser playerViser;
    public GeneralEntityListener(PlayerViser playerViser){
        this.playerViser = playerViser;
    }
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (Config.isLogged(player) && Config.isLogged(event.getEventName()))
                Viser.onPlayerDeath(player);
        }
    }
}
