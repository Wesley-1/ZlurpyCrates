package zlurpycrates.zlurpycrates.animations.gui;

import lombok.Getter;
import lombok.var;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import zlurpycrates.zlurpycrates.ZlurpyCrates;
import zlurpycrates.zlurpycrates.crate.Crate;
import zlurpycrates.zlurpycrates.crate.CrateItem;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class MenuAnimation {

    private final int delta;
    private final List<CrateItem> prizes = new ArrayList<>();
    private final Plugin plugin;
    private final Crate crate;
    private final CrateInventory inventory;
    private final int finishSlot;

    protected MenuAnimation(Plugin plugin,
                            int delta,
                            Crate crate,
                            CrateInventory inventory,
                            int finishSlot) {

        this.delta = delta;
        this.plugin = plugin;
        this.crate = crate;
        this.inventory = inventory;
        this.finishSlot = finishSlot;

        for (int i = 0; i < getInventory().getAnimatedSlots(); i++) {
            prizes.add(i, randomizePrize());
            inventory.buildInventory().setItem(i + delta, prizes.get(i).getItemStack());
        }
    }

    public abstract void execute(Player player);

    public void spin(Player player) {

        final long[] timer = {0};

        new BukkitRunnable() {
            @Override
            public void run() {

                for (int i = 0; i < prizes.size(); i++) {
                    int slot = i + delta;
                    if (i == prizes.size() - 1) {
                        prizes.set(i, randomizePrize());
                        inventory.buildInventory().setItem(slot, prizes.get(i).getItemStack());
                        continue;
                    }

                    CrateItem next = prizes.get(i + 1);
                    inventory.buildInventory().setItem(slot, next.getItemStack());
                    prizes.set(i, next);
                }

                timer[0]++;

                if (timer[0] > 40) {
                    cancel();
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        player.closeInventory();
                        player.getInventory().addItem(inventory.buildInventory().getItem(finishSlot));
                        player.sendMessage("You won!" + prizes.get(prizes.size() % 2).getWinMessage());

                    }, 50);
                }
            }
        }.runTaskTimer(plugin, 0, 3);
    }

    public CrateItem randomizePrize() {
        return crate.getRewardList().get();
    }
}

