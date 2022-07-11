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

package de.elia.ghostmain;

import de.elia.ghostmain.all.plugins.permissionSystem.commands.del.DelPermissionCommand;
import de.elia.ghostmain.all.plugins.permissionSystem.commands.info.InfoPermissionCommand;
import de.elia.ghostmain.all.plugins.permissionSystem.commands.set.SetPermissionCommand;
import de.elia.ghostmain.all.plugins.permissionSystem.listener.OperatorListener;
import de.elia.ghostmain.thisplugin.events.connections.join.JoinEvent;
import de.elia.ghostmain.thisplugin.events.connections.quit.QuitEvent;
import de.elia.ghostmain.thisplugin.events.rules.RulesEvent;
import de.elia.ghostmain.thisplugin.events.updater.UpdateEvent;
import de.elia.ghostmain.thisplugin.plugin.config.GhostMainConfig;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import de.elia.ghostmain.all.plugins.updater.Updater;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class GhostMain extends JavaPlugin {

    private static GhostMain instance;

    private static final MiniMessage mm = MiniMessage.miniMessage();

    private static final HashMap<Player , PermissionAttachment> permissionSystem = new HashMap<>();

    private final GhostMainConfig messageConfiguration = new GhostMainConfig(this , "messages/" , "GhostMain.yml");

    private final GhostMainConfig permissionOwnerConfiguration = new GhostMainConfig(this , "permission/owner/" , "GhostOwnerPermission.yml");

    private final GhostMainConfig permissionAdminConfiguration = new GhostMainConfig(this , "permission/admin/" , "GhostAdminPermission.yml");

    private final GhostMainConfig permissionDeveloperConfiguration = new GhostMainConfig(this , "permission/developer/" , "GhostDeveloperPermission.yml");

    private final GhostMainConfig permissionModeratorConfiguration = new GhostMainConfig(this , "permission/moderator/" , "GhostModeratorPermission.yml");

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Start GhostMain");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Commands");
                Bukkit.getPluginCommand("setpermission").setExecutor(new SetPermissionCommand(this));
                Bukkit.getPluginCommand("infopermission").setExecutor(new InfoPermissionCommand(this));
                Bukkit.getPluginCommand("delpermission").setExecutor(new DelPermissionCommand(this));
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Commands loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Listeners");
                Bukkit.getPluginManager().registerEvents(new JoinEvent() , this);
                Bukkit.getPluginManager().registerEvents(new QuitEvent() , this);
                Bukkit.getPluginManager().registerEvents(new RulesEvent() , this);
                Bukkit.getPluginManager().registerEvents(new UpdateEvent() , this);
                Bukkit.getPluginManager().registerEvents(new OperatorListener() , this);
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Listeners loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Config");
                //Message Configuration
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules" , "Here you can Change the Rules");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 1" , "§4No Bug exploiting");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 2" , "§4No sexism");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 3" , "§4No racism");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 4" , "§4No bullying");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 5" , "§4No Insult's");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 6" , "§4No hacking");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 7" , "§4Don't hang or crash the server");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 8" , "§4After death in Ghostworld please use /ghostmode [ghost|hardcore]. If that doesn't happen and he is found out then you can count on a ban");
                GhostMain.getInstance().getMessageConfiguration().addDefault("Rules 9" , "§4If you break the rules, you will be banned");
                GhostMain.getInstance().getMessageConfiguration().options().copyDefaults(true);
                GhostMain.getInstance().getMessageConfiguration().save();
                //Owner Configuration
                GhostMain.getInstance().getPermissionOwnerConfiguration().options().copyDefaults(true);
                GhostMain.getInstance().getPermissionOwnerConfiguration().save();
                //Admin Configuration
                GhostMain.getInstance().getPermissionAdminConfiguration().options().copyDefaults(true);
                GhostMain.getInstance().getPermissionAdminConfiguration().save();
                //Developer Configuration
                GhostMain.getInstance().getPermissionDeveloperConfiguration().options().copyDefaults(true);
                GhostMain.getInstance().getPermissionDeveloperConfiguration().save();
                //Moderator Configuration
                GhostMain.getInstance().getPermissionModeratorConfiguration().options().copyDefaults(true);
                GhostMain.getInstance().getPermissionModeratorConfiguration().save();
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Config loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Checks of Updates");
            new Updater(this , 102115).getVersion(version -> {
                if (!this.getDescription().getVersion().equals(version)) {
                    Bukkit.getLogger().warning(Prefix.getGhostLogger() + "There is a new update for the GhostMain available.");
                }else {
                    Bukkit.getLogger().info(Prefix.getGhostLogger() + "There is not a new Update for the GhostMain available");
                }

            });
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Update Checks");

        Bukkit.getLogger().info(Prefix.getGhostLogger() + "GhostMain started");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning(Prefix.getGhostLogger() + "Stop Ghostmain");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Stop Commands");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Stop Events");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Save Config");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Ghostmain stopped");
    }

    public GhostMainConfig getMessageConfiguration() {
        return messageConfiguration;
    }

    public GhostMainConfig getPermissionOwnerConfiguration() {
        return permissionOwnerConfiguration;
    }

    public GhostMainConfig getPermissionAdminConfiguration() {
        return permissionAdminConfiguration;
    }

    public GhostMainConfig getPermissionDeveloperConfiguration() {
        return permissionDeveloperConfiguration;
    }

    public GhostMainConfig getPermissionModeratorConfiguration() {
        return permissionModeratorConfiguration;
    }

    public static GhostMain getInstance() {
        return instance;
    }

    public static MiniMessage getMm() {
        return mm;
    }

    public static void sendDisplayBroadcast(Component message){
        Bukkit.broadcast(Prefix.getGhostDisplay().append(message));
    }

}
