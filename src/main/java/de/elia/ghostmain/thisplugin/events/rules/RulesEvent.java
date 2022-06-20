package de.elia.ghostmain.thisplugin.events.rules;

import de.elia.ghostmain.thisplugin.GhostMain;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RulesEvent implements Listener {

    @EventHandler
    public void onRules(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 1"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 2"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 3"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 4"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 5"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 6"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 7"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 8"));
        player.sendMessage(Prefix.getGhostMainPrefix() + GhostMain.getInstance().getConfiguration().getString("Rules 9"));
    }

}
