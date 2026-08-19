package food.model;

public class PremiumOrder extends FoodOrder implements Discountable {

    private static final double DELIVERY_CHARGE = 50.0;
    private static final double DISCOUNT_RATE = 0.15;

    public PremiumOrder(int orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    // Method overriding
    @Override
    public double calculateDeliveryCharge() {
        return DELIVERY_CHARGE;
    }

    // Method overriding
    @Override
    public double applyDiscount() {
        return getAmount() * DISCOUNT_RATE;
    }
}
