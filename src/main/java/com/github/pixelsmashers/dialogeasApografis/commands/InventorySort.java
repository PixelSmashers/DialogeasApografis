package com.github.pixelsmashers.dialogeasApografis.commands;

import com.github.pixelsmashers.dialogeasApografis.sort.Simple;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.github.pixelsmashers.dialogeasApografis.sort.Simple.sort;

public class InventorySort implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // sender needs to be Player
        if (!(sender instanceof Player player)) {
            return false;
        }

        // then we need to determine which sort to perform: simple (alphabetical) or complex (params provided by user TBD)
        // we can get this from args[0] index
        if (args.length == 0) {
            return false;
        }

        // since we look at player or chest first
        // I think player/chest becomes an object with additional fields needed, but we can start with a string
        if (!args[0].equalsIgnoreCase("player") && !args[0].equalsIgnoreCase("chest")) {
            return false;
        }

        // then we look at if we are simple or complex sort
        if (!args[1].equalsIgnoreCase("simple") && !args[1].equalsIgnoreCase("complex")) {
            return false;
        }

        switch (args[1]) {
            case "simple" -> {
                // T needs to have an inventory available, reference: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/InventoryHolder.html
                // How do we get the chest the player wants to sort? (Click event?, or Raycast Utility?)
                // simpleSort(T selector)
                Simple.sort(player);
                return true;
            }
            case "complex" -> {
                //
                return true;
            }
            default -> {
                // technically we don't need a default here since these cases are covered in full
                return false;
            }
        }
    }
}
