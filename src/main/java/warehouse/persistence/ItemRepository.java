package warehouse.persistence;

import warehouse.item.Art;
import warehouse.item.Ddc;
import warehouse.item.Item;
import warehouse.item.Spr;

import java.util.Arrays;
import java.util.List;

/*
Helper method to perform CRUD operations on Item. In a production
application we could use the database for persistence. In this demo,
we are storing items in the file system.
 */

public class ItemRepository {

    public List<Item> findAll(){

        // Items are kept in memory for simplicity
        Item art = new Art("Kallax", "Shelves", 800);
        Item ddc = new Ddc("Billy", "Worktop", 8000);

        Item spr1 = new Spr("Keuken", "Italian Kitchen", 80000);
        Item spr2 = new Spr("Desk", "Office desk", 920);

        return Arrays.asList(art, ddc, spr1, spr2);
    }
}
