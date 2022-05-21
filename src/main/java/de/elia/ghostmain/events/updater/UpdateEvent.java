package de.elia.ghostmain.events.updater;

import de.elia.ghostmain.GhostMain;
import de.elia.ghostmain.plugin.prefix.Prefix;
import de.elia.ghostmain.plugin.updater.Updater;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdateEvent implements Listener {

    private final GhostMain plugin;

    public UpdateEvent(GhostMain plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        new Updater(plugin , 102115).getVersion(version -> {
            if (plugin.getDescription().getVersion().equals(version)) {
                Bukkit.getLogger().info(Prefix.getGhostLogger() + "There is not a new update available.");
            }else {
                Bukkit.getLogger().warning(Prefix.getGhostLogger() + "There is a new Update available!");
            }
            if (event.getPlayer().hasPermission("ghost.developer")) {
                event.getPlayer().sendMessage(Prefix.getGhostMainPrefix() + ChatColor.GOLD + "A new Update is available!");
            }
        });
    }

}
