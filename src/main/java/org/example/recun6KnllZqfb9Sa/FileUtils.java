package org.example.recun6KnllZqfb9Sa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileUtils {
  static Map<Character, Long> createMap(String filePath) {
    Pattern pattern = Pattern.compile("\\b((?!Mrs\\. |Mr\\. )[A-Z][a-z]+)\\b");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      return reader.lines()
              .flatMap(line -> pattern.matcher(line).results())
              .map(MatchResult::group)
              .collect(Collectors.groupingBy(
                      name -> name.charAt(0),
                      Collectors.counting()
              ));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static char mostRepeatableLetter(String filePath) {
    Pattern pattern = Pattern.compile("\\b((?!Mrs\\. |Mr\\. )[A-Z][a-z]+)\\b");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      return reader.lines()
              .flatMap(line -> pattern.matcher(line).results())
              .map(MatchResult::group)
              .collect(Collectors.groupingBy(
                      name -> name.charAt(0),
                      Collectors.counting()
              )).entrySet().stream()
              .max(Map.Entry.comparingByValue())
              .get().getKey();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static List<Long> getAllNumbers(String filePath) {
    List<Long> numbers = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String result = line.replaceAll("[^\\d]", "");
        numbers.add(Long.valueOf(result));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return numbers;
  }

  static Map<Integer, List<String>> namesLength(String filePath) {
    Pattern pattern = Pattern.compile("\\b((?!Mrs\\. |Mr\\. )[A-Z][a-z]+)\\b");
    Map<Integer, List<String>> result = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line= reader.readLine()) != null) {
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          String name = matcher.group();
          int nameLength = name.length();

          result.put(nameLength, result.getOrDefault(nameLength, new ArrayList<>()));
          result.get(nameLength).add(name);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

  static List<String> uniquesSurnames(String filePath) {
    Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+)\\b\\s+([A-Z][a-z]+)$");
    List<String> surnames = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
          surnames.add(matcher.group(2));
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return surnames.stream().distinct().toList();
  }

  static List<String> namesInReversedOrder(String filePath) {
    Pattern pattern = Pattern.compile("\\b((?!Mrs\\. |Mr\\. )[A-Z][a-z]+)\\b");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      return reader.lines()
              .flatMap(line -> pattern.matcher(line).results())
              .map(MatchResult::group)
              .sorted(Comparator.reverseOrder())
              .toList();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static List<String> getContacts(String filePath) {
    List<String> contacts = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+)\\b\\s+([A-Z][a-z]+)$");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String number = line.replaceAll("[^\\d]", "");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
          contacts.add(matcher.group() + "=" + number);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return contacts;
  }

  static double avgNamesLength(String filePath) {
    Pattern pattern = Pattern.compile("\\b((?!Mrs\\. |Mr\\. )[A-Z][a-z]+)\\b");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      return reader.lines()
              .flatMap(line -> pattern.matcher(line).results())
              .map(MatchResult::group)
              .mapToInt(name -> name.length())
              .average()
              .getAsDouble();
      }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static Map<Long, String> getContactsMap(String filePath) {
    Map<Long, String> result = new HashMap<>();
    Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+)\\b\\s+([A-Z][a-z]+)$");

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        Long number = Long.valueOf(line.replaceAll("[^\\d]", ""));
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
          result.put(number, matcher.group());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  public static void main(String[] args) {
    String filePath = "src/main/java/org/example/recun6KnllZqfb9Sa/1.txt";
    Map<Character, Long> m1 = createMap(filePath);
    char mostRepeatableLetter = mostRepeatableLetter(filePath);
    List<Long> numbers = getAllNumbers(filePath);
    Map<Integer, List<String>> longNames = namesLength(filePath);
    List<String> uniquesSurnames = uniquesSurnames(filePath);
    List<String> namesInReversedOrder = namesInReversedOrder(filePath);
    List<String> contracts = getContacts(filePath);
    double avgNamesLength = avgNamesLength(filePath);
    Map<Long, String> getContactsMap = getContactsMap(filePath);
  }
}
