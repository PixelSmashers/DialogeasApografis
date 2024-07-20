package com.github.pixelsmashers.dialogeasApografis.sort;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Simple {
    public static void sort(Player player) {
        // we need a way to get the inventory sans armor
        ItemStack[] storageContents = player.getInventory().getStorageContents();

        // temporary unsorted Array
        ItemStack[] unsortedStorageContents = new ItemStack[storageContents.length - 9];
        ItemStack[] sortedStorageContents = new ItemStack[unsortedStorageContents.length];
        Arrays.fill(sortedStorageContents, null);

        TreeMap<String, ArrayList<ItemStack>> itemStacksMap = new TreeMap<>();

        // TODO: understand the following meaning and syntax
        // IntStream.range(9, 35).boxed().map(inventory::getItem).toArray(ItemStack[]::new);

        // put the args together in a string builder
        StringBuilder contentBuilder = new StringBuilder();

        // i, x := range storageContents

        for(int i = 9; i < storageContents.length; i++) {
            ItemStack item = storageContents[i];

            unsortedStorageContents[i - 9] = item;
//            if(item == null) {
//                contentBuilder.append("null, ");
//                continue;
//            }
//            contentBuilder.append(item.getType()).append(", ");
        }

        for (ItemStack item : unsortedStorageContents) {
            if (item == null || item.getType() == Material.AIR) continue;

            // sort by name of item's type
            if (!itemStacksMap.containsKey(item.getType().toString())) {
                ArrayList<ItemStack> itemStacks = new ArrayList<>();
                itemStacks.add(item);
                itemStacksMap.put(item.getType().toString(), itemStacks);
            } else {
                // add the item to the map
                ArrayList<ItemStack> itemStacks = itemStacksMap.get(item.getType().toString());
                itemStacks.add(item);
                itemStacksMap.put(item.getType().toString(), itemStacks);
            }
        }

        // TODO: think through the logic here
        // go over every entrySet in the map
        // go over every item in the array list
        // figure out how to put into the array
        for (var entry : itemStacksMap.entrySet()) {
            for (var itemStack : entry.getValue()) {
                for (int i = 0; i < sortedStorageContents.length; i++) {
                    // here
                    if (sortedStorageContents[i] != null) {
                        continue;
                    }
                    if (sortedStorageContents[i] == null) {
                        sortedStorageContents[i] = itemStack;
                        break;
                    }
                }
            }
        }

        // take the sorted array and put it into the player inventory
        for (int i = 9; i < storageContents.length; i++) {
            storageContents[i] = sortedStorageContents[i - 9];
        }

        player.getInventory().setStorageContents(storageContents);

        contentBuilder.append(itemStacksMap.keySet());

//        contentBuilder
//                .deleteCharAt(contentBuilder.length() - 1)
//                .deleteCharAt(contentBuilder.length() - 1);

        // emit a server message back to the player
        player.sendMessage(ChatColor.GREEN + "Inventory Contents: " + contentBuilder);
    }
}