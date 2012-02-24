package org.sp.playerviser;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 22:50
 * at IntelliJ IDEA.
 */
public class GeneralEntityListener extends EntityListener {
    PlayerViser playerViser;
    public GeneralEntityListener(PlayerViser playerViser){
        this.playerViser = playerViser;
    }
    public void onEntityDeath(EntityDeathEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (playerViser.conf.getPlayers().contains(player.getName().toLowerCase()))
                Viser.onPlayerDeath(player);
        }
    }
}
