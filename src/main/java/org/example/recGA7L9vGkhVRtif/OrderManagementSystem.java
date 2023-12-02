package org.example.recGA7L9vGkhVRtif;

import java.util.ArrayList;
import java.util.List;

public class OrderManagementSystem {
  private final List<OrderProcessor> processors;
  private volatile boolean isWorking = false;
  private List<Order> orders;

  public OrderManagementSystem(List<OrderProcessor> processors, List<Order> orders) {
    this.processors = processors;
    this.orders = orders;
  }

  private synchronized void distributeOrders() {
    System.out.println("Запуск системы...");
    if (isWorking) {
      if (!orders.isEmpty()) {
        int processor = 0;
        for (Order order : orders) {
          OrderProcessor orderProcessor = processors.get(processor);
          orderProcessor.addOrder(order);
          order.changeStatus(Status.PROCESSED);
          processor++;
          if (processor >= processors.size()) processor = 0;
        }
      }
    }
    orders = new ArrayList<>();
  }

  public void startWorking() {
    System.out.println("Система работает");
    isWorking = true;
    distributeOrders();
  }

  public void stopWorking() {
    System.out.println("Система НЕ работает");
    isWorking = false;
  }
}
