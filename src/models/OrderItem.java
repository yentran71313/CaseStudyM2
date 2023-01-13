package models;

public class OrderItem {
    private Long id;
    private double price;
    private int quantity;
    private String nameFood;
    private Double total;

    public OrderItem(Long id, String nameFood, Double price, int quantity, Double total) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.nameFood = nameFood;
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public OrderItem() {
    }

    public static OrderItem parseOrderItem(String raw) {
        OrderItem orderItem = new OrderItem();
        String[] fields = raw.split(",");
        orderItem.id = Long.parseLong(fields[0]);
        orderItem.nameFood = fields[1];
        orderItem.price = Double.parseDouble(fields[2]);
        orderItem.quantity = Integer.parseInt(fields[3]);
        orderItem.total = Double.parseDouble(fields[4]);
        return orderItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s", id, nameFood, price, quantity, total);
    }
}
