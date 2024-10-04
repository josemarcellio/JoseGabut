package com.josemarcellio.josegabut.runnable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HungerTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            int hunger = player.getFoodLevel();
            if (hunger < 2) {
                addPotionEffect(player);
            } else if (hunger > 5) {
                removePotionEffect(player);
            }
        }
    }

    private void addPotionEffect(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 80, 1, false, false, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 80, 1, false, false, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0, false, false, true));
        player.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 80, 1, false, false, true));
    }

    private void removePotionEffect(Player player) {
        player.removePotionEffect(PotionEffectType.SLOWNESS);
        player.removePotionEffect(PotionEffectType.NAUSEA);
        player.removePotionEffect(PotionEffectType.BLINDNESS);
        player.removePotionEffect(PotionEffectType.MINING_FATIGUE);
    }
}
