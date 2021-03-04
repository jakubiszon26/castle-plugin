package com.multiportal.castle.events;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import static com.multiportal.castle.players.playersManager.players;
import static com.multiportal.castle.utils.teleports.teleportPlayerToSpawn;

public class playerRespawn implements Listener {
    @EventHandler
    public static void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().contains("cstl")) {
            PlayerObject playerInfo = players.get(player.getDisplayName());
            teleportPlayerToSpawn(player, playerInfo.team);

        }

    }
}
