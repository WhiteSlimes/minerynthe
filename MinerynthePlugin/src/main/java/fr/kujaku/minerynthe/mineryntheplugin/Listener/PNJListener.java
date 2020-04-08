package fr.kujaku.minerynthe.mineryntheplugin.Listener;

import fr.kujaku.minerynthe.mineryntheplugin.Inventory.PNJInventory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class PNJListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e){
        Entity entity = e.getRightClicked();
        if (entity instanceof Villager){
            if (entity.getCustomName().equals("§6Marchant")){
               Player p = e.getPlayer();
               p.openInventory(PNJInventory.getMarchantInventory(p));
            }
        }
    }
    @EventHandler
    public void onHandle(InventoryDragEvent e){
        if (e.getView().getTitle().equals("§6Marchant")){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if (e.getClickedInventory() != null && e.getView().getTitle().equals("§6Marchant")){
           Inventory inv = e.getClickedInventory();
           e.setCancelled(true);
           int slot = e.getSlot();
           Player p = (Player) e.getWhoClicked();
        }
    }

}
