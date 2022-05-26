package de.elia.ghostmain.thisplugin.events.connections.join;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event){
        event.setJoinMessage(Prefix.getGhostMainPrefix() + ChatColor.AQUA + event.getPlayer().getName() + " " + ChatColor.GRAY + "joint the Server");
    }

}
