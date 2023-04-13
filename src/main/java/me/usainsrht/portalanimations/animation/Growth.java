package me.usainsrht.portalanimations.animation;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class Growth {

    public static void play(List<BlockState> blocks, int time) {
        Block reference = blocks.get(0).getBlock();
        Collection<Player> players = reference.getWorld().getNearbyPlayers(reference.getLocation(), Bukkit.getViewDistance() * 16);

    }
}
