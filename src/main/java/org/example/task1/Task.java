package org.example.task1;

import java.util.*;

public class Task {
  public static void main(String[] args) {
    String[] strings = {"string", "dog", "god", "wolffff", "strings", "wolf", "flow", "wollarf"};
    getGroupsOfUniquesWords(strings);
  }

  public static void getGroupsOfUniquesWords1(String[] arr) {
    HashMap<String, List<String>> res = new HashMap<>();
    for (String s : arr) {
      char[] word = s.toCharArray();
      Arrays.sort(word);
      String sortedWord = new String(word);

      if (!res.containsKey(sortedWord)) {
        res.put(sortedWord, new ArrayList<>());
      }
      res.get(sortedWord).add(s);
    }

    for (List<String> strings : res.values()) {
      System.out.println(strings);
    }

  }

  public static void getGroupsOfUniquesWords(String[] arr) {
    HashMap<Integer, List<String>> res = new HashMap<>();
    for (String s : arr) {
      Set<Character> set = new HashSet<>();
      for (char c : s.toCharArray()) {
        set.add(c);
      }

      int hash = 0;
      for (char c : set) {
        hash += c;
      }

      if (!res.containsKey(hash)) res.put(hash, new ArrayList<>());
      res.get(hash).add(s);
    }

    for (List<String> strings : res.values()) {
      System.out.println(strings);
    }
  }
}