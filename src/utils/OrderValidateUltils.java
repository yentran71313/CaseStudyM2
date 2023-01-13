package utils;

import tools.FoodManager;

import java.util.Scanner;

public class OrderValidateUltils {
    static Scanner input = new Scanner(System.in);

    public static double inputPrice() {
        double price = 0;
        boolean checkPrice = false;
        do {
            try {
                System.out.println("Nhập giá vật phẩm (Giá phải lớn hơn 5000 VNĐ, Ví dụ : 6000) : ");
                price = Double.parseDouble(input.nextLine());
                if (price < 5000) {
                    checkPrice = true;
                    System.out.println("Số tiền quá thấp vui lòng nhập lại!!");
                } else {
                    checkPrice = false;
                }
            }catch (Exception e){
                System.out.println("Không được nhập kí tự, vui lòng nhập lại!! (Ví dụ: 20000)");
                checkPrice = true;
            }

        } while (checkPrice);
        return price;
    }

    public static String inputFoodName() {
        String foodName = "";
        boolean checkFoodName = false;
        do {
            System.out.println("Nhập tên Món Ăn (Ví dụ Bún Bò Huế) : ");
            foodName = input.nextLine();
            if (!ValidateUltils.isNameValid(foodName)) {
                checkFoodName = true;
                System.out.println("Tên chưa đúng định dạng vui lòng nhập lại!!");
            } else if (FoodManager.checkNameInTheList(foodName)) {
                System.out.println("Tên món ăn đã có, vui lòng nhập lại !!");
                checkFoodName = true;
//                FoodManager.addFood();
            } else {
                checkFoodName = false;
            }
        } while (checkFoodName);
        return foodName;
    }

    public static Integer inputQuantity() {
        int quantity = 0;
        boolean checkQuantity = false;
            do {
                try {
                    System.out.println("Nhập số lượng vật phẩm (không được < 1):");
                    quantity = Integer.parseInt(input.nextLine());
                    if (quantity < 1) {
                        System.out.println("Số lượng không đúng quy định, vui lòng nhập lại!!");
                    } else {
                        checkQuantity = false;
                    }
                }catch (Exception e){
                    System.out.println("Không nhập kí tự, vui lòng nhập lại!! (Ví dụ: 45");
                    checkQuantity = true;
                }
            } while (checkQuantity);
        return quantity;
    }
}
