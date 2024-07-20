package com.github.pixelsmashers.dialogeasApografis;

import com.github.pixelsmashers.dialogeasApografis.commands.InventorySort;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class DialogeasApografis extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("echo").setExecutor(new CommandEchoer());
        this.getCommand("sort").setExecutor(new InventorySort());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
