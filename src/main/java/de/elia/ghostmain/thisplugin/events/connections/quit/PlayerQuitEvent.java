package de.elia.ghostmain.thisplugin.events.connections.quit;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(Prefix.getGhostMainPrefixOld() + ChatColor.AQUA + event.getPlayer().getName() + " " + ChatColor.GRAY + "left the Server");
    }

}
