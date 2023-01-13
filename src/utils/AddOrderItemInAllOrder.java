package utils;

import tools.AllOrderManager;
import tools.OrderItemManager;
import tools.OrderManager;
import tools.ReadFifeandWriteFile;
import models.AllOrder;
import models.Order;
import models.OrderItem;

import java.time.Instant;
import java.util.List;

public class AddOrderItemInAllOrder {
    private final static String PATCH_ALLORDER = "C:\\Users\\Admin\\Downloads\\CSModule2-main\\data\\AllOrder.csv";
   public void AddOrderItemInAllOrder(){
       List<OrderItem> orderItemList = OrderItemManager.findAll();
       List<Order> orderList = OrderManager.findAll();
       for(Order order: orderList) {
           for (OrderItem orderitem : orderItemList) {
               Instant createAt = Instant.now();
               List<AllOrder> allOrders = AllOrderManager.findAll();
               AllOrder allOrder = new AllOrder(order.getId(),order.getFullName(),order.getPhone(),order.getAddress(),orderitem.getId(), orderitem.getNameFood(), orderitem.getPrice(), orderitem.getQuantity(), orderitem.getTotal(), createAt);
               allOrders.add(allOrder);
               ReadFifeandWriteFile.write(PATCH_ALLORDER, allOrders);
           }
       }
    }
}
