package org.example.recFqlJ6Sq2qztxXh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterUtil {
  public static <T> T[] filter(T[] t, Filter<T> filter){
    List<T> filteredList = new ArrayList<>();
    for (T elem : t) {
      if (filter.apply(elem)) filteredList.add(elem);
    }
    return filteredList.toArray(Arrays.copyOf(t, 0));
  }

  public static void main(String[] args) {
    String[] filteredStrings = filter(new String[]{"One", "Two", "Three"}, s -> s.length() == 3);
    Integer[] filteredInts = filter(new Integer[]{0, 1, 2, 3, 4, 5}, i -> i % 2 == 0);

    for (String s : filteredStrings) {
      System.out.println(s);
    }

    for (Integer i : filteredInts) {
      System.out.println(i);
    }
  }
}
