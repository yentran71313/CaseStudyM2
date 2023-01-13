package models;

import java.time.Instant;

public class SaveUser {
    private Long id;
    private String fullName;
    private String phone;
    private String address;
    private Instant createAt;

    public SaveUser() {
    }

    public SaveUser(Long id, String fullName, String phone, String address, Instant createAt) {
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
    public static SaveUser parseSaveUsser(String raw) {
        SaveUser saveUser = new SaveUser();
        String[] fields = raw.split(",");
        saveUser.id = Long.parseLong(fields[0]);
        saveUser.fullName = fields[1];
        saveUser.phone = fields[2];
        saveUser.address = fields[3];
        saveUser.createAt = Instant.parse(fields[4]);
        return saveUser;
    }
    public String toString() {
        return String.format("%d,%s,%s,%s,%s", id, fullName, phone, address, createAt);
    }
}
