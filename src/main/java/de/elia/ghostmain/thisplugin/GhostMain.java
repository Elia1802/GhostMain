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

package de.elia.ghostmain.thisplugin;

import de.elia.ghostmain.thisplugin.command.PluginInformationCommand;
import de.elia.ghostmain.thisplugin.events.connections.join.PlayerJoinEvent;
import de.elia.ghostmain.thisplugin.events.connections.quit.PlayerQuitEvent;
import de.elia.ghostmain.thisplugin.events.information.InformationEvent;
import de.elia.ghostmain.thisplugin.events.rules.RulesEvent;
import de.elia.ghostmain.thisplugin.events.updater.UpdateEvent;
import de.elia.ghostmain.thisplugin.plugin.config.GhostMainConfig;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import de.elia.ghostmain.all.plugins.updater.Updater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GhostMain extends JavaPlugin {

    private static GhostMain instance;

    private final GhostMainConfig config = new GhostMainConfig(this , "GhostMain.yml");

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Start GhostMain");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Commands");
                Bukkit.getPluginCommand("information").setExecutor(new PluginInformationCommand(this));
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Commands loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Listeners");
                Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent() , this);
                Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent() , this);
                Bukkit.getPluginManager().registerEvents(new InformationEvent() , this);
                Bukkit.getPluginManager().registerEvents(new RulesEvent() , this);
                Bukkit.getPluginManager().registerEvents(new UpdateEvent(this) , this);
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Listeners loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "load Config");
                GhostMain.getInstance().getConfiguration().addDefault("Rules" , "Here you can Change the Rules");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 1" , "§4No Bug exploiting");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 2" , "§4No sexism");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 3" , "§4No racism");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 4" , "§4No bullying");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 5" , "§4No Insult's");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 6" , "§4No hacking");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 7" , "§4Don't hang or crash the server");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 8" , "§4After death in Ghostworld please use /ghostmode [ghost|hardcore]. If that doesn't happen and he is found out then you can count on a ban");
                GhostMain.getInstance().getConfiguration().addDefault("Rules 9" , "§4If you break the rules, you will be banned");
                GhostMain.getInstance().getConfiguration().copyDefaults(true);
                GhostMain.getInstance().getConfiguration().save();
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Config loaded");

            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Checks of Updates");
            new Updater(this , 102115).getVersion(version -> {
                if (this.getDescription().getVersion().equals(version)) {
                    Bukkit.getLogger().info(Prefix.getGhostLogger() + "There is not a new update for the GhostMain available.");
                }else {
                    Bukkit.getLogger().warning(Prefix.getGhostLogger() + "There is a new Update for the GhostMain available");
                }

            });
            Bukkit.getLogger().info(Prefix.getGhostLogger() + "Update Checks");

        Bukkit.getLogger().info(Prefix.getGhostLogger() + "GhostMain started");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Stop Ghost");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Stop Commands");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Stop Events");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Save Config");
        Bukkit.getLogger().info(Prefix.getGhostLogger() + "Ghost stopped");
    }

    public GhostMainConfig getConfiguration() {
        return config;
    }

    public static GhostMain getInstance() {
        return instance;
    }
}
