package me.usainsrht.portalanimations.command;

import me.usainsrht.portalanimations.PortalAnimations;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PortalAnimationsCommand extends Command {

    public PortalAnimationsCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String command, String[] args) {
        if (!sender.hasPermission("portalanimations.command")) return true;
        if (args.length == 0) return true;
        if (args[0].equalsIgnoreCase("reload")) {
            PortalAnimations.reload();
            sender.sendMessage(Component.text("Config reloaded successfully!").color(NamedTextColor.GREEN));
        }
        return true;
    }
}