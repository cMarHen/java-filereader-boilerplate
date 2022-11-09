package BoilerPlate;

public class Encrypter {
  private char upperBound;
  private char lowerBound;

  public Encrypter(char upperBound, char lowerBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  public String encrypt(int numberToIncrement, String message) {
    char[] arr = message.toCharArray();
    String encryptedWord = "";

    for (int i = 0; i < arr.length; i++) {
      char char1= arr[i];  
      if (char1 == ' ') {
        encryptedWord += " ";
      } else {
        if (char1 + numberToIncrement > upperBound) {
          int increments = numberToIncrement;
          while (increments > 0) {
            if (char1 == upperBound) {
              char1 = lowerBound;
            } else {
              char1 ++;
            }
            increments--;
          }
          
        } else {
          // BÖRJAR ÄNDRA
          char1 = (char) (char1 + numberToIncrement);  
        }
      }

      encryptedWord += char1;
    }

    return encryptedWord;
  }

  public String decrypt(int numbersToDecrement, String encryptedMessage) {
    char[] arr = encryptedMessage.toCharArray();
    String decryptedWord = "";

    for (int i = 0; i < arr.length; i++) {
      char char1= arr[i];  

      if (char1 == ' ') {
        decryptedWord += " ";
      } else {
      if (char1 - numbersToDecrement < lowerBound) {
        int increments = numbersToDecrement;
        while (increments > 0) {
          if (char1 == lowerBound) {
            char1 = upperBound;
          } else {
            char1 --;
          }
          increments--;
        }
        
      } else {
        char1 = (char) (char1 - numbersToDecrement);  
      }
    }

      decryptedWord += char1;
    }

    return decryptedWord;
  }
}
