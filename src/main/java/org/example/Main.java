package org.example;

import org.example.rec6sTwSVdBJmZfuc.Cat;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Cat c1 = new Cat("c1", 1, false);
    Cat c2 = new Cat("c2", 2, true);
    Cat c3 = new Cat("c3", 4, false);

    List<Cat> catList = List.of(c1, c2, c3);
  }
}