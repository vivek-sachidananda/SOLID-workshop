package warehouse.main;

import warehouse.comission.CommissionCalculator;
import warehouse.item.Item;
import warehouse.persistence.ItemRepository;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OCPMain {
    public static void main(String[] args) {
        // Create dependencies
        ItemRepository repository = new ItemRepository();

        // Grab employees
        List<Item> items = repository.findAll();

        // Calculate taxes
        CommissionCalculator commissionCalculator = new CommissionCalculator();

        double totalCommission = 0;
        for (Item item: items){
            // compute individual commission
            double commission = commissionCalculator.calculate(item);
            System.out.println("Commission for item : " + item.getName() + " commission : " + commission);
            // add to company total taxes
            totalCommission += commission;
        }
        System.out.println("Total commission : " + totalCommission);
    }
}
