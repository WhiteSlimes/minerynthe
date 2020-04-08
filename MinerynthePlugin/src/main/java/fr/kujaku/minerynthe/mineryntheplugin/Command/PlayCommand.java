package fr.kujaku.minerynthe.mineryntheplugin.Command;

import fr.kujaku.minerynthe.mineryntheplugin.Inventory.DifficultyInventory;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String minerynthe = ChatColor.DARK_RED + "[" + ChatColor.BOLD + ChatColor.DARK_BLUE + "MINERYNTHE" + ChatColor.DARK_RED + "]";
        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 0){
                p.openInventory(DifficultyInventory.getMainInventory(p));
            }else{
                p.sendMessage(minerynthe +ChatColor.RED +  "Il y a trop d'arguments.");
            }
        }

        return false;
    }
}
