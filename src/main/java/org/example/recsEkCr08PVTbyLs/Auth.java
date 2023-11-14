package org.example.recsEkCr08PVTbyLs;

public class Auth {
  public static void main(String[] args) {
    String login = "sasha";
    String password = "4324";
    String confirmPassword = "4324";
  }

  public static boolean doLogin(String login, String password, String confirmPassword)
          throws WrongLoginException, WrongPasswordException {
    if (!login.replaceAll("[a-zA-Z0-9_]", "").isEmpty())
      throw new WrongLoginException("Wrong format");
    if (login.length() > 20)
      throw new WrongLoginException("Login must be less than 20 s.");

    if (!password.replaceAll("[a-zA-Z0-9_]", "").isEmpty())
      throw new WrongPasswordException("Wrong format");
    if (password.length() > 20)
      throw new WrongPasswordException("Password must be less than 20 s.");

    if (!password.equals(confirmPassword))
      throw new WrongPasswordException("Incorrect password confirmation");

    return true;
  }
}
