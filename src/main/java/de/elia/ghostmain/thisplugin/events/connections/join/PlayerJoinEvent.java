package de.elia.ghostmain.thisplugin.events.connections.join;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage(Prefix.getGhostMainPrefixOld() + ChatColor.AQUA + event.getPlayer().getName() + " " + ChatColor.GRAY + "joint the Server");
    }

}
