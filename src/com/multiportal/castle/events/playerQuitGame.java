package com.multiportal.castle.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static com.multiportal.castle.players.playersManager.players;

public class playerQuitGame implements Listener {
    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        //remove player from game when quits
        players.remove(player.getDisplayName());
        Bukkit.broadcastMessage(ChatColor.AQUA + "Gracz " + player.getDisplayName() + " opuścił swoją drużynę :(");
    }
}
