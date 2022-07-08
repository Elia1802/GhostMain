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

package de.elia.ghostmain.all.plugins.prefix;

import de.elia.ghostmain.GhostMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.String;

public class Prefix {

    private static final MiniMessage mm = GhostMain.getMm();

    //Console prefix
    @Contract(pure = true)
    public static @NotNull String getGhostLogger(){
        return "[" + "Ghost Logger" + "] ";
    }

    //GhostMain prefix
    @Contract(pure = true)
    public static @NotNull String getGhostMainPrefixOld(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Main" + ChatColor.DARK_GRAY + "] ";
    }

    @Contract(pure = true)
    public static @NotNull Component getGhostMainPrefix(){
        return mm.deserialize("<dark_gray>[</dark_gray> <aqua>Ghost Main</aqua> <dark_gray>]</dark_gray> ");
    }

    //GhostWarp prefix
    @Contract(pure = true)
    public static @NotNull String getGhostWarpPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Warpsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostInventory prefix
    @Contract(pure = true)
    public static @NotNull String getGhostInventory(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Inventorysystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostCommand prefix
    @Contract(pure = true)
    public static @NotNull String getGhostCommandSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Commandsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostPermission prefix
    @Contract(pure = true)
    public static @NotNull String getGhostPermissionSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Permissionsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostChat prefix
    @Contract(pure = true)
    public static @NotNull String getGhostChatSystem(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Chatsystem" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostTablist prefix
    @Contract(pure = true)
    public static @NotNull String getGhostTablist(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Tablist" + ChatColor.DARK_GRAY + "] ";
    }

    //GhostScoreboard prefix
    @Contract(pure = true)
    public static @NotNull String getGhostScoreboard(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost Scoreboard" + ChatColor.DARK_GRAY + "] ";
    }

    @Contract(pure = true)
    public static @NotNull String getServerFunctions(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Ghost ServerFunctions" + ChatColor.DARK_GRAY + "] ";
    }
}
