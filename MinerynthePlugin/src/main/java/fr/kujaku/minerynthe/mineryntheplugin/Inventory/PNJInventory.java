package fr.kujaku.minerynthe.mineryntheplugin.Inventory;

import fr.kujaku.minerynthe.mineryntheplugin.utils.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.Arrays;



public class PNJInventory {
    public static Inventory getMarchantInventory(Player p){
        Inventory inv = Bukkit.createInventory(p.getPlayer(), 54, "§6Marchant");
        for (int i = 0; i < 54; i++){
            inv.setItem(i, ItemUtil.createItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, "§8-"));
            if (i > 8 && i%9 == 0 && i < 43){
                i += 7;
            }
        }

        ItemStack potionHeal = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta m = (PotionMeta) potionHeal.getItemMeta();
        m.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 20, 0), true);
        m.setDisplayName("§4Potion de Heal sa mère");
        m.setLore(Arrays.asList("§7Nombre de point : "));
        m.setColor(Color.RED);
        potionHeal.setItemMeta(m);

        ItemStack potionRegen = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta m2 = (PotionMeta) potionRegen.getItemMeta();
        m2.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0), true);
        m2.setDisplayName("§dPotion de Regen sa mère");
        potionRegen.setItemMeta(m2);

        ItemStack potionSpeed = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta m3 = (PotionMeta) potionSpeed.getItemMeta();
        m3.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0), true);
        m3.setDisplayName("§dPotion de Speed sa mère");
        m3.setColor(Color.AQUA);
        potionSpeed.setItemMeta(m3);

        ItemStack potionForce = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta m4 = (PotionMeta) potionForce.getItemMeta();
        m4.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0), true);
        m4.setDisplayName("§dPotion de Force sa mère");
        m4.setColor(Color.MAROON);
        potionForce.setItemMeta(m4);


        inv.setItem(10, potionHeal);
        inv.setItem(11, potionRegen);
        inv.setItem(12, potionSpeed);
        inv.setItem(13, potionForce);
        inv.setItem(14, ItemUtil.createItemStack(Material.IRON_SWORD, 1, "§7[Epée des Titans]", Arrays.asList("§7Nombre de point : "), Enchantment.DAMAGE_ALL, 2));
        inv.setItem(15, ItemUtil.createItemStack(Material.IRON_SWORD, 1, "§4[Epée des Dieux]", Arrays.asList("§7Nombre de point : "), Enchantment.DAMAGE_ALL, 3));
        inv.setItem(16, ItemUtil.createItemStack(Material.IRON_SWORD, 1, "§6[Epée des êtres Cosmique]", Arrays.asList("§7Nombre de point : "), Enchantment.DAMAGE_ALL, 4));
        inv.setItem(19, ItemUtil.createItemStack(Material.IRON_CHESTPLATE, 1, "§c[Plastron de gros]", Arrays.asList("§7Nombre de point : "), Enchantment.PROTECTION_ENVIRONMENTAL, 1));
        inv.setItem(20, ItemUtil.createItemStack(Material.IRON_LEGGINGS, 1, "§c[Jambières d'obèse]", Arrays.asList("§7Nombre de point : "), Enchantment.PROTECTION_ENVIRONMENTAL, 1));




        return inv;
    }
}
