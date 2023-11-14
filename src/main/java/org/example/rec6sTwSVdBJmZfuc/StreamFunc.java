package org.example.rec6sTwSVdBJmZfuc;

import java.util.List;

public class StreamFunc {
  public static void feed(List<Cat> catList) {
    catList = catList.stream()
            .peek(cat -> {
              if (cat.isHungry()) {
                cat.setHungry(false);
              }
            })
            .toList();
  }

  public static int getSum(List<Integer> integers) {
    return integers.stream()
            .filter(integer -> integer % 2 != 0)
            .mapToInt(Integer::intValue)
            .sum();
  }
}
