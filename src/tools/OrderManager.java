package tools;

import models.Order;

import utils.InstantUtils;
import utils.UserValidateUltils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager {
    public List<Order> orders;
    private final static String PATCH_ODER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\Order.csv";

    public OrderManager() {
        List<Order> orderList = new ArrayList<>();
        this.orders = orderList;
    }

    public static List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> lines = ReadFifeandWriteFile.read(PATCH_ODER);
        for (String line : lines) {
            orders.add(Order.parseOrder(line));
        }
        return orders;
    }

    public void renderOder() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋CUSTOMER㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_ODER));
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

    public static void printMenu(List<String> Order) {
        System.out.println("ID Người Mua: " + Order.get(0));
        System.out.println("Tên người mua: " + Order.get(1));
        System.out.println("Số điện thoại: " + Order.get(2));
        System.out.println("Địa chỉ: " + Order.get(3));
        System.out.println("Ngày và Giờ Mua Hàng: " + InstantUtils.instantToString(Instant.parse(Order.get(4))));
    }


    public void addOrder() {
        List<Order> orderPersons = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Long id = System.currentTimeMillis() / 1000;
        String fullName = UserValidateUltils.inputFullName();
        String phone = UserValidateUltils.inputPhone();
        System.out.println("Nhập địa chỉ người mua hàng: ");
        String address = input.nextLine();
        Order newOrder = new Order(id, fullName, phone, address);
        newOrder.setCreateAt(Instant.now());
        orderPersons.add(newOrder);
        ReadFifeandWriteFile.write(PATCH_ODER, orderPersons);
    }

}
