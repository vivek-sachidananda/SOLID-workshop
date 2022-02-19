package warehouse.item;

import java.util.Collection;

public class Spr extends Item {
    Collection<Item> articles;
    public Spr(String name, String description, int amount) {
        super(name, description, "SPR", amount);
    }
}
