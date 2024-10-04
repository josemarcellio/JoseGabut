package com.josemarcellio.josegabut.tracker;

import com.josemarcellio.josegabut.listener.BlockBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BlockBreakTracker {

    private final JavaPlugin plugin;
    private final Map<UUID, Integer> blockBreakCount = new HashMap<>();

    public BlockBreakTracker(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new BlockBreakListener(this), plugin);
    }

    public void incrementBlockBreakCount(UUID playerId) {
        blockBreakCount.put(playerId, blockBreakCount.getOrDefault(playerId, 0) + 1);
    }

    public int getBlockBreakCount(UUID playerId) {
        return blockBreakCount.getOrDefault(playerId, 0);
    }

    public void resetBlockBreakCount(UUID playerId) {
        blockBreakCount.put(playerId, 0);
    }

    public void clearTracking() {
        blockBreakCount.clear();
    }
}
