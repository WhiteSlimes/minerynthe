package fr.kujaku.minerynthe.mineryntheplugin;

import fr.kujaku.minerynthe.mineryntheplugin.Command.PNJCommand;
import fr.kujaku.minerynthe.mineryntheplugin.Command.PlayCommand;
import fr.kujaku.minerynthe.mineryntheplugin.Command.ResetCommand;
import fr.kujaku.minerynthe.mineryntheplugin.Command.SpawnmobCommand;
import fr.kujaku.minerynthe.mineryntheplugin.Listener.GameListener;
import fr.kujaku.minerynthe.mineryntheplugin.Listener.PNJListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;


    @Getter
    public static ArrayList<String> loadingList = new ArrayList<>();

    @Getter
    @Setter
    private static boolean serverOpen;

    @Getter
    private static PluginManager pluginManager;

    @Override
    public void onEnable() {
        System.out.println("----->Starting Minerynthe<-----");
        getCommand("spawnmob").setExecutor(new SpawnmobCommand());
        getCommand("play").setExecutor(new PlayCommand());
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("pnj").setExecutor(new PNJCommand());
        instance = this;
        serverOpen = true;


        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PNJListener(), this);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
