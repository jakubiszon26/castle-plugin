package com.multiportal.castle.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class status implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(player.getWorld().getName().contains("cstl")){
                player.sendMessage(ChatColor.BLUE + "Podejrzewam, że jesteś adminem i chcesz sprawdzić czy działa plugin castle. Jak nie jestes to nic nie szkodzi :) tą komendą nikomu nie zaszkodzisz");

            }
        }
        return true;
    }
}