package de.elia.ghostmain.thisplugin.command;

import de.elia.ghostmain.thisplugin.GhostMain;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class PluginInformationCommand implements CommandExecutor , TabCompleter {

    private final GhostMain plugin;

    public PluginInformationCommand(GhostMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().warning(Prefix.getGhostLogger() + "You have to be a Player");
            return false;
        }

        Player player = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("important")) {
                player.sendMessage(Prefix.getGhostMainPrefix() + "I decided to split Ghost into several plugins.");
                player.sendMessage(Prefix.getGhostMainPrefix() + "Therefore you will slowly but surely use more and more functions.");
                player.sendMessage(Prefix.getGhostMainPrefix() + "And if a plugin has an error, you can notify me.");
                player.sendMessage(Prefix.getGhostMainPrefix() + "Because then I can fix the bug.");
                player.sendMessage(Prefix.getGhostMainPrefix() + "You can even delete the plugin very easily and all others will work.");
                player.sendMessage(Prefix.getGhostMainPrefix() + "(It is important that the GhostMain plugin is active on the server. Nothing will work without it!)");
            }else if (args[0].equalsIgnoreCase("unimportant")) {
                player.sendMessage(Prefix.getGhostMainPrefix() + ChatColor.GOLD + "This release took a little longer than usual, but you can expect a completely new plugin design and at the moment only the owner function works");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return Arrays.asList("important" , "unimportant");
    }
}
