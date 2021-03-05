package com.multiportal.castle.events;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

import static com.multiportal.castle.players.playersManager.players;
import static com.multiportal.castle.utils.teleports.teleportPlayerToSpawn;

public class playerDeathEvent implements Listener {
    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        //checks is player on game world
        if (Objects.requireNonNull(event.getEntity().getPlayer()).getWorld().getName().contains("cstl")) {
            Player player = event.getEntity().getPlayer();
            var killer = player.getKiller();
            var world = player.getWorld();
            //send message on world
            world.getPlayers().forEach(p -> p.sendMessage(ChatColor.RED + "Gracz " + player.getDisplayName() + " został zabity przez " + player.getKiller()));
            player.spigot().respawn();
            //get player team name from players info hashmap
            PlayerObject playerInfo = players.get(player.getDisplayName());
            //teleport player to his team spawn
            assert killer != null;
            PlayerObject killerInfo = players.get(killer.getDisplayName());
            killerInfo.kills += 1;
            killer.sendMessage(ChatColor.BLUE + "masz " + killerInfo.kills + "zabójstw");
            teleportPlayerToSpawn(player, playerInfo.team);
            killer.setHealth(6);
            //##############only for test delete later
            teleportPlayerToSpawn(killer, killerInfo.team);

        }


    }
}
