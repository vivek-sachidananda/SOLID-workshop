package warehouse.comission;

import warehouse.item.Item;

public class CommissionCalculator {
    private final int SERVICE_COMMISSION_PC = 10;
    private final int THIRD_PARTY_COMMISSION_PC = 16;
    private final int FIXED_COMMISSION = 100;


    public double calculate(Item item) {
        return FIXED_COMMISSION +
                (item.getAmount() * SERVICE_COMMISSION_PC) / 100 +
                (item.getAmount() * THIRD_PARTY_COMMISSION_PC) / 100;
    }
}
