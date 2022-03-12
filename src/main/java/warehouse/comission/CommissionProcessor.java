package warehouse.comission;

import warehouse.item.Item;
import warehouse.notifications.EmailSender;
import warehouse.persistence.ItemRepository;

import java.util.List;

public class CommissionProcessor {
    private ItemRepository itemRepository;
    private CommissionCalculator commissionCalculator;

    public CommissionProcessor() {
        this.itemRepository = new ItemRepository();
        this.commissionCalculator = new CommissionCalculator();
    }

    public int sendCommission() {
        List<Item> items = this.itemRepository.findAll();
        int totalCommission = 0;

        for(Item item : items){
            totalCommission += commissionCalculator.calculate(item);
            EmailSender.notify(item);
        }

        return totalCommission;
    }
}
