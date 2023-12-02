package org.example.recGA7L9vGkhVRtif;

import java.util.List;

public class Order {
  private static int globalID = 0;
  private int id;
  private Status status;
  private List<Product> productList;

  public Order() {
    this.id = ++globalID;
    this.status = Status.PROCESSING;
  }

  public void addProduct(Product product) {
    productList.add(product);
  }

  public void changeStatus(Status newStatus) {
    this.status = newStatus;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", status=" + status +
            ", productList=" + productList +
            '}';
  }
}
