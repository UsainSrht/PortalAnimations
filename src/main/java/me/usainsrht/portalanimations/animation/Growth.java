package me.usainsrht.portalanimations.animation;

import me.usainsrht.portalanimations.PortalAnimations;
import me.usainsrht.portalanimations.util.BlockUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Growth {

    public static void play(List<BlockState> blocks, int time) {
        Block reference = blocks.get(0).getBlock();
        World world = reference.getWorld();
        Collection<Player> players = world.getNearbyPlayers(reference.getLocation(), Bukkit.getViewDistance() * 16);
        List<ItemDisplay> displays = new ArrayList<>();
        for (BlockState frame : BlockUtil.getFrameBlocks(blocks)) {
            ItemDisplay display = (ItemDisplay) world.spawnEntity(frame.getLocation(), EntityType.ITEM_DISPLAY);
            ItemStack itemStack = new ItemStack(frame.getType());
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.addEnchant(Enchantment.LURE, 1, false);
            itemStack.setItemMeta(itemMeta);
            display.setItemStack(itemStack);
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

        }, 1);
        Bukkit.getScheduler().runTaskLater(PortalAnimations.getInstance(), () -> {
            displays.forEach(Entity::remove);
        }, time);
    }
}
