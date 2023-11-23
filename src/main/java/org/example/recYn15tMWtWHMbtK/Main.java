package org.example.recYn15tMWtWHMbtK;

public class Main {
  public static void main(String[] args) {
    School school = new School();
    StudentInit.init(school);
    System.out.println(school.getStudent1());
    System.out.println(school.getStudent2());
  }
}
