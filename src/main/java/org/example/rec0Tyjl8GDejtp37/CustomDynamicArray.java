package org.example.rec0Tyjl8GDejtp37;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CustomDynamicArray implements Iterable<Integer> {

  private int[] data;
  private int size;
  private int count;

  public CustomDynamicArray(){ // O(1)
    data = new int[1];
    size = 1;
    count = 0;
  }

  public CustomDynamicArray(int capacity){ // O(n)
    data = new int[capacity];
    size = capacity;
    count = 0;
  }

  public void add(int element){ // O(n) ---> O(1) amortized
    if (count >= size) {
      growSize();
    }
    data[count++] = element;
  }

  public void addAt(int index, int element) { // O(n)
    if (index >= count) throw new IndexOutOfBoundsException("Input index is out of bounds");
    if (count >= size) {
      growSize();
    }
    for (int i = count; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    count++;
  }

  public void remove(){ // O(1)
    if (count == 0) throw new NoSuchElementException();
    data[count - 1] = 0; // data[count - 1] = null - necessary in case of objects for Garbage Collector
    count--;
  }

  public void removeAt(int index){ // TODO // O(n)
    if (count == 0 || index >= count) throw new NoSuchElementException();
    for (int i = index; i < count; i++) {
      data[i] = data[i + 1];
    }
    count--;
  }

  public void shrinkSize() { // O(n)
    if (count < size) {
      int[] newData = Arrays.copyOf(data, count);
      data = newData;
      size = newData.length;
    }
  }

  public void set(int index, int data){ //TODO // O(1)
    if (count == 0 || index >= count) throw new NoSuchElementException();
    this.data[index] = data;
  }

  public int get(int index){ // TODO // O(1)
    return data[index];
  }

  public void clear(){ // O(1)
    data = new int[1];
    size = 1;
    count = 0;
  }

  public boolean contains(int data){ // O(n)
    for (int i : this.data) {
      if (i == data) return true;
    }
    return false;
  }

  public boolean isEmpty(){ // O(1)
    return count == 0;
  }


  private void growSize() {
    int[] newData = new int[2 * size];
    for (int i = 0; i < count; i++) {
      newData[i] = data[i];
    }
    data = newData;
    size = 2 * size;
  }


  public static void main(String[] args) {
    CustomDynamicArray array = new CustomDynamicArray();
    System.out.println(array.isEmpty());
    array.add(1);
    array.add(2);
    array.add(3);
    array.add(4);
    array.add(5);

    System.out.println(array);

    array.set(0, 10);
    System.out.println(array.contains(43));
    array.clear();
    System.out.println(array);
  }

  @Override
  public String toString(){
    return "[" + Arrays.stream(data).limit(count).boxed()
            .map(Object::toString).reduce((s1, s2) -> s1 + ", " + s2)
            .orElse("") + "]";
  }

  public void printInnerStructure(){
    System.out.println("Inner Structure: " + Arrays.toString(data));
  }


  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      int currentIndex = 0;
      @Override
      public boolean hasNext() {
        return currentIndex < count;
      }

      @Override
      public Integer next() {
        return data[currentIndex++];
      }

//            @Override
//            public void remove(){
//
//            }
    };
  }
}

