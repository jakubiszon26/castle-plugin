package com.multiportal.castle.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class friendlyFireLock implements Listener {
    @EventHandler
    public static void on(EntityDamageByEntityEvent event) {
        var damager = event.getDamager();
        var damageTaker = event.getEntity();
        Player taker;
        Player damagerPlayer;

        if (damageTaker instanceof Player) {
            taker = (Player) damageTaker;
            if (damager instanceof Player) {
                damagerPlayer = (Player) damager;
            }
        }


    }
}
