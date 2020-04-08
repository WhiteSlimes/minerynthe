package fr.kujaku.minerynthe.mineryntheplugin.Listener;

import fr.kujaku.minerynthe.mineryntheplugin.Main;
import fr.kujaku.minerynthe.mineryntheplugin.utils.DifficultyInfo;
import fr.kujaku.minerynthe.mineryntheplugin.utils.ItemUtil;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Arrays;


public class GameListener implements Listener {
    private static Main main;

    public DifficultyInfo difficultyInfo = new DifficultyInfo(null);



    public GameListener(Main main){
        this.main = main;
    }

    public static String minerynthe = ChatColor.DARK_RED + "[" + ChatColor.BOLD + ChatColor.DARK_BLUE + "MINERYNTHE" + ChatColor.DARK_RED + "]";
    int x = -191;
    int y = 4;
    int z = 155;
    static int  points = 0;
    static int mobKills = 0;
    ItemStack épée;
    ItemStack pantalon;
    ItemStack plastron;
    ItemStack cisaille = ItemUtil.createItemStack(Material.SHEARS, 1, ChatColor.GREEN + "Le débrousailleur");


    @EventHandler
    public void onInvClick(InventoryClickEvent e) throws InterruptedException {
        if (e.getView().getTitle().equals("§8Choix de difficultés")){
            e.setCancelled(true);


            Player p = (Player) e.getWhoClicked();

            Location location = new Location(p.getWorld(), x, y, z);

            Inventory inv = e.getClickedInventory();
            int slot = e.getSlot();
            if (slot == 10 && inv.getItem(slot) != null){
                Bukkit.broadcastMessage(minerynthe + "§2La difficultée est maintenant en mode facile.");
                épée = ItemUtil.createItemStack(Material.STONE_SWORD , 1, ChatColor.RED + "Mes couilles", Arrays.asList("Une arme légendaire de 27cm"), Enchantment.DAMAGE_ALL, 1);
                plastron = ItemUtil.createItemStack(Material.IRON_CHESTPLATE, 1);
                pantalon = ItemUtil.createItemStack(Material.IRON_LEGGINGS, 1);

                difficultyInfo.setDifficulty("Facile");

            }else if (slot == 13 && inv.getItem(slot) != null){
                Bukkit.broadcastMessage(minerynthe + "§6La difficultée est maintenant en mode normal.");
                épée = ItemUtil.createItemStack(Material.WOODEN_SWORD , 1, ChatColor.RED + "Mes couilles", Arrays.asList("Une arme légendaire de 27cm"));
                plastron = ItemUtil.createItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
                pantalon = ItemUtil.createItemStack(Material.CHAINMAIL_LEGGINGS, 1);


                difficultyInfo.setDifficulty("Normal");
            }else if (slot == 16 && inv.getItem(slot) != null){
                Bukkit.broadcastMessage(minerynthe + "§4La difficultée est maintenant en difficile.");
                épée = ItemUtil.createItemStack(Material.WOODEN_SWORD , 1, ChatColor.RED + "Mes couilles", Arrays.asList("Une arme légendaire de 27cm"));
                plastron = ItemUtil.createItemStack(Material.LEATHER_CHESTPLATE, 1);
                pantalon = ItemUtil.createItemStack(Material.LEATHER_LEGGINGS, 1);

                difficultyInfo.setDifficulty("Difficile");
            }else if (slot == 42 && inv.getItem(slot) != null){
                if (difficultyInfo != null){
                    p.closeInventory();
                    p.getInventory().clear();
                    p.getInventory().addItem(épée);
                    p.getInventory().addItem(cisaille);
                    p.getInventory().setChestplate(plastron);
                    p.getInventory().setLeggings(pantalon);
                    p.setGameMode(GameMode.ADVENTURE);
                    p.getInventory().addItem(ItemUtil.createItemStack(Material.COOKED_PORKCHOP, 16));
                    p.sendTitle(ChatColor.DARK_GREEN + "3", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20);
                    Bukkit.getScheduler().runTaskLater(main, () -> p.sendTitle(ChatColor.DARK_GREEN + "2", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20),65);
                    Bukkit.getScheduler().runTaskLater(main, () -> p.sendTitle(ChatColor.DARK_GREEN + "1", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20), 130);
                    Bukkit.getScheduler().runTaskLater(main, () -> p.sendTitle(ChatColor.DARK_GREEN + "GO !","", 20, 60, 20), 150);
                    Bukkit.getScheduler().runTaskLater(main, () -> p.teleport(location),150);

                    for (Entity entity : p.getNearbyEntities(1000, 1000, 1000)) {
                        if (entity instanceof Player) {
                            ((Player) entity).sendTitle(ChatColor.DARK_GREEN + "3", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20);
                            Bukkit.getScheduler().runTaskLater(main, () -> ((Player) entity).sendTitle(ChatColor.DARK_GREEN + "2", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20), 65);
                            Bukkit.getScheduler().runTaskLater(main, () -> ((Player) entity).sendTitle(ChatColor.DARK_GREEN + "1", ChatColor.RED + "La partie est en mode " + difficultyInfo.getDifficulty(), 20, 60, 20), 130);
                            Bukkit.getScheduler().runTaskLater(main, () -> ((Player) entity).sendTitle(ChatColor.DARK_GREEN + "GO !", "", 20, 60, 20), 150);
                            Bukkit.getScheduler().runTaskLater(main, () -> entity.teleport(location), 150);
                            ((Player) entity).getInventory().clear();
                            ((Player) entity).getInventory().addItem(épée);
                            ((Player) entity).getInventory().addItem(ItemUtil.createItemStack(Material.COOKED_PORKCHOP, 16));
                            ((Player) entity).getInventory().addItem(cisaille);
                            ((Player) entity).getInventory().setChestplate(plastron);
                            ((Player) entity).getInventory().setLeggings(pantalon);
                            ((Player) entity).setGameMode(GameMode.ADVENTURE);
                        }
                    }
                }else {
                    p.sendMessage(minerynthe + ChatColor.RED + "Tu dois choisir une difficultée !");
                    p.closeInventory();
                }
            }
        }
    }

