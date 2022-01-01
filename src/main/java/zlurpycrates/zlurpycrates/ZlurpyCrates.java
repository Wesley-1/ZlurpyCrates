package zlurpycrates.zlurpycrates;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import zlurpycrates.zlurpycrates.animations.gui.types.CSGOAnimation;

public final class ZlurpyCrates extends JavaPlugin implements Listener {

    public static ZlurpyCrates instance;

    public static ZlurpyCrates getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new CSGOAnimation().execute(event.getPlayer());
    }

}
