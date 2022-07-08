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

package de.elia.ghostmain.thisplugin.events.rules;

import de.elia.ghostmain.GhostMain;
import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class RulesEvent implements Listener {

    @EventHandler
    public void onRules(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 1"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 2"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 3"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 4"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 5"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 6"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 7"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 8"));
        player.sendMessage(Prefix.getGhostMainPrefixOld() + GhostMain.getInstance().getMessageConfiguration().getString("Rules 9"));
    }

}
