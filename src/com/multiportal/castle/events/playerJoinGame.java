package com.multiportal.castle.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import static org.bukkit.Material.IRON_CHESTPLATE;
import static com.multiportal.castle.players.playersManager.players;
public class playerJoinGame implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent joinEvent) {
        //set max number of players in game (in future in config.yaml)
        var maxPlayers = 2;
        Player player = joinEvent.getPlayer();
        var playersCount = Bukkit.getOnlinePlayers().size();
        //clear player inventory before game
        player.getInventory().clear();
        player.sendMessage(ChatColor.YELLOW + "Witaj w castle");
        //if game is full go to spectate mode
        if (playersCount > maxPlayers) {
            player.sendMessage(ChatColor.RED + "W tej grze jest już maksymalna liczba osób, przełączymy cię w obserwatora");
            player.setGameMode(GameMode.SPECTATOR);
            players.put(player.getDisplayName(), "spectator");

        } else {
            //define team armor in variables
            ItemStack[] ironTeamChestPlate = {new ItemStack(IRON_CHESTPLATE)};
            ItemStack[] diamondTeamChestPlate = {new ItemStack(Material.DIAMOND_CHESTPLATE)};

            if (playersCount <= maxPlayers * 0.5) {
                player.getInventory().setChestplate(ironTeamChestPlate[0]);
                players.put(player.getDisplayName(), "iron");
                player.teleport(new Location(player.getWorld(), 193, 72, -44));

            } else if (playersCount > maxPlayers * 0.5) {
                players.put(player.getDisplayName(), "diamond");
                player.getInventory().setChestplate(diamondTeamChestPlate[0]);
                player.teleport(new Location(player.getWorld(), 203, 72, -34));
            }
            player.sendMessage(ChatColor.BLUE + "Jestes w druzynie " + players.get(player.getDisplayName()));


        }
        //iron spawn TELEPORT:
        //player.teleport(new Location(player.getWorld(), 193, 72, -44));
        //diamond spawn TELEPORT:
        //player.teleport(new Location(player.getWorld(), 203, 72, -34));
    }
}
