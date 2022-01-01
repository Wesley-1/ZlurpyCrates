package zlurpycrates.zlurpycrates.animations.gui;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

@Getter
public class CrateInventory {

    private final String name;
    private final int slots;
    private final int animatedSlots;
    private final Inventory inventory;

    public CrateInventory(String name, int slots, int animatedSlots) {
        this.name = name;
        this.slots = slots;
        this.animatedSlots = animatedSlots;
        this.inventory = Bukkit.createInventory(null, slots, name);

    }

    public Inventory buildInventory() {
        return this.inventory;
    }
}
