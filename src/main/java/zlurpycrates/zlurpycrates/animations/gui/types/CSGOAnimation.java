package zlurpycrates.zlurpycrates.animations.gui.types;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import zlurpycrates.zlurpycrates.ZlurpyCrates;
import zlurpycrates.zlurpycrates.animations.gui.CrateInventory;
import zlurpycrates.zlurpycrates.animations.gui.MenuAnimation;
import zlurpycrates.zlurpycrates.crate.Crate;
import zlurpycrates.zlurpycrates.crate.CrateItem;

public class CSGOAnimation extends MenuAnimation {

    public CSGOAnimation() {
        super(ZlurpyCrates.getInstance(), 9, new Crate("Test",
                new CrateItem(Material.DIAMOND, 10.0, "You won a diamond, very lucky boy"),
                new CrateItem(Material.STONE, 90.0, "Thats depressing... STONE?"),
                new CrateItem(Material.ACACIA_DOOR, 10.0, "Door"),
                new CrateItem(Material.ANVIL, 10.0, "Anvil")),
                new CrateInventory("Test", 27, 9), 13);
    }

    @Override
    public void execute(Player player) {
        player.openInventory(this.getInventory().buildInventory());
        spin(player);
    }
}
