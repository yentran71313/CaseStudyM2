package models;

import java.time.Instant;


public class AllOrder {
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

    public AllOrder() {
    }

    public AllOrder(Long idCustomer, String nameCustomer, String phone, String address, Long iditem, String nameFood, double price, int quantity, Double total, Instant createAt) {
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
    //    public AllOrder(Long idOrder,String nameCustomer,String phone,String address ,Long iditem, String nameFood, double price, int quantity, Double total, Instant createAt) {
//        this.id = id;
//        this.nameFood = nameFood;
//        this.price = price;
//        this.quantity = quantity;
//        this.total = total;
//        this.createAt = createAt;
//    }

    public static AllOrder ParseAllOrder(String raw) {
        AllOrder allOrder = new AllOrder();
        String[] fields = raw.split(",");
        allOrder.idCustomer = Long.parseLong(fields[0]);
        allOrder.nameCustomer = fields[1];
        allOrder.phone = fields[2];
        allOrder.address = fields[3];
        allOrder.iditem = Long.parseLong(fields[4]);
        allOrder.nameFood = fields[5];
        allOrder.price = Double.parseDouble(fields[6]);
        allOrder.quantity = Integer.parseInt(fields[7]);
        allOrder.total = Double.parseDouble(fields[8]);
        allOrder.createAt = Instant.parse(fields[9]);
        return allOrder;
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

    public void setIditem(Long iditem) {
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