    @EventHandler
    public void entityKillByPlayer(EntityDeathEvent e){
        final Player p = e.getEntity().getKiller();
        if (difficultyInfo.getDifficulty().equals("Facile")){
            if (e.getEntity() instanceof Zombie){
                points += 1;
                mobKills +=1;
            }

        }else if (difficultyInfo.getDifficulty().equals("Normal")){
            if (e.getEntity() instanceof Zombie){
                points += 2;
                mobKills +=1;
            }else if (e.getEntity() instanceof Spider){
                points += 1;
                mobKills +=1;
            }
        }else if (difficultyInfo.getDifficulty().equals("Difficile")){
            if (e.getEntity() instanceof Zombie){
                points +=3;
                mobKills +=1;
            }else if (e.getEntity() instanceof Spider){

                points += 2;
                mobKills +=1;
            }

        }
    }

    @EventHandler
    public void addPotionEffect(EntityDamageByEntityEvent e){
        final Player p = (Player) e.getEntity();
        if (difficultyInfo.getDifficulty().equals("Normal")){
            if (e.getDamager() instanceof Zombie){
                p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 60, 0, true), true);
            }
        }
        if (difficultyInfo.getDifficulty().equals("Difficile")){
            if (e.getDamager() instanceof Zombie){
                p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 0, true), true);
            }
            if (e.getDamager() instanceof Spider){
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 0, true), true);
            }
        }
        return;
    }



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("general", "dummy");
        objective.setDisplayName(minerynthe);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score point  = objective.getScore(ChatColor.GREEN + "Points : ");
        Score mobKill  = objective.getScore(ChatColor.GREEN + "Mobkill : ");

        Player p = e.getPlayer();
        new BukkitRunnable(){

            @Override
            public void run() {
                point.setScore(points);
                mobKill.setScore(mobKills);
            }
        }.runTaskTimer(main, 60L, 20L);

        p.setScoreboard(scoreboard);
    }

    public static void resetScoreBoard(){
        points = 0;
        mobKills = 0;
    }
}
