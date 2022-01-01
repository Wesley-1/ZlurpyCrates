package zlurpycrates.zlurpycrates.crate;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
public class CrateItem {

    private final Material material;
    private final Double chance;
    private final String winMessage;

    public CrateItem(Material material, Double chance, String winMessage) {
        this.material = material;
        this.chance = chance;
        this.winMessage = winMessage;
    }

    public ItemStack getItemStack() {
        return new ItemStack(material);
    }

    public void handleGive() {

    }

}
