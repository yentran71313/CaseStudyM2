package models;

import java.time.Instant;

public class User {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String role;
    private Instant createdAt;

    public User() {
    }

    public User(Long id, String username, String password, String fullName, String phone, String email, String address, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public User(Long id, String username, String password, String fullName, String phone, String email, String address, String role, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
    }

    public static User parseUser(String raw) {
        User user = new User();
        String[] fields = raw.split(",");
        user.id = Long.parseLong(fields[0]);
        user.username = fields[1];
        user.password = fields[2];
        user.fullName = fields[3];
        user.phone = fields[4];
        user.email = fields[5];
        user.address = fields[6];
        user.role = fields[7];
        user.createdAt = Instant.parse(fields[8]);
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s", id, username, password, fullName, phone, email, address,role, createdAt);
    }
}
