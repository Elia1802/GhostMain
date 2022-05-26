package de.elia.ghostmain.thisplugin.events.information;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class InformationEvent implements Listener {

    @EventHandler
    public void onInformation(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("ghost.owner")) {
            player.sendMessage(Prefix.getGhostMainPrefix() + "I decided to split Ghost into several plugins.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "Therefore you will slowly but surely use more and more functions.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "And if a plugin has an error, you can notify me.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "Because then I can fix the bug.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "You can even delete the plugin very easily and all others will work.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "(It is important that the GhostMain plugin is active on the server. Nothing will work without it!)");
        }
        if (player.hasPermission("ghost.developer")) {
            player.sendMessage(Prefix.getGhostMainPrefix() + "I decided to split Ghost into several plugins.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "Therefore you will slowly but surely use more and more functions.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "And if a plugin has an error, you can notify me.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "Because then I can fix the bug.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "You can even delete the plugin very easily and all others will work.");
            player.sendMessage(Prefix.getGhostMainPrefix() + "(It is important that the GhostMain plugin is active on the server. Nothing will work without it!)");
        }
    }

}
