import java.util.ArrayList;
import java.util.List;
abstract class Product {
    protected String productId;
    protected String name;
    protected double price;
    protected String category;
    public Product(String productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
}
class ElectronicProduct extends Product {
    private String imei;
    private String warrantyPeriod;
    public ElectronicProduct(String productId, String name, double price, String imei, String warrantyPeriod) {
        super(productId, name, price, "Electronic");
        this.imei = imei;
        this.warrantyPeriod = warrantyPeriod;
    }
    public String getImei() {
        return imei;
    }
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }
}
class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String productId, String name, double price, String expiryDate) {
        super(productId, name, price, "Food");
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
interface PaymentMethod {
    void pay(double amount);
}
class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt thành công. Số tiền: " + amount);
    }
}
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng thành công. Số tiền: " + amount);
    }
}
class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua ví điện tử Momo thành công. Số tiền: " + amount);
    }
}
class Order {
    private String customerName;
    private List<Product> products;
    private double totalAmount;
    private PaymentMethod paymentMethod;

    public Order(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        if (paymentMethod != null) {
            System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + totalAmount + ". ");
            paymentMethod.pay(totalAmount);
        } else {
            System.out.println("Chưa chọn phương thức thanh toán.");
        }
    }
}
class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua PayPal thành công. Số tiền: " + amount);
    }
}
public class quanLyThanhToan {
    public static void main(String[] args) {
        Product product1 = new ElectronicProduct("E001", "Smartphone", 500, "123456789012345", "12 months");
        Product product2 = new FoodProduct("F001", "Pizza", 15, "2025-10-08");
        Order order = new Order("Nguyen Van A");
        order.addProduct(product1);
        order.addProduct(product2);
        PaymentMethod paymentMethod = new PayPalPayment();
        order.setPaymentMethod(paymentMethod);
        order.checkout();
    }
}