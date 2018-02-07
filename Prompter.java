import java.util.Scanner;

// 處理 IO, input and output
public class Prompter {
  private Game game;
  
  public Prompter(Game game) {
    this.game = game;
  }

  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;
    
    do {
      System.out.print("Enter a letter:  ");
      // 取得輸入內容
      String guessInput = scanner.nextLine();

      try {
        isHit = game.applyGuess(guessInput);
        // 因為 applyGuess 中的 normalizeGuess 會檢查，有錯誤時會 throw exception，跳到下面的 catch
        // 正確時才會執行到 isAcceptable = true;
        isAcceptable = true;
      } catch (IllegalArgumentException iae) {
        System.out.printf("%s.  Please try again.%n",
                          iae.getMessage());
      }
    } while (!isAcceptable);
    
    return isHit;
  }
  
  public void displayProgress() {
    System.out.printf("You have %d tries left to solve:  %s%n",
                      game.getRemainingTries(),
                      game.getCurrentProgress()
                      );
  }
  
  public void displayOutcome() {
    if (game.isWon()) {
      System.out.printf("Congratulation you won with %d tries remaining.%n",
                       game.getRemainingTries());
    } else {
      System.out.printf("Bummer the word was %s. :( %n",
                       game.getAnswer());
    }
  }
  
}