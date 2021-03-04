package com.multiportal.castle.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

import static com.multiportal.castle.players.playersManager.players;

public class playerQuitGame implements Listener {
    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(player.getWorld().getName().contains("cstl")){
            var world = player.getWorld();
            //send message on world
            world.getPlayers().forEach(p -> p.sendMessage(ChatColor.DARK_BLUE + player.getDisplayName() + " porzucił swoją drużynę"));
            //delete player from hashmap
            players.remove(player.getDisplayName());
        }




    }
}
