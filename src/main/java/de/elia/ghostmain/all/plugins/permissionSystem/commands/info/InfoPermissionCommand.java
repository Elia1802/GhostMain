/**
 * @author Elia
 * @plugin GhostMain
 * @Class GhostMain.java
 *
 * @license
 * Copyright (c) 2022 Elia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.elia.ghostmain.all.plugins.permissionSystem.commands.info;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import de.elia.ghostmain.GhostMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class InfoPermissionCommand implements CommandExecutor , TabCompleter {

    private final GhostMain plugin;

    private List<String> list;

    private final String ownerPermissionID = "ghostowner";

    private final String adminPermissionID = "ghostadmin";

    private final String developerPermissionID = "ghostdeveloper";

    private final String moderatorPermissionID = "ghostmoderator";

    public InfoPermissionCommand(GhostMain plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().warning(Prefix.getGhostLogger() + "You have to be a Player!");
            return false;
        }

        Player player = (Player) sender;
        MiniMessage mm = GhostMain.getMm();

        if (args.length == 2) {
            if (!args[0].equalsIgnoreCase(player.getName())) {
                @NotNull Component playerName = mm.deserialize("<red>Please enter a Player name!</red>");
                player.sendMessage(Prefix.getGhostMainPrefix().append(playerName));
            }

            if (args[1].equalsIgnoreCase("permissions")) {
                if (GhostMain.getInstance().getPermissionOwnerConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , true)) {
                    @NotNull Component ownerText1 = mm.deserialize("<aqua>The player has the permission </aqua>");
                    @NotNull Component ownerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostowner</dark_gray>'><green>owner</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(ownerText1).append(ownerText2));
                }else if (GhostMain.getInstance().getPermissionAdminConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID ,true)) {
                    @NotNull Component adminText1 = mm.deserialize("<aqua>The player has the permission </aqua>");
                    @NotNull Component adminText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostadmin</dark_gray>'><green>admin</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(adminText1).append(adminText2));
                }else if (GhostMain.getInstance().getPermissionDeveloperConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID ,true)) {
                    @NotNull Component developerText1 = mm.deserialize("<aqua>The player has the permission </aqua>");
                    @NotNull Component developerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostdeveloper</dark_gray>'><green>developer</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(developerText1).append(developerText2));
                }else if (GhostMain.getInstance().getPermissionModeratorConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID ,true)) {
                    @NotNull Component moderatorText1 = mm.deserialize("<aqua>The player has the permission </aqua>");
                    @NotNull Component moderatorText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostmoderator</dark_gray>'><green>moderator</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(moderatorText1).append(moderatorText2));
                }else {
                    @NotNull Component noPermissions = mm.deserialize("<aqua>This player has no permission!</aqua>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(noPermissions));
                }
            }else if (args[1].equalsIgnoreCase("op")) {
                if (player.isOp()) {
                    @NotNull Component opText1 = mm.deserialize("<aqua>The player has </aqua>");
                    @NotNull Component opText2 = mm.deserialize("<hover:show_text:'<dark_gray>Minecraft/Server: Operator</dark_gray>'><green>operator</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(opText1).append(opText2));
                }else {
                    @NotNull Component noOpText1 = mm.deserialize("<aqua>The player has not </aqua>");
                    @NotNull Component noOpText2 = mm.deserialize("<hover:show_text:'<dark_gray>Minecraft/Server: Operator</dark_gray>'><green>operator</green>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(noOpText1).append(noOpText2));
                }
            }else {
                player.sendMessage(mm.deserialize(Prefix.getGhostMainPrefix() + "<red>This Command not exist!</red>"));
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 2) {
            list = Arrays.asList("permissions" , "op");
        }
        return list;
    }
}
