public class Hangman {
  // args 代表使用 java Hangman 時可以帶入的參數（內容為字串形態的陣列），args is a String Array Arguments
  // 執行 java Hangman 時會找出該 class 的 main method 執行
  // static 代表 main 是 class method
  // void 代表沒有回傳值
  public static void main(String[] args) {
    // Your incredible code goes here...
    if (args.length == 0) {
      System.out.println("Usage: java Hangman <answer>");
      System.err.println("Answer is required");
      System.exit(1);
    }
    
    Game game = new Game(args[0]);
    Prompter prompter = new Prompter(game);
    while (game.getRemainingTries() > 0 && !game.isWon()) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }
    prompter.displayOutcome();
    
    
//    prompter.displayProgress();
//    
//    boolean isHit = prompter.promptForGuess();
//    if (isHit) {
//      System.out.println("We got a hit!");
//    } else {
//      System.out.println("Oops missed");  
//    }
//    
//    prompter.displayProgress();
    
  }
  
  
}