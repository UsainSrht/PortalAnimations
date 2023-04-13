package me.usainsrht.portalanimations.animation;

import org.bukkit.block.BlockState;

import java.util.List;

public enum Animation {
    ENCHANTED_FRAME{
        public void play(List<BlockState> blocks, int time) {
            EnchantedFrame.play(blocks, time);
        }
    },
    GROWTH{
        public void play(List<BlockState> blocks, int time) {
            Growth.play(blocks, time);
        }
    };

    public abstract void play(List<BlockState> blocks, int time);
}
