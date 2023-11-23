package org.example.recYn15tMWtWHMbtK;

import lombok.Getter;

@Getter
public class School {
  @StudentInfo(name = "Adam", surname = "Smith", age = 13)
  private Student student1;

  @StudentInfo(name = "Maria", surname = "Williams", age = 12)
  private Student student2;
}
