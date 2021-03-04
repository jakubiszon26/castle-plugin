package com.multiportal.castle;

import com.multiportal.castle.events.playerDeathEvent;
import com.multiportal.castle.events.playerJoinGame;
import com.multiportal.castle.events.playerQuitGame;
import com.multiportal.castle.events.playerRespawn;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
public class castle extends JavaPlugin {
    public static castle plugin; //create the variable

    @Override
    public void onEnable() {
        //events
        plugin = this;
        getServer().getPluginManager().registerEvents(new playerJoinGame(), this);
        getServer().getPluginManager().registerEvents(new playerQuitGame(), this);
        getServer().getPluginManager().registerEvents(new playerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new playerRespawn(), this);


        //commands

        //welcome message in console
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "  __  __       _ _   _ ____            _        _");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + " |  \\/  |_   _| | |_(_)  _ \\ ___  _ __| |_ __ _| |");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + " | |\\/| | | | | | __| | |_) / _ \\| '__| __/ _` | |");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + " | |  | | |_| | | |_| |  __/ (_) | |  | || (_| | |");
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + " |_|  |_|\\__,_|_|\\__|_|_|   \\___/|_|   \\__\\__,_|_|");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Castle Plugin by MultiPortal is enabled");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Castle Plugin by MultiPortal is disabled");
    }
}
