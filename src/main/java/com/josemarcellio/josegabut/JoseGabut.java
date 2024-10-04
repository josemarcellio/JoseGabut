package com.josemarcellio.josegabut;

import com.josemarcellio.josegabut.manager.HungerManager;
import com.josemarcellio.josegabut.tracker.BlockBreakTracker;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class JoseGabut extends JavaPlugin {

    private BlockBreakTracker blockBreakTracker;

    @Override
    public void onEnable() {
        blockBreakTracker = new BlockBreakTracker(this);
        blockBreakTracker.registerListeners();

        HungerManager hungerManager = new HungerManager(this);
        hungerManager.startHungerTask();
    }

    @Override
    public void onDisable() {
        blockBreakTracker.clearTracking();
    }
}
