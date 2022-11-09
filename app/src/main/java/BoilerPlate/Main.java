package BoilerPlate;

import java.util.Scanner;

public class Main {
  private Console ui;
  private Scanner scan;

  public Main() {
    this.scan = new Scanner(System.in, "UTF8");
    this.ui = new Console(scan);
  }

  public void run() {
    TextReader exampleText = new TextReader("/src/main/java/files/example.txt");

    Boolean isRunning = true;
    do {
      // Main loop goes here.
      System.out.println(exampleText.readFromFile());

      int choice = this.ui.promptForInt("Enter a number: ");

      if (choice == 0) {
        isRunning = false; 
      }
    } while (isRunning);



    // Close scanner when exit application
    scan.close();
  }
}