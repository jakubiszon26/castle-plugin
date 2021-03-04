package com.multiportal.castle.utils;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import static com.multiportal.castle.players.playersManager.players;
import static org.bukkit.Material.IRON_CHESTPLATE;
import static com.multiportal.castle.utils.teleports.teleportPlayerToSpawn;



public class teamManager {
    public static void defineTeamAndAddToPlayersManager(World world, int maxPlayers, Player player) {
        String team;
        ItemStack[] ironTeamChestPlate = {new ItemStack(IRON_CHESTPLATE)};
        ItemStack[] diamondTeamChestPlate = {new ItemStack(Material.DIAMOND_CHESTPLATE)};
        int playersCount = world.getPlayers().size();
        if (playersCount >= maxPlayers) {
            player.sendMessage(ChatColor.DARK_GREEN + "w grze jest już maksymalna liczba osób, przełączymy cię w obserwatora :) ");
            player.setGameMode(GameMode.SPECTATOR);
            team = "spectator";
        } else {
            if (playersCount % 2 == 0) {
                team = "iron";
                player.getInventory().setChestplate(ironTeamChestPlate[0]);
                player.setBedSpawnLocation(new Location(player.getWorld(), 193, 72, -44));

            } else {
                team = "diamond";
                player.getInventory().setChestplate(diamondTeamChestPlate[0]);
                player.setBedSpawnLocation(new Location(player.getWorld(), 203, 72, -34));
            }
        }
        players.put(player.getDisplayName(), new PlayerObject(world, player, player.getDisplayName(), team));
        teleportPlayerToSpawn(player, team);

    }
}
