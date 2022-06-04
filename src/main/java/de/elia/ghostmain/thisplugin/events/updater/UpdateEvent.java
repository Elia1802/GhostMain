package de.elia.ghostmain.thisplugin.events.updater;

import de.elia.ghostmain.thisplugin.GhostMain;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import de.elia.ghostmain.all.plugins.updater.Updater;
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
                if (event.getPlayer().hasPermission("ghost.owner")) {
                    event.getPlayer().sendMessage(Prefix.getGhostMainPrefix() + ChatColor.GOLD + "A new Update is for the GhostMain available!");
                }else if (event.getPlayer().hasPermission("ghost.developer")) {
                    event.getPlayer().sendMessage(Prefix.getGhostMainPrefix() + ChatColor.GOLD + "A new Update is for the GhostMain available!");
                }
            }
        });
    }
}
