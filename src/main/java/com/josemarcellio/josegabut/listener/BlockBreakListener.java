package com.josemarcellio.josegabut.listener;

import com.josemarcellio.josegabut.tracker.BlockBreakTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreakListener implements Listener {

    private final BlockBreakTracker blockBreakTracker;
    private final Random random = new Random();

    public BlockBreakListener(BlockBreakTracker blockBreakTracker) {
        this.blockBreakTracker = blockBreakTracker;
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        blockBreakTracker.incrementBlockBreakCount(player.getUniqueId());

        int blocksBroken = blockBreakTracker.getBlockBreakCount(player.getUniqueId());
        if (blocksBroken >= getRandomBlockThreshold()) {
            int currentFoodLevel = player.getFoodLevel();
            if (currentFoodLevel > 0) {
                player.setFoodLevel(currentFoodLevel - 1);
            }
            blockBreakTracker.resetBlockBreakCount(player.getUniqueId());
        }
    }

    private int getRandomBlockThreshold() {
        return random.nextInt(4) + 5;
    }
}
