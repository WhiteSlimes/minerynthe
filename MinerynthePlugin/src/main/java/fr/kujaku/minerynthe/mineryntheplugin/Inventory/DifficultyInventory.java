package fr.kujaku.minerynthe.mineryntheplugin.Inventory;

import fr.kujaku.minerynthe.mineryntheplugin.utils.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class DifficultyInventory {
    public static Inventory getMainInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 54, "§8Choix de difficultés");

        ItemStack skull1 = new ItemStack(Material.ZOMBIE_HEAD, 1);
        SkullMeta skullMeta1 = (SkullMeta) skull1.getItemMeta();
        skullMeta1.setDisplayName("§2Facile");
        skullMeta1.setLore(Collections.singletonList("§7La difficultés est assez simple"));
        skull1.setItemMeta(skullMeta1);

        ItemStack skull2 = new ItemStack(Material.SKELETON_SKULL, 1);
        SkullMeta skullMeta2 = (SkullMeta) skull2.getItemMeta();
        skullMeta2.setDisplayName("§6Normal");
        skullMeta2.setLore(Collections.singletonList("§7La difficultés est normal"));
        skull2.setItemMeta(skullMeta2);

        ItemStack skull3 = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
        SkullMeta skullMeta3 = (SkullMeta) skull3.getItemMeta();
        skullMeta3.setDisplayName("§4Difficile");
        skullMeta3.setLore(Collections.singletonList("§7La difficultés est difficile"));
        skull3.setItemMeta(skullMeta3);

        /* Bordure */
        for(int i = 0; i < 54; i++) {
            inv.setItem(i, ItemUtil.createItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, "§8-"));
            if(i > 8 && i%9 == 0 && i < 43) {
                i += 7;
            }
        }

        inv.setItem(10, skull1);
        inv.setItem(13, skull2);
        inv.setItem(16, skull3);
        inv.setItem(42, ItemUtil.createItemStack(Material.DARK_OAK_BUTTON, 1, "§6Lancer la partie"));

        return inv;
    }
}
