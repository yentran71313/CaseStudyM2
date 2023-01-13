package surface;

import login.RoleLogin;
import tools.*;
import utils.AddOrderItemInAllOrder;
import utils.BackMeNuOrExit;
import utils.TotalPrice;

import java.util.Scanner;

public class OptionAdmin {

    private final static String PATCH_ALLORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\AllOrder.csv";
    static AddOrderItemInAllOrder addOrderItemInAllOrder = new AddOrderItemInAllOrder();
    static BackMeNuOrExit backMeNuOrExit = new BackMeNuOrExit();
    static TotalPrice totalPrice = new TotalPrice();
    public static void optionAdmin() {
         int choice = -1;
        while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" " + "        " + "1. Quản lí Thực Đơn" + "              " + "  ");
            System.out.println(" " + "        " + "2. Quản lí đơn đặt hàng" + "          " + "  ");
            System.out.println(" " + "        " + "0. Thoát" + "                         " + "  ");
            System.out.println("Vui lòng nhập lựa chọn của bạn :");
            System.out.printf("==>");
            choice = Integer.parseInt(scanner.nextLine());
            RenderList renderList = new RenderList();
            switch (choice) {
                case 1:
                    renderList.renderMenuManager();
                    FoodManager foodManager = new FoodManager();
                    System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                    System.out.printf("==>");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            foodManager.renderFood();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;

                        case 2:
                            foodManager.addFood();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 3:
                            foodManager.deleteFood();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 4:
                            foodManager.editFood();
                            backMeNuOrExit.BackMeNuOrExitAdmin();

                            break;
                        case 5:
                            foodManager.findFoodName();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 6:
                            foodManager.sortAscending();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 7:
                            foodManager.sortDescending();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 8:
                            OptionAdmin.optionAdmin();
                            break;
                        case 0:
                            System.out.println("Hẹn Gặp Lại!!!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui Lòng Nhập Lại!");
                            choice = 1;
                    }
                    break;
                case 2:
                    renderList.renderOrderManager();
                    OrderManager orderManager = new OrderManager();
                    OrderItemManager orderItemManager = new OrderItemManager();
                    AllOrderManager allOrderManager = new AllOrderManager();
                    DayOrderManager dayOrderManager = new DayOrderManager();
                    System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                    System.out.printf("==>");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1: //hiển thị tổng oder
                            allOrderManager.renderAllOrder();
                            totalPrice.TotalAllOrderPrice();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 2: // hiển thị order theo ngày
                            dayOrderManager.SortByDayOrder();
                            totalPrice.TotalDayPrice();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 3: //thêm đơn đặt hàng
                            orderManager.addOrder();
                            orderItemManager.addOrderItem();
                            orderManager.renderOder();
                            orderItemManager.renderOrderItem();
                            totalPrice.TotalOrderItemPrice();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            backMeNuOrExit.BackMeNuOrExitAdmin();
                            break;
                        case 4:// sửa đơn đặt hàng
                            orderItemManager.editOrderItem();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
                            System.out.printf("==>");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    orderManager.renderOder();
                                    orderItemManager.renderOrderItem();
                                    totalPrice.TotalOrderItemPrice();
                                    backMeNuOrExit.BackMeNuOrExitAdmin();
                                    break;
                                case 2:
                                    OptionAdmin.optionAdmin();
                                    break;
                                case 0:
                                    System.out.println("Hẹn Gặp Lại!!!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Vui Lòng Nhập Lại!");
                                    System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
                                    System.out.printf("==>");
                                    choice = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 5: //xóa đơn đặt hàng
                            orderItemManager.deleteOrderItem();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
                            System.out.printf("==>");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    orderManager.renderOder();
                                    orderItemManager.renderOrderItem();
                                    totalPrice.TotalOrderItemPrice();
                                    backMeNuOrExit.BackMeNuOrExitAdmin();
                                    break;
                                case 2:
                                    OptionAdmin.optionAdmin();
                                    break;
                                case 0:
                                    System.out.println("Hẹn Gặp Lại!!!");
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Vui Lòng Nhập Lại!");
                                    System.out.println("Nhấn 1 để in hóa đơn hoặc 0 để order tiếp ");
                                    System.out.printf("==>");
                                    choice = Integer.parseInt(scanner.nextLine());
                            }
                            break;
                        case 6:
                            OptionAdmin.optionAdmin();
                            break;
                        case 0:
                            System.out.println("Hẹn Gặp Lại!!!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui Lòng Nhập Lại!");
                            choice = 3;
                    }
                    break;
                case 0:
                    System.out.println("Hẹn Gặp Lại!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui Lòng Nhập Lại!");
                    OptionAdmin.optionAdmin();

            }
        }
    }
}

