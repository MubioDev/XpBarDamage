package me.mubio.xpbardamage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class XpBarDamageMain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {

        // Create a local variable for the damager.
        Entity damager = event.getDamager();

        // Check and return if the damager isn't a player.
        if (!(damager instanceof Player)) return;

        // Create a local variable for the last damage dealt, casted as an integer.
        int damage = (int) event.getDamage();

        // Set the experience level for the damager, casted as a player.
        ((Player) damager).setLevel(damage);
    }

}
