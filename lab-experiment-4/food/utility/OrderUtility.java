package food.utility;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderUtility {

    // Validate amount
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    // Validate customer name
    public static boolean validateCustomerName(String customerName) {
        return customerName != null
                && !customerName.trim().isEmpty()
                && customerName.matches("[a-zA-Z ]+");
    }

    // Generate order summary
    public static void generateOrderSummary(FoodOrder order) {

        double billAmount = order.getAmount();
        double discount = 0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = billAmount - discount + deliveryCharge;

        System.out.println("----------------------------------------");
        order.displayOrderDetails();

        System.out.printf("Discount     : Rs. %.2f%n", discount);
        System.out.printf("Delivery     : Rs. %.2f%n", deliveryCharge);
        System.out.printf("Final Payable: Rs. %.2f%n", finalAmount);
        System.out.println("----------------------------------------");
    }
}
