package org.sp.playerviser;

import org.bukkit.event.player.*;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:47
 * at IntelliJ IDEA.
 */
public class GeneralPlayerListener extends PlayerListener {
    private PlayerViser playerViser;
    public GeneralPlayerListener(PlayerViser playerViser){
        this.playerViser = playerViser;
    }
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
        if (playerViser.conf.getPlayers().contains(event.getPlayer().getName().toLowerCase()))
            Viser.onPlayerPickupItem(event.getPlayer(), event.getItem());
    }
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (playerViser.conf.getPlayers().contains(event.getPlayer().getName().toLowerCase()))
            Viser.onPlayerDropItem(event.getPlayer(), event.getItemDrop());
    }
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (playerViser.conf.getPlayers().contains(event.getPlayer().getName().toLowerCase()))
            Viser.onPlayerCommandPreprocess(event.getPlayer(), event.getMessage());
    }
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
        if (playerViser.conf.getPlayers().contains(event.getPlayer().getName().toLowerCase()))
            Viser.onPlayerInteractEntity(event.getPlayer(), event.getRightClicked());
    }

}
