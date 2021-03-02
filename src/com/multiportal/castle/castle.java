package com.multiportal.castle;

import com.multiportal.castle.events.playerJoinGame;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class castle extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new playerJoinGame(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "castle is enabled");

    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "castle is disabled");
    }
}
