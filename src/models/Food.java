package models;

import java.io.Serializable;

public class Food implements Comparable<Food>, Serializable {
    private Long id;
    private String foodName;
    private double price;
    private int quantity;

    public Food() {
    }

    public Food(Long id, String foodName, double price, int quantity) {
        this.id = id;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
        return id +
                "," + foodName +
                "," + price +
                "," + quantity;
    }

    public static Food parseFood(String raw) {
        Food food = new Food();
        String[] fields = raw.split(",");
        food.id = Long.parseLong(fields[0]);
        food.foodName = fields[1];
        food.price = Double.parseDouble(fields[2]);
        food.quantity = Integer.parseInt(fields[3]);

        return food;
    }

    @Override
    public int compareTo(Food food) {
        return this.getFoodName().compareTo(food.getFoodName());
    }
}
