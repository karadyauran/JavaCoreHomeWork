package org.example.recGA7L9vGkhVRtif;

import java.util.LinkedList;
import java.util.Queue;

public class LogisticsCenter {
  private Queue<Order> orders = new LinkedList<>();

  private synchronized void addOrder(Order order) {
    System.out.println("Заказ был отправлен в логистический центр");
    orders.add(order);
  }

  private void sendOrder() {
    System.out.println("Заказ был обработан логистическим центром");
    if (!orders.isEmpty()) orders.poll().changeStatus(Status.SHIPPED);
  }
}
