package de.elia.ghostmain.thisplugin.events.connections.quit;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {

    @EventHandler
    public void onQuit(org.bukkit.event.player.PlayerQuitEvent event){
        event.setQuitMessage(Prefix.getGhostMainPrefix() + ChatColor.AQUA + event.getPlayer().getName() + " " + ChatColor.GRAY + "left the Server");
    }

}
