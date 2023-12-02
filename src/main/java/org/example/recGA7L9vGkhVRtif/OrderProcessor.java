package org.example.recGA7L9vGkhVRtif;

import java.util.LinkedList;
import java.util.Queue;

public class OrderProcessor {
  private final Queue<Order> orders = new LinkedList<>();

  public Queue<Order> getOrders() {
    return orders;
  }

  public synchronized void addOrder(Order order) {
    System.out.println("Заказ добавлен в очередь");
    orders.add(order);
  }

  public synchronized Order removeOrder(Order order) {
    System.out.println("Заказ был извлечен из очереди");
    return orders.poll();
  }
}
