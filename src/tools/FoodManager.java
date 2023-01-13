package tools;

import models.Food;
import utils.InstantUtils;
import utils.OrderValidateUltils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FoodManager {
    public List<Food> foods;
    private final static String PATCH_MENU = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\FoodMenu.csv";

    public FoodManager() {
        List<Food> foodList = new ArrayList<>();
        this.foods = foodList;

    }

    public static List<Food> findAll() {
        List<Food> foods = new ArrayList<>();
        List<String> lines = ReadFifeandWriteFile.read(PATCH_MENU);
        for (String line : lines) {
            foods.add(Food.parseFood(line));
        }
        return foods;
    }

    public boolean checkFoodsInTheList(Food food) {
        if (!foods.isEmpty()) {
            for (Food foods : foods) {
                if (food == foods)
                    return true;
            }
        }
        return false;
    }

    //    public boolean checkIDInTheList(Long id){
//        if(!foodList.isEmpty()){
//            for(Food foods: foodList){
//                if(foods.getId() == id){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static boolean checkNameInTheList(String name) {
        List<Food> foods = findAll();
        if (!foods.isEmpty()) {
            for (Food dish : foods) {
                String tamp = dish.getFoodName();
                if (tamp.equals(name))
                    return true;
            }

        }
        return false;
    }


    public static void addFood() {
        List<Food> foods = findAll();
        Scanner input = new Scanner(System.in);
        renderFood();
        Long id = System.currentTimeMillis() / 1000;
        String name = OrderValidateUltils.inputFoodName();
        int quantity = OrderValidateUltils.inputQuantity();
        double price = OrderValidateUltils.inputPrice();
        Food newFood = new Food(id, name, price, quantity);
        foods.add(newFood);
        ReadFifeandWriteFile.write(PATCH_MENU, foods);
        renderFood();
        System.out.println("Đã thêm thành công!!");
        return;
    }

    public static void renderFood() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋MENU㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_MENU));
            while ((line = br.readLine()) != null) {
                printMenu(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void printMenu(List<String> FoodMenu) {
        System.out.printf("\n\t%-16s %-36s %-26s %-10s %s\n", FoodMenu.get(0), FoodMenu.get(1),InstantUtils.doubleToVND(Double.parseDouble(FoodMenu.get(2))) , FoodMenu.get(3), "㊋");
    }


    public void editFood() {
        renderFood();
        List<Food> foods = findAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập y nếu muốn chỉnh sửa hoặc nhập b để quay lại menu chính: ");
        String choice = input.nextLine();
        switch (choice) {
            case "y":
                System.out.println("Nhập ID Muốn chỉnh sửa:  ");
                Long id = Long.parseLong(input.nextLine());
                int count = 0;
                for (Food dish : foods) {
                    Long tamp = dish.getId();
                    if (tamp.equals(id)) {
//                        foods.remove(dish);
                        String name = OrderValidateUltils.inputFoodName();
                        double price = OrderValidateUltils.inputPrice();
                        int quatity = OrderValidateUltils.inputQuantity();
                        dish.setFoodName(name);
                        dish.setPrice(price);
                        dish.setQuantity(quatity);
                        dish.setId(id);
                        count++;
                        ReadFifeandWriteFile.write(PATCH_MENU, foods);
                        renderFood();
                        break;
                    }
                }
                if (count == 0) {
                    System.out.println("ID không tồn tại vui lòng nhập lại!");
                    editFood();
                }
                break;
            case "b":
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                editFood();
        }
    }


    public void deleteFood() {
        List<Food> foods = findAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập y nếu muốn xóa hoặc nhập b để quay lại menu chính: ");
        String choice = input.nextLine();
        switch (choice) {
            case "y":
                renderFood();
                System.out.println("Nhập id muốn xóa : ");
                Long id = Long.parseLong(input.nextLine());
                int count = 0;
                for (Food dished : foods) {
                    Long tamp = dished.getId();
                    if (tamp.equals(id)) {
                        System.out.println("Bạn chắc chắn muốn xóa id :" + id + " Bấm y để đồng ý hoặc b để trở lại menu chính");
                        choice = input.nextLine();
                        switch (choice) {
                            case "y":
                                foods.remove(dished);
                                count++;
                                ReadFifeandWriteFile.write(PATCH_MENU, foods);
                                renderFood();
                                return;
                            case "b":
                                return;
                            default:
                                System.out.println("vui lòng nhập lại!!");
                                deleteFood();

                        }
                    }
                }
                if (count == 0) {
                    System.out.println("Id Không tồn tại vui lòng nhập lại");
                    deleteFood();
                    break;
                }

                break;
            case "b":
                break;
            default:
                System.out.println("Vui Lòng Nhập Lại!");
                deleteFood();
        }

    }

    public void findFoodName() {
        List<Food> foods = findAll();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String name = input.nextLine();
        int count = 0;
        System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng");
        for (Food dish : foods) {
            if (dish.getFoodName().toUpperCase().contains(name.toUpperCase())) {
                System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", dish.getId(), dish.getFoodName(), dish.getPrice(), dish.getQuantity());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Món ăn không có trong menu!!");
            return;
        }
    }

    public void sortAscending() {
        List<Food> fooditem = findAll();
        fooditem.sort((food1, food2) -> Double.compare((double) food1.getPrice(), (double) food2.getPrice()));
        System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng");
        for (Food dish : fooditem
        ) {
            System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", dish.getId(), dish.getFoodName(), dish.getPrice(), dish.getQuantity());
        }
    }


    public void sortDescending() {
        List<Food> fooditem = findAll();
        fooditem.sort((food1, food2) -> Double.compare((double) food2.getPrice(), (double) food1.getPrice()));
        System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", "ID", "Tên Món Ăn", "Giá Tiền", "Số Lượng");
        for (Food dish : fooditem
        ) {
            System.out.printf("\n\t%-16s %-36s %-26s %s\n\n", dish.getId(), dish.getFoodName(), dish.getPrice(), dish.getQuantity());
        }
    }
}


