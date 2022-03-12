package warehouse.main;

import warehouse.comission.CommissionProcessor;

public class DIPMain {
    public static void main(String[] args) {
        CommissionProcessor paymentProcessor = new CommissionProcessor();
        int totalCommission = paymentProcessor.sendCommission();
        System.out.println("Total commission " + totalCommission);
    }
}
