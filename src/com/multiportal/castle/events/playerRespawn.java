package com.multiportal.castle.events;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static com.multiportal.castle.castle.plugin;
import static com.multiportal.castle.players.playersManager.players;
import static com.multiportal.castle.utils.teleports.teleportPlayerToSpawn;
import static org.bukkit.Material.IRON_CHESTPLATE;

public class playerRespawn implements Listener {
    @EventHandler
    public static void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().contains("cstl")) {
            PlayerObject playerInfo = players.get(player.getDisplayName());
            //one tick delay coz we cant teleport player directly on respawn
            new BukkitRunnable() {
                public void run() {
                    teleportPlayerToSpawn(player, playerInfo.team);
                }
            }.runTaskLater(plugin, 1);
            //give player his team items
            player.getInventory().clear();
            if (playerInfo.team.equals("iron")) {
                ItemStack[] ironTeamChestPlate = {new ItemStack(IRON_CHESTPLATE)};
                ItemStack[] diamondSword = {new ItemStack(Material.DIAMOND_SWORD)};
                player.getInventory().setChestplate(ironTeamChestPlate[0]);
                player.getInventory().setItem(1, diamondSword[0]);

            } else if (playerInfo.team.equals("diamond")) {
                ItemStack[] diamondTeamChestPlate = {new ItemStack(Material.DIAMOND_CHESTPLATE)};
                ItemStack[] ironSword = {new ItemStack(Material.IRON_SWORD)};
                player.getInventory().setChestplate(diamondTeamChestPlate[0]);
                player.getInventory().setItem(1, ironSword[0]);


            }
        }

    }
}
