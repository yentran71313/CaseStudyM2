package models;

import java.time.Instant;

public class DayOrder {
    private Long idCustomer;
    private String nameCustomer;
    private String phone;
    private String address;
    private Long iditem;
    private String nameFood;
    private double price;
    private int quantity;
    private Double total;
    private Instant createAt;

    public DayOrder() {
    }

    public DayOrder(Long idCustomer, String nameCustomer, String phone, String address, Long iditem, String nameFood, double price, int quantity, Double total, Instant createAt) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phone = phone;
        this.address = address;
        this.iditem = iditem;
        this.nameFood = nameFood;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.createAt = createAt;
    }

    public static DayOrder ParseDayOrder(String raw) {
        DayOrder dayOrder = new DayOrder();
        String[] fields = raw.split(",");
        dayOrder.idCustomer = Long.parseLong(fields[0]);
        dayOrder.nameCustomer = fields[1];
        dayOrder.phone = fields[2];
        dayOrder.address = fields[3];
        dayOrder.iditem = Long.parseLong(fields[4]);
        dayOrder.nameFood = fields[5];
        dayOrder.price = Double.parseDouble(fields[6]);
        dayOrder.quantity = Integer.parseInt(fields[7]);
        dayOrder.total = Double.parseDouble(fields[8]);
        dayOrder.createAt = Instant.parse(fields[9]);
        return dayOrder;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long id) {
        this.iditem = iditem;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s",idCustomer,nameCustomer,phone,address, iditem, nameFood, price, quantity, total, createAt);
    }

}
