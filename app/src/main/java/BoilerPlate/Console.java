package BoilerPlate;

import java.util.Scanner;

public class Console {
  private Scanner scan;

  public Console(Scanner scan) {
    this.scan = scan;
  }

  public int promptForInt(String question) {
    int input = -1;
    boolean validInput;

    do {
      try {
        System.out.print(question);
        input = scan.nextInt();
        scan.nextLine();
        validInput = true;
      } catch (Exception exeption) {
        scan.nextLine();
        validInput = false;
      }
    } while (!validInput);

    return input;
  }

  public String promptForString(String message) {
    String input = "";
    boolean validInput;

    do {
      try {
        System.out.print(message);
        input = scan.nextLine();
        validInput = true;
      } catch (Exception exeption) {
        validInput = false;
      }
    } while (!validInput);

    return input;
  }
}
