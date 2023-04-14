package me.usainsrht.portalanimations.animation;

import me.usainsrht.portalanimations.PortalAnimations;
import me.usainsrht.portalanimations.util.BlockUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.*;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Growth {

    public static void play(List<BlockState> blocks, int time) {
        Block reference = blocks.get(0).getBlock();
        World world = reference.getWorld();
        Collection<Player> players = world.getNearbyPlayers(reference.getLocation(), Bukkit.getViewDistance() * 16);
        List<BlockDisplay> displays = new ArrayList<>();
        for (BlockState frame : blocks) {
            BlockDisplay display = (BlockDisplay) world.spawnEntity(frame.getLocation(), EntityType.BLOCK_DISPLAY);
            display.setBlock(frame.getBlockData());
            display.setBillboard(Display.Billboard.FIXED);
            display.setInterpolationDelay(0);
            display.setInterpolationDuration(0);
            Vector3f translation = new Vector3f(0.5f,0.5f,0.5f);
            Quaternionf leftRotation = new Quaternionf(0,0,0,1);
            Vector3f scale = new Vector3f(0.0f,0.0f,0.0f);
            Quaternionf rightRotation = new Quaternionf(0,0,0,1);
            Transformation transformation = new Transformation(translation, leftRotation, scale, rightRotation);
            display.setTransformation(transformation);
            displays.add(display);
        }
        Bukkit.getScheduler().runTaskLater(PortalAnimations.getInstance(), () -> {
            List<BlockState> air = new ArrayList<>(blocks);
            air.forEach(blockState -> blockState.setType(Material.AIR));
            players.forEach(p -> p.sendBlockChanges(air, true));
            for (BlockDisplay display : displays) {
                display.setInterpolationDuration(time);
                Vector3f translation = new Vector3f(0.0f,0.0f,0.0f);
                Quaternionf leftRotation = new Quaternionf(0,0,0,1);
                Vector3f scale = new Vector3f(1.0f,1.0f,1.0f);
                Quaternionf rightRotation = new Quaternionf(0,0,0,1);
                Transformation transformation = new Transformation(translation, leftRotation, scale, rightRotation);
                display.setTransformation(transformation);
                displays.add(display);
            }
        }, 2);
        Bukkit.getScheduler().runTaskLater(PortalAnimations.getInstance(), () -> {
            players.forEach(p -> p.sendBlockChanges(blocks, true));
            displays.forEach(Entity::remove);
        }, time);
    }
}
