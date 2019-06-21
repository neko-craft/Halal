package io.menhera.muslim;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class listener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerClick(PlayerItemConsumeEvent event)
    {
        System.out.println(event);
        int shock_count = 10;
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        System.out.println(item.getType());
        if(item.getType().equals(Material.PORKCHOP) || item.getType().equals(Material.COOKED_PORKCHOP))
        {
            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    player.getWorld().strikeLightning(player.getLocation());
                }
            }.runTaskAsynchronously(main.main);
        }
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if (entity.getType().equals(EntityType.PIG)) {
            if (event.getDamager().getType().equals(EntityType.PLAYER)) {
                Player player = (Player) event.getDamager();
                player.getWorld().strikeLightningEffect(player.getLocation());
                player.setFireTicks(20 * 8);
                player.setHealth(player.getHealth() / 3);
                event.setCancelled(true);
            }
        }
    }
}
