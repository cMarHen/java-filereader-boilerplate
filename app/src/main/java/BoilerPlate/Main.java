package BoilerPlate;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class Main {
  private Console ui;
  private Scanner scan;
  String[] arrFromFile;

  public Main() {
    this.scan = new Scanner(System.in, "UTF8");
    this.ui = new Console(scan);
  }

  public void run() {
    TextReader exampleText = new TextReader("/src/main/java/files/example.txt");
    this.arrFromFile = exampleText.readFromFile().split("\n");
    
    // getKey(40, "QMJ BPZ B XPJZ RZWJPAXQ LAD");
    Encrypter encrypter = new Encrypter('z', 'a');
    String message = "XEM CKSX MEET MEKBT Q MEET SXKSA SXKSA YV Q MEET SXKSA SEKBT SXKSA MEET".toLowerCase();
    getKey(40, message, false, encrypter);


    System.out.println(encrypter.decrypt(16, message));
    // Close scanner when exit application
    scan.close();
  }

  private void getKey(int cycles ,String message, boolean showEachLine, Encrypter encrypter) {
    for (int i = 0; i < cycles; i++) {
      if (showEachLine) {
        System.out.println("Key " + i + " contains " + encrypter.decrypt(i, message));
      } else {
        String[] sentence = encrypter.decrypt(i, message).split(" ");

        for (String s : sentence) {
          if (isValidWord(s)) {
            System.out.println("Key " + i + " contains " + s);
          }
        }
      }
    }
  }

  private boolean isValidWord(String word) {
    for (String s : arrFromFile) {
      if (s.equals(word)) {
        return true;
      }
    }
    return false;
  }
}
