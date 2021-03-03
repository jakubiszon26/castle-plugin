package com.multiportal.castle.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class playerDeathEvent implements Listener {
    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        assert player != null;
        //output: marianek został zabity przez pilocik76
        Bukkit.broadcastMessage(ChatColor.RED + player.getDisplayName() + " został zabity przez " + Objects.requireNonNull(event.getEntity().getKiller()).getDisplayName());
    }
}
