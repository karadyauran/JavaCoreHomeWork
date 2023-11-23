package org.example.recYn15tMWtWHMbtK;

public class Student {
  private String name;
  private String surname;
  private int age;

  public Student(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + "=" + surname + "=" + age;
  }
}
