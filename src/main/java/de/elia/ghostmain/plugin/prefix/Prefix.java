/**
 * @author Elia
 * @plugin GhostMain
 * @Class Prefix.java
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

package de.elia.ghostmain.plugin.prefix;

import org.bukkit.ChatColor;
import java.lang.String;

public class Prefix {

    //Console prefix
    public static String getGhostLogger(){
        return "[" + "Ghost Main" + "] ";
    }

    //GhostMain prefix
    public static String getGhostMainPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Logger" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostWarp prefix
    public static String getGhostWarpPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Warpsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostInventory prefix
    public static String getGhostInventory(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Inventorysystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostCommand prefix
    public static String getGhostCommandSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Commandsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostPermission prefix
    public static String getGhostPermissionSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Permissionsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostChat prefix
    public static String getGhostChatSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Chatsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostTablist prefix
    public static String getGhostTablist(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Tablist" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostScoreboard prefix
    public static String getGhostScoreboard(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Scoreboard" + ChatColor.DARK_GRAY + "] ";
    }

    public static String getServerFunctions(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost ServerFunctions" + ChatColor.DARK_GRAY + "] ";
    }
}
