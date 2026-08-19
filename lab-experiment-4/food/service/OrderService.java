package food.service;

import food.model.FoodOrder;
import food.utility.OrderUtility;

public class OrderService {

    public void displayBill(FoodOrder[] orders) {

        System.out.println("\n========================================");
        System.out.println("          FOOD EXPRESS BILL");
        System.out.println("========================================");

        for (FoodOrder order : orders) {
            OrderUtility.generateOrderSummary(order);
        }

        FoodOrder.displayTotalOrders();
    }
}
