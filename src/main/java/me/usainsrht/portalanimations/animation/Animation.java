package me.usainsrht.portalanimations.animation;

import org.bukkit.block.BlockState;

import java.util.List;

public enum Animation {
    EnchantedObsidian{
        public void play(List<BlockState> blocks) {
            EnchantedObsidian.play(blocks);
        }
    };

    public abstract void play(List<BlockState> blocks);
}
