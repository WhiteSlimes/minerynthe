package fr.kujaku.minerynthe.mineryntheplugin.Command;

import fr.kujaku.minerynthe.mineryntheplugin.Listener.GameListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            GameListener.resetScoreBoard();
        }

        return false;
    }
}
