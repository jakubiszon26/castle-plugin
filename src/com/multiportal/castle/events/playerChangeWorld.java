package com.multiportal.castle.events;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import static com.multiportal.castle.players.playersManager.players;
import static com.multiportal.castle.utils.teamManager.defineTeamAndAddToPlayersManager;
import static com.multiportal.castle.utils.teleports.teleportPlayerToSpawn;

public class playerChangeWorld implements Listener {
    @EventHandler
    public static void onPlayerWorldChange(PlayerChangedWorldEvent joinEvent) {
        //set max number of players in game (in future in config.yaml)
        var maxPlayers = 2;
        Player player = joinEvent.getPlayer();
        if (player.getWorld().getName().contains("cstl")) {
            //give player random team and add him to players hashmap
            player.getInventory().clear();
            defineTeamAndAddToPlayersManager(player.getWorld(), maxPlayers, player);
            PlayerObject playerInfo = players.get(player.getDisplayName());
            player.sendMessage(ChatColor.GREEN + "Jesteś w dróżynie: " + playerInfo.team);
            teleportPlayerToSpawn(player, playerInfo.team);

        }
    }
}
