package org.sp.playerviser;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;

/**
 * Author: ShadowPrince
 * Date: 24.02.12
 * Time: 18:47
 * at IntelliJ IDEA.
 */
public class GeneralPlayerListener implements Listener {
    private PlayerViser playerViser;
    public GeneralPlayerListener(PlayerViser playerViser){
        this.playerViser = playerViser;
    }
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event){
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            Viser.onPlayerPickupItem(event.getPlayer(), event.getItem());
    }
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            Viser.onPlayerDropItem(event.getPlayer(), event.getItemDrop());
    }
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            Viser.onPlayerCommandPreprocess(event.getPlayer(), event.getMessage());
    }
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            Viser.onPlayerInteractEntity(event.getPlayer(), event.getRightClicked());
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            if (event.getClickedBlock() != null && event.getAction() == Action.RIGHT_CLICK_BLOCK)
                Viser.onPlayerInteract(event.getPlayer(), event.getClickedBlock().getType());

    }
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event){
        if (Config.isLogged(event.getPlayer()) && Config.isLogged(event.getEventName()))
            Viser.onPlayerTeleport(event.getPlayer(), event.getTo());
    }

}
