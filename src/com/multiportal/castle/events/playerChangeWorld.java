package com.multiportal.castle.events;

import com.multiportal.castle.players.PlayerObject;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;

import static com.multiportal.castle.players.playersManager.players;
import static org.bukkit.Material.IRON_CHESTPLATE;

public class playerChangeWorld implements Listener {
    @EventHandler
    public static void onPlayerWorldChange(PlayerChangedWorldEvent event) {
        var maxPlayers = 2;
        Player player = event.getPlayer();
        if (player.getWorld().getName().contains("cstl")) {
            World world = player.getWorld();
            var playersCount = world.getPlayers().size();
            //clear player inventory before game
            player.getInventory().clear();
            player.sendMessage(ChatColor.YELLOW + "Witaj w castle");
            //if game is full go to spectate mode
            if (playersCount > maxPlayers) {
                player.sendMessage(ChatColor.RED + "W tej grze jest już maksymalna liczba osób, przełączymy cię w obserwatora");
                player.setGameMode(GameMode.SPECTATOR);
                players.put(player.getDisplayName(), new PlayerObject(player.getWorld(), player, player.getDisplayName(), "spectator"));

            } else {
                //define team armor in variables
                ItemStack[] ironTeamChestPlate = {new ItemStack(IRON_CHESTPLATE)};
                ItemStack[] diamondTeamChestPlate = {new ItemStack(Material.DIAMOND_CHESTPLATE)};

                if (playersCount <= maxPlayers * 0.5) {
                    player.getInventory().setChestplate(ironTeamChestPlate[0]);
                    players.put(player.getDisplayName(), new PlayerObject(player.getWorld(), player, player.getDisplayName(), "iron"));
                    player.teleport(new Location(player.getWorld(), 193, 72, -44));

                } else if (playersCount > maxPlayers * 0.5) {
                    players.put(player.getDisplayName(), new PlayerObject(player.getWorld(), player, player.getDisplayName(), "diamond"));

                    player.getInventory().setChestplate(diamondTeamChestPlate[0]);
                    player.teleport(new Location(player.getWorld(), 203, 72, -34));
                }
                player.sendMessage(ChatColor.BLUE + "Jestes w druzynie " + players.get(player.getDisplayName()));


            }
        }else {
            players.remove(player.getDisplayName());
        }
    }


}

