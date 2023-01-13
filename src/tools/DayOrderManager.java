package tools;

import models.AllOrder;
import models.DayOrder;
import utils.InstantUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOrderManager {
    public List<AllOrder> allOrders;
    private final static String PATCH_DAYORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\DayOrder.csv";

    public static List<DayOrder> findAll() {
        List<DayOrder> dayOrders = new ArrayList<>();
        List<String> lines = ReadFifeandWriteFile.read(PATCH_DAYORDER);
        for (String line : lines) {
            dayOrders.add(DayOrder.ParseDayOrder(line));
        }
        return dayOrders;
    }

    public void renderAllOrder() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋ALL-ORDER㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-16s %-15s %-15s %-15s %-15s %-15s  %-15s %-15s %-15s %-16s %s\n\n","ID Order", "Tên Khách Hàng","Số Điện Thoại","Địa Chỉ", "ID Sản Phẩm", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "Thành Tiền", "Ngày Xuất Đơn", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_DAYORDER));
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
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
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

    public static void printMenu(List<String> dayOrder) {
        System.out.printf("\n\t%-16s %-15s %-15s %-15s %-15s %-15s  %-15s %-15s %-15s %-16s %s\n",dayOrder.get(0),dayOrder.get(1),dayOrder.get(2),dayOrder.get(3), dayOrder.get(4), dayOrder.get(5), InstantUtils.doubleToVND(Double.parseDouble(dayOrder.get(6))), dayOrder.get(7), InstantUtils.doubleToVND(Double.parseDouble(dayOrder.get(8))), InstantUtils.instantToString(Instant.parse(dayOrder.get(9))), "㊋");
    }

    public void SortByDayOrder() {
        List<AllOrder> allorders = AllOrderManager.findAll();
        List<DayOrder> dayOrders = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập ngày muốn tìm kiếm (Ví dụ: 16-12-2022)");
        String day = input.nextLine();
        Long idCustomer;
        String nameCustomer;
        String phone;
        String address;
        Long iditem;
        String nameFood;
        double price;
        int quantity;
        Double total;
        Instant createAt;
        int count = 0;
        for (AllOrder allOrder : allorders) {
            if (InstantUtils.instantToString((allOrder.getCreateAt())).equals(day)) {
                idCustomer = allOrder.getIdCustomer();
                nameCustomer = allOrder.getNameCustomer();
                phone = allOrder.getPhone();
                address = allOrder.getAddress();
                iditem = allOrder.getIditem();
                nameFood = allOrder.getNameFood();
                price = allOrder.getPrice();
                quantity = allOrder.getQuantity();
                total = allOrder.getTotal();
                createAt = allOrder.getCreateAt();
                DayOrder dayOrder = new DayOrder(idCustomer,nameCustomer,phone,address,iditem, nameFood, price, quantity, total, createAt);
                dayOrders.add(dayOrder);
                count++;
                ReadFifeandWriteFile.write(PATCH_DAYORDER, dayOrders);
            }
        }
        if (count == 0) {
            System.out.println("Ngày không đúng , vui lòng nhập lại!!");
            return;
        }
        renderAllOrder();

    }
    public static Double totalDayPrice() {
        List<DayOrder> dayOrderList = findAll();
        Double totalAllPirce = Double.valueOf(0);
        for (DayOrder dayOrderItem : dayOrderList) {
            totalAllPirce += dayOrderItem.getTotal();
        }
        return totalAllPirce;
    }
}

