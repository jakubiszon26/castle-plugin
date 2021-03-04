package com.multiportal.castle.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class teleports {
    public static void teleportPlayerToSpawn(Player player, String team){
        if(team.equals("diamond")){
            player.teleport(new Location(player.getWorld(), 203, 72, -34));
        } else if (team.equals("iron")){
            player.teleport(new Location(player.getWorld(), 193, 72, -44));
        }
    }
}
