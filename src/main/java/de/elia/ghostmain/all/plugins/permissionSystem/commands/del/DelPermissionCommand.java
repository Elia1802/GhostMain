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

package de.elia.ghostmain.all.plugins.permissionSystem.commands.del;

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
import org.bukkit.permissions.PermissionAttachment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class DelPermissionCommand implements CommandExecutor , TabCompleter {

    private final GhostMain plugin;

    public DelPermissionCommand(GhostMain plugin){
        this.plugin = plugin;
    }

    private List<String> list;

    private final String ownerPermissionID = "ghostowner";

    private final String adminPermissionID = "ghostadmin";

    private final String developerPermissionID = "ghostdeveloper";

    private final String moderatorPermissionID = "ghostmoderator";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().warning(Prefix.getGhostLogger() + "You have to be a Player!");
            return false;
        }

        Player player = (Player) sender;
        MiniMessage mm = GhostMain.getMm();

        if (player.isOp()) {
            if (args.length == 2) {
                if (!args[0].equalsIgnoreCase(player.getName())) {
                    player.sendMessage(mm.deserialize(Prefix.getGhostMainPrefix() + "<red>Please enter a Player name!</red>"));
                }

                if (args[1].equalsIgnoreCase("owner")) {
                    if (!GhostMain.getInstance().getPermissionOwnerConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , true)) {
                        player.sendMessage(mm.deserialize("<>This player does not have the permission!</>"));
                    }
                    PermissionAttachment owner = player.addAttachment(GhostMain.getInstance());
                    owner.setPermission(ownerPermissionID , false);
                    GhostMain.getInstance().getPermissionOwnerConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , null);
                    @NotNull Component ownerText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                    @NotNull Component ownerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostowner</dark_gray>'><green>owner</green>");
                    @NotNull Component ownerText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(ownerText1).append(ownerText2).append(ownerText3));
                }else if (args[1].equalsIgnoreCase("admin")) {
                    PermissionAttachment admin = player.addAttachment(GhostMain.getInstance());
                    admin.setPermission(adminPermissionID , false);
                    GhostMain.getInstance().getPermissionAdminConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID , null);
                    @NotNull Component adminText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                    @NotNull Component adminText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostadmin</dark_gray>'><green>admin</green>");
                    @NotNull Component adminText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(adminText1).append(adminText2).append(adminText3));
                }else if (args[1].equalsIgnoreCase("developer")) {
                    PermissionAttachment developer = player.addAttachment(GhostMain.getInstance());
                    developer.setPermission(developerPermissionID , false);
                    GhostMain.getInstance().getPermissionDeveloperConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID , null);
                    @NotNull Component developerText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                    @NotNull Component developerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostdeveloper</dark_gray>'><green>developer</green>");
                    @NotNull Component developerText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(developerText1).append(developerText2).append(developerText3));
                }else if (args[1].equalsIgnoreCase("moderator")) {
                    PermissionAttachment moderator = player.addAttachment(GhostMain.getInstance());
                    moderator.setPermission(moderatorPermissionID , false);
                    GhostMain.getInstance().getPermissionModeratorConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID , null);
                    @NotNull Component moderatorText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                    @NotNull Component moderatorText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostmoderator</dark_gray>'><green>moderator</green>");
                    @NotNull Component moderatorText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                    player.sendMessage(Prefix.getGhostMainPrefix().append(moderatorText1).append(moderatorText2).append(moderatorText3));
                }else if (args[1].equalsIgnoreCase("op")) {
                    player.setOp(false);
                    player.sendMessage(mm.deserialize(Prefix.getGhostMainPrefix() + "<aqua>Your operator has been removed!</aqua>"));
                }else if (args[1].equalsIgnoreCase("allperms")) {
                    if (GhostMain.getInstance().getPermissionOwnerConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , true)) {
                        PermissionAttachment owner = player.addAttachment(GhostMain.getInstance());
                        owner.setPermission(ownerPermissionID , false);
                        GhostMain.getInstance().getPermissionOwnerConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + ownerPermissionID , null);
                        @NotNull Component ownerText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                        @NotNull Component ownerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostowner</dark_gray>'><green>owner</green>");
                        @NotNull Component ownerText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                        player.sendMessage(Prefix.getGhostMainPrefix().append(ownerText1).append(ownerText2).append(ownerText3));
                    }else if (GhostMain.getInstance().getPermissionAdminConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID , true)) {
                        PermissionAttachment admin = player.addAttachment(GhostMain.getInstance());
                        admin.setPermission(adminPermissionID , false);
                        GhostMain.getInstance().getPermissionAdminConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + adminPermissionID , null);
                        @NotNull Component adminText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                        @NotNull Component adminText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostadmin</dark_gray>'><green>admin</green>");
                        @NotNull Component adminText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                        player.sendMessage(Prefix.getGhostMainPrefix().append(adminText1).append(adminText2).append(adminText3));
                    }else if (GhostMain.getInstance().getPermissionDeveloperConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID , true)) {
                        PermissionAttachment developer = player.addAttachment(GhostMain.getInstance());
                        developer.setPermission(developerPermissionID , false);
                        GhostMain.getInstance().getPermissionDeveloperConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + developerPermissionID , null);
                        @NotNull Component developerText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                        @NotNull Component developerText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostdeveloper</dark_gray>'><green>developer</green>");
                        @NotNull Component developerText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                        player.sendMessage(Prefix.getGhostMainPrefix().append(developerText1).append(developerText2).append(developerText3));
                    }else if (GhostMain.getInstance().getPermissionModeratorConfiguration().get(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID , true)) {
                        PermissionAttachment moderator = player.addAttachment(GhostMain.getInstance());
                        moderator.setPermission(moderatorPermissionID , false);
                        GhostMain.getInstance().getPermissionModeratorConfiguration().set(".Name " + player.getName() + " " + ".UniqueID " + player.getUniqueId() + " " + ".Permission " + moderatorPermissionID , null);
                        @NotNull Component moderatorText1 = mm.deserialize("<aqua>Your Permission </aqua>");
                        @NotNull Component moderatorText2 = mm.deserialize("<hover:show_text:'<dark_gray>PermissionID: ghostmoderator</dark_gray>'><green>moderator</green>");
                        @NotNull Component moderatorText3 = mm.deserialize("<aqua> has been successfully removed!</aqua>");
                        player.sendMessage(Prefix.getGhostMainPrefix().append(moderatorText1).append(moderatorText2).append(moderatorText3));
                    }else if (args[1].equalsIgnoreCase("op")) {
                        if (player.isOp()) {
                            player.setOp(false);
                            @NotNull Component operator = mm.deserialize("<aqua>Your operator has been removed!</aqua>");
                            player.sendMessage(Prefix.getGhostMainPrefix().append(operator));
                        }else {
                            player.sendMessage(mm.deserialize(Prefix.getGhostMainPrefix() + "<red>This player has no operator!</red>"));
                        }
                    }
                }else {
                    player.sendMessage(mm.deserialize(Prefix.getGhostMainPrefix() + "<red>This Command not exist!</red>"));
                }
            }
        }else {
            player.sendMessage(mm.deserialize("You don't have the Permission for this Command"));
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 2) {
            list = Arrays.asList("owner" , "admin" , "developer" , "moderator" , "op" , "allperms");
        }
        return list;
    }
}
