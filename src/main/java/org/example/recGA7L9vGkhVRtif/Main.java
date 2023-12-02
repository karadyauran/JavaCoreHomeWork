package org.example.recGA7L9vGkhVRtif;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Order o1 = new Order();
    Order o2 = new Order();
    Order o3 = new Order();
    Order o4 = new Order();

    List<Order> orders = List.of(o1, o2, o3, o4);

    OrderProcessor op1 = new OrderProcessor();
    OrderProcessor op2 = new OrderProcessor();

    List<OrderProcessor> orderProcessors = List.of(op1, op2);
    OrderManagementSystem orderManagementSystem = new OrderManagementSystem(orderProcessors, orders);
    orderManagementSystem.startWorking();

    System.out.println(op1.getOrders());
    System.out.println(op2.getOrders());
  }
}
