package me.usainsrht.portalanimations.listener;

import me.usainsrht.portalanimations.PortalAnimations;
import me.usainsrht.portalanimations.animation.Animation;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class PortalCreate implements Listener {

    @EventHandler
    public void portalCreate(PortalCreateEvent e) {
        String reason = e.getReason().toString();
        String anim = PortalAnimations.getInstance().getConfig().getString("animations." + reason + ".type");
        int time = PortalAnimations.getInstance().getConfig().getInt("animations." + reason + ".time");
        Animation animation = Animation.valueOf(anim);
        animation.play(e.getBlocks(), time);
    }
}
