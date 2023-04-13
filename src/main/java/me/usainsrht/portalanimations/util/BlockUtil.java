package me.usainsrht.portalanimations.util;

import org.bukkit.Tag;
import org.bukkit.block.BlockState;

import java.util.ArrayList;
import java.util.List;

public class BlockUtil {

    public static List<BlockState> getPortalBlocks(List<BlockState> blocks) {
        List<BlockState> portalBlocks = new ArrayList<>();
        for (BlockState blockState : blocks) {
            if (Tag.PORTALS.isTagged(blockState.getType())) {
                portalBlocks.add(blockState);
            }
        }
        return portalBlocks;
    }

    public static List<BlockState> getFrameBlocks(List<BlockState> blocks) {
        List<BlockState> frameBlocks = new ArrayList<>();
        for (BlockState blockState : blocks) {
            if (!Tag.PORTALS.isTagged(blockState.getType())) {
                frameBlocks.add(blockState);
            }
        }
        return frameBlocks;
    }
}
