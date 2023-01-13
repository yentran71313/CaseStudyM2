package tools;

import models.AllOrder;
import utils.InstantUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AllOrderManager {
    public List<AllOrder> allOrders;
    private final static String PATCH_ALLORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\AllOrder.csv";

    public static List<AllOrder> findAll() {
        List<AllOrder> allOders = new ArrayList<>();
        List<String> lines = ReadFifeandWriteFile.read(PATCH_ALLORDER);
        for (String line : lines) {
            allOders.add(AllOrder.ParseAllOrder(line));
        }
        return allOders;
    }

    public void renderAllOrder() {
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋ALL-ORDER㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s  %-20s %-20s %-20s %-20s %s\n\n","ID Order", "Tên Khách Hàng","Số Điện Thoại","Địa Chỉ", "ID Sản Phẩm", "Tên Món Ăn", "Giá Tiền", "Số Lượng", "Thành Tiền", "Ngày Xuất Đơn", "㊋");
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(PATCH_ALLORDER));
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
        System.out.println("㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋㊋");
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

    public static void printMenu(List<String> AllOder) {
        System.out.printf("\n\t%-20s %-20s %-20s %-20s %-20s %-20s  %-20s %-20s %-20s %-20s %s\n",AllOder.get(0),AllOder.get(1),AllOder.get(2),AllOder.get(3), AllOder.get(4), AllOder.get(5), InstantUtils.doubleToVND(Double.parseDouble(AllOder.get(6))), AllOder.get(7), InstantUtils.doubleToVND(Double.parseDouble(AllOder.get(8))), InstantUtils.instantToString(Instant.parse(AllOder.get(9))), "㊋");
    }
    public static Double totalAllPrice() {
        List<AllOrder> allOrderList = findAll();
        Double totalAllPirce = Double.valueOf(0);
        for (AllOrder allOrderItem : allOrderList) {
            totalAllPirce += allOrderItem.getTotal();
        }
        return totalAllPirce;
    }
}
