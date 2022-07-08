/**
 * @author Elia
 * @plugin GhostMain
 * @Class Updater.java
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

package de.elia.ghostmain.all.plugins.updater;

import de.elia.ghostmain.all.plugins.prefix.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Updater {

    private final JavaPlugin plugin;

    private final int ressourceID;

    public Updater(JavaPlugin plugin , int ressourceID){
        this.plugin = plugin;
        this.ressourceID = ressourceID;
    }

    public void getVersion(final Consumer<String> consumer){
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.ressourceID).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()){
                    consumer.accept(scanner.next());
                }
            }catch (IOException exception){
                Bukkit.getLogger().severe(Prefix.getGhostLogger() + "Unable to check for updates: " + exception.getMessage());
                Bukkit.getLogger().severe(Prefix.getGhostLogger() + "An error occurred when resolving the IP to SpigotMC or the resource ID is wrong!");
                exception.printStackTrace();
            }
        });
    }

}
