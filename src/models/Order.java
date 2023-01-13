package models;

import java.time.Instant;

public class Order {
    private Long id;
    private String fullName;
    private String phone;
    private String address;
    private Instant createAt;

    public Order() {
    }

    public Order(Long id, String fullName, String phone, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    public Order(Long id, String fullName, String phone, String address, Instant createAt) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public static Order parseOrder(String raw) {
        Order order = new Order();
        String[] fields = raw.split(",");
        order.id = Long.parseLong(fields[0]);
        order.fullName = fields[1];
        order.phone = fields[2];
        order.address = fields[3];
        order.createAt = Instant.parse(fields[4]);
        return order;
    }

    public String toString() {
        return String.format("%d,%s,%s,%s,%s", id, fullName, phone, address, createAt);
    }
}
