package com.multiportal.castle;

import com.multiportal.castle.events.playerJoinGame;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class castle extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new playerJoinGame(), this);
        //WARING!!!
        //If you won't credit us, you might get CONFLICT WITH LAW!!!
        //For more info view GPL 3.0 license
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
