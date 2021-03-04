package com.multiportal.castle.players;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerObject {
    public World world;
    public Player player;
    public String nickname;
    public String team;
    public int kills;

    public PlayerObject(World world, Player player, String nickname, String team){
        this.world = world;
        this.player = player;
        this.nickname = nickname;
        this.team = team;
    }

}
