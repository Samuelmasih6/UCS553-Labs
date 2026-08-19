package food.model;

public abstract class FoodOrder {

    private int orderId;
    private String customerName;
    private double amount;

    // Static member
    private static String restaurantName = "Food Express";

    // Static object counter
    private static int orderCounter = 0;

    // Constructor
    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCounter++;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Static getter
    public static String getRestaurantName() {
        return restaurantName;
    }

    // Static setter
    public static void setRestaurantName(String restaurantName) {
        FoodOrder.restaurantName = restaurantName;
    }

    // Static method
    public static void displayTotalOrders() {
        System.out.println("Total Orders Created: " + orderCounter);
    }

    // Abstract method
    public abstract double calculateDeliveryCharge();

    // Display order details
    public void displayOrderDetails() {
        System.out.println("Restaurant   : " + restaurantName);
        System.out.println("Order ID     : " + orderId);
        System.out.println("Customer     : " + customerName);
        System.out.printf("Bill Amount  : Rs. %.2f%n", amount);
    }
}
