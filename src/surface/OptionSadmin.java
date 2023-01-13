package surface;

import tools.*;
import models.Order;
import models.OrderItem;
import utils.AddOrderItemInAllOrder;
import utils.BackMeNuOrExit;
import utils.TotalPrice;

import java.util.List;
import java.util.Scanner;

public class OptionSadmin {
    private final static String PATCH_ALLORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\AllOrder.csv";
    static AddOrderItemInAllOrder addOrderItemInAllOrder = new AddOrderItemInAllOrder();
    static BackMeNuOrExit backMeNuOrExit = new BackMeNuOrExit();
    static TotalPrice totalPrice = new TotalPrice();
    public static void optionSadmin() {

        int choice = -1;
        while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" " + "        " + "1. Quản Lí Thực Đơn" + "              " + "  ");
            System.out.println(" " + "        " + "2. Quản Lí Người Dùng" + "            " + "  ");
            System.out.println(" " + "        " + "3. Quản Lí Đơn Đặt Hàng" + "          " + "  ");
            System.out.println(" " + "        " + "0. Thoát" + "                         " + "  ");
            System.out.println(" " + "                                         " + "  ");
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
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;

                        case 2:
                            foodManager.addFood();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 3:
                            foodManager.deleteFood();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 4:
                            foodManager.editFood();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 5:
                            foodManager.findFoodName();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 6:
                            foodManager.sortAscending();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 7:
                            foodManager.sortDescending();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 8:
                            OptionSadmin.optionSadmin();
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
                    renderList.renderUserManager();
                    UserManager user = new UserManager();
                    System.out.println("Vui lòng nhập lựa chọn của bạn: ");
                    System.out.printf("==>");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            UserManager.addUser();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 2:
                            user.editUser();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 3:
                            UserManager.renderUser();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 4:
                            user.deleteUser();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 5:
                            OptionSadmin.optionSadmin();
                            break;
                        case 0:
                            System.out.println("Hẹn Gặp Lại!!!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Vui Lòng Nhập Lại!");
                            choice = 2;
                    }
                    break;
                case 3:
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
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 2: // hiển thị order theo ngày
                            dayOrderManager.SortByDayOrder();
                            totalPrice.TotalDayPrice();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
                            break;
                        case 3: //thêm đơn đặt hàng
                            orderManager.addOrder();
                            orderItemManager.addOrderItem();
                            orderManager.renderOder();
                            orderItemManager.renderOrderItem();
                            totalPrice.TotalOrderItemPrice();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            backMeNuOrExit.BackMeNuOrExitSadmin();
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
                                    backMeNuOrExit.BackMeNuOrExitSadmin();
                                    break;
                                case 2:
                                    OptionSadmin.optionSadmin();
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
                            List<OrderItem> orderItemListDelete = OrderItemManager.findAll();
                            List<Order> orderListDelete = OrderManager.findAll();
                            addOrderItemInAllOrder.AddOrderItemInAllOrder();
                            System.out.println("Nhấn 1 để in hóa đơn hoặc 2 để về menu chính và 0 để thoát !! ");
                            System.out.printf("==>");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    orderManager.renderOder();
                                    orderItemManager.renderOrderItem();
                                    totalPrice.TotalOrderItemPrice();
                                    backMeNuOrExit.BackMeNuOrExitSadmin();
                                    break;
                                case 2:
                                    OptionSadmin.optionSadmin();
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
                            OptionSadmin.optionSadmin();
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
                    OptionSadmin.optionSadmin();

            }
        }
    }
}

