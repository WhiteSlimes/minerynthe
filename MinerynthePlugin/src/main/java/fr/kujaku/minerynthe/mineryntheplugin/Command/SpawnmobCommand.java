package fr.kujaku.minerynthe.mineryntheplugin.Command;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class SpawnmobCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if( sender instanceof Player){
            if (args.length == 0){
                sender.sendMessage(ChatColor.RED + "Voici la listes des modes de difficultés :");
                sender.sendMessage(ChatColor.RED + "/spawnmob facile");
                sender.sendMessage(ChatColor.RED + "/spawnmob moyen");
                sender.sendMessage(ChatColor.RED + "/spawnmob difficile");
            }
            if (args.length == 1){
                final World world = ((Player) sender).getWorld();

                Zombie zombie = (Zombie) world.spawnEntity(((Player) sender).getLocation(), EntityType.ZOMBIE);
                switch (args[0]){
                    case "facile":
                        zombie.setMaxHealth(10);
                        zombie.setHealth(10);
                        sender.sendMessage("La difficulté du zombie est bien en facile");
                        break;

                    case "moyen":
                        zombie.setMaxHealth(30);
                        zombie.setHealth(30);
                        sender.sendMessage("La difficulté du zombie est bien en Moyen");
                        break;

                    case "difficile":
                        zombie.setMaxHealth(50);
                        zombie.setHealth(50);
                        sender.sendMessage("La difficulté du zombie est bien en Difficile");
                        break;
                }

                zombie.setCustomName(ChatColor.DARK_RED + "Boss" + ChatColor.RED );
            }
        }

        return false;
    }
}
