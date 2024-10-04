package com.josemarcellio.josegabut.manager;

import com.josemarcellio.josegabut.runnable.HungerTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class HungerManager {

    private final JavaPlugin plugin;

    public HungerManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void startHungerTask() {
        HungerTask hungerTask = new HungerTask();
        Bukkit.getScheduler().runTaskTimer(plugin, hungerTask, 0L, 60L);
    }
}
