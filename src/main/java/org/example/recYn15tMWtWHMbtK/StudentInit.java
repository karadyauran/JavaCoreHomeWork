package org.example.recYn15tMWtWHMbtK;

import java.lang.reflect.Field;
import java.util.Arrays;


public class StudentInit {
  public static void init (School school) {
    Class<?> schoolClass = school.getClass();
    Field[] fields = schoolClass.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(StudentInfo.class)) {
        StudentInfo studentInfo = field.getAnnotation(StudentInfo.class);
        String name = studentInfo.name();
        String surname = studentInfo.surname();
        int age = studentInfo.age();

        try {
          field.setAccessible(true);
          field.set(school, new Student(name, surname, age));
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
