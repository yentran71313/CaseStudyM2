package tools;

import models.*;
import utils.InstantUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SaveUserManager {
    private final static String PATCH_SAVEUSER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\SaveUser.csv";
    private final static String PATCH_ALLORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\AllOrder.csv";
    public static List<SaveUser> findAll() {
        List<SaveUser> saveUsers = new ArrayList<>();
        List<String> lines = ReadFifeandWriteFile.read(PATCH_SAVEUSER);
        for (String line : lines) {
            saveUsers.add(SaveUser.parseSaveUsser(line));
        }
        return saveUsers;
    }
    public static void renderSaveUser() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋CUSTOMER㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_SAVEUSER));
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

    public static void printMenu(List<String> saveUser) {
        System.out.println("ID Người Mua: " + saveUser.get(0));
        System.out.println("Tên người mua: " + saveUser.get(1));
        System.out.println("Số điện thoại: " + saveUser.get(2));
        System.out.println("Địa chỉ: " + saveUser.get(3));
        System.out.println("Ngày và Giờ Mua Hàng: " + InstantUtils.instantToString(Instant.parse(saveUser.get(4))));
    }

    public static void AddOrderItemInAllOrderUser(){
        List<OrderItem> orderItemList = OrderItemManager.findAll();
        List<SaveUser> saveUserList = findAll();
        for(SaveUser saveUser: saveUserList) {
            for (OrderItem orderitem : orderItemList) {
                Instant createAt = Instant.now();
                List<AllOrder> allOrders = AllOrderManager.findAll();
                AllOrder allOrder = new AllOrder(saveUser.getId(),saveUser.getFullName(),saveUser.getPhone(),saveUser.getAddress(),orderitem.getId(), orderitem.getNameFood(), orderitem.getPrice(), orderitem.getQuantity(), orderitem.getTotal(), createAt);
                allOrders.add(allOrder);
                ReadFifeandWriteFile.write(PATCH_ALLORDER, allOrders);
            }
        }
    }
}
