package me.usainsrht.portalanimations;

import me.usainsrht.portalanimations.command.CommandHandler;
import me.usainsrht.portalanimations.command.PortalAnimationsCommand;
import me.usainsrht.portalanimations.listener.PortalCreate;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class PortalAnimations extends JavaPlugin {

    private static PortalAnimations instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PortalCreate(), this);
        CommandHandler.register(new PortalAnimationsCommand("portalanimations",
                "command to reload config",
                "/portalanimations reload",
                new ArrayList<>()));
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PortalAnimations getInstance() {
        return instance;
    }

    public static void reload() {
        instance.reloadConfig();
    }
}
