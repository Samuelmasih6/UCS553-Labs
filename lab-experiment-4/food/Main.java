package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;
import food.utility.OrderUtility;

public class Main {

    public static void main(String[] args) {

        // Create at least six orders
        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 500);
        orders[1] = new PremiumOrder(102, "Priya", 1000);
        orders[2] = new RegularOrder(103, "Amit", 750);
        orders[3] = new PremiumOrder(104, "Neha", 1200);
        orders[4] = new RegularOrder(105, "Rohan", 600);
        orders[5] = new PremiumOrder(106, "Sneha", 900);

        // Validate orders
        for (FoodOrder order : orders) {

            if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
                System.out.println(
                    "Invalid customer name for Order ID: "
                    + order.getOrderId()
                );
                return;
            }

            if (!OrderUtility.validateAmount(order.getAmount())) {
                System.out.println(
                    "Invalid amount for Order ID: "
                    + order.getOrderId()
                );
                return;
            }
        }

        // Display complete bill
        OrderService service = new OrderService();
        service.displayBill(orders);
    }
}
