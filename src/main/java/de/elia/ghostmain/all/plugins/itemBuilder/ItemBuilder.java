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

package de.elia.ghostmain.all.plugins.itemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.lang.String;
import java.util.Arrays;

public class ItemBuilder {

    private final ItemMeta itemMeta;

    private final ItemStack itemStack;

    //Build the Item
    public ItemBuilder(Material material){
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
    }

    //Give the Item a Name
    public @Nullable ItemBuilder setItemName(String name){
        itemMeta.setDisplayName(name);
        return this;
    }

    //Give the Item a CommandID
    public @Nullable ItemBuilder setCommandID(String id){
        itemMeta.setLocalizedName(id);
        return this;
    }

    //Give the Command a subtitle
    public @Nullable ItemBuilder setSubTitle(String... subTitles){
        itemMeta.setLore(Arrays.asList(subTitles));
        return this;
    }

    //Give the Item an Enchant(Enchantment enchantment , int level , ignore Level Restriction)
    public @Nullable ItemBuilder setEnchant(Enchantment enchantment , int level , boolean ignore){
        itemMeta.addEnchant(enchantment , level , ignore);
        return this;
    }

    //Remove the Item an Enchant
    public @Nullable ItemBuilder delEnchant(Enchantment enchantment){
        itemMeta.removeEnchant(enchantment);
        return this;
    }

    //Give the Item Unbreakable when boolean true is!
    public @Nullable ItemBuilder setUnbreakable(boolean b){
        itemMeta.setUnbreakable(b);
        return this;
    }

    //Set the ItemFlag
    public @Nullable ItemBuilder addItemFlags(ItemFlag... itemFlags){
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    @Override
    public String toString(){
        return "ItemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }

    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
