package fr.kujaku.minerynthe.mineryntheplugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class PNJCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()){
            if (args.length == 1){
                Player p = (Player)sender;
                Villager villager = null;
                switch (args[0]){
                    case "marchant":
                        p = (Player)sender;
                        villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                        villager.setInvulnerable(true);
                        villager.setAI(false);
                        villager.setCustomName("§6Marchant");
                        p.sendMessage("Le marchant a été créé avec succès.");
                        break;
                }
            }
        }
        return false;
    }
}
