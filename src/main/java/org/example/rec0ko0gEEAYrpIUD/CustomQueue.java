package org.example.rec0ko0gEEAYrpIUD;

public class CustomQueue {

  private int[] data;
  private int head;
  private int tail;
  private int size;

  public CustomQueue(int capacity){
    data = new int[capacity];
    head = -1;
    tail = -1;
  }

  public void enqueue(int element){ // TODO
    size++;
    data[++tail] = element;
  }

  public int dequeue(){ // TODO
    size--;
    return data[++head];
  }

  public boolean isEmpty() {
    return head == -1;
  }

  public int size() { // TODO
    return size;
  }

  public static void main(String[] args) {
    CustomQueue queue = new CustomQueue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println("size: " + queue.size());
    queue.enqueue(4);
    queue.enqueue(5);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}
