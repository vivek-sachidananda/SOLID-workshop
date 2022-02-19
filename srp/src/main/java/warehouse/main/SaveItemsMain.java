package warehouse.main;

import warehouse.persistence.ItemRepository;
import warehouse.item.Item;

import java.util.List;

public class SaveItemsMain {
    public static void main(String[] args) {
        // Get the Items from repository
        ItemRepository repository = new ItemRepository();
        List<Item> items = repository.findAll();

        // Save all
        for (Item e : items){
            Item.save(e);
        }
    }
}
