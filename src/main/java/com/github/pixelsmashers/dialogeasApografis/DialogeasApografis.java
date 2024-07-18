package com.github.pixelsmashers.dialogeasApografis;

import org.bukkit.plugin.java.JavaPlugin;

public final class DialogeasApografis extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("echo").setExecutor(new CommandEchoer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
