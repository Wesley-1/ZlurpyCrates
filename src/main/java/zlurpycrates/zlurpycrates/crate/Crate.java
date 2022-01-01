package zlurpycrates.zlurpycrates.crate;

import lombok.Getter;
import lombok.Setter;
import zlurpycrates.zlurpycrates.util.RandomizeList;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class Crate {

    private final String crateName;
    private RandomizeList<CrateItem> rewardList = new RandomizeList<>();

    public Crate(String crateName, CrateItem... rewards) {
        this.crateName = crateName;
        Arrays.stream(rewards).forEach(reward ->
            rewardList.add(reward, reward.getChance()));

    }


}
