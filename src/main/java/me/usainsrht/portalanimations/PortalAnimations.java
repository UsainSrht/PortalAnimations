package me.usainsrht.portalanimations;

import org.bukkit.plugin.java.JavaPlugin;

public final class PortalAnimations extends JavaPlugin {

    private static PortalAnimations instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PortalAnimations getInstance() {
        return instance;
    }
}
