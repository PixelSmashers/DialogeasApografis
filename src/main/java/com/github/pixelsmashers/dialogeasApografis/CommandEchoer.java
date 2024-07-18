package com.github.pixelsmashers.dialogeasApografis;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEchoer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // sender needs to be Player
        if (!(sender instanceof Player)) {
            return false;
        }

        // I made a typo!
        if (args.length > 0) {
            // put the args together in a string builder
            StringBuilder argsBuilder = new StringBuilder();
            for (String arg : args) {
                argsBuilder.append(arg);
            }

            // emit a server message back to the player
            sender.sendMessage("Echoing " + command.toString() + " with args " + argsBuilder);
        }

        sender.sendMessage("Echoing " + command.toString());

        return true;
    }
}
