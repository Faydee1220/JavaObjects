// 處理遊戲邏輯
public class Game {
  public static final int MAX_MISSES = 7;
  private String answer;
  private String hits;
  private String misses;
  
  public Game(String answer) {
    this.answer = answer.toLowerCase();
    hits = "";
    misses = "";
  }
  
  public String getAnswer() {
    return answer;
  }
  
  private char normalizeGuess(char letter) {
    // 檢查是否為字母，排除空白、數字或 @ 等
    if (!Character.isLetter(letter)) {
      throw new IllegalArgumentException("A letter is required");
    }
    // 轉為小寫
    letter = Character.toLowerCase(letter);
    // Swift 的轉小寫
    // letter = letter.lowercased()
    
    // 檢查是否已經猜過
    if (hits.indexOf(letter) >= 0 || misses.indexOf(letter) >= 0) {
      throw new IllegalArgumentException(letter + " has already been guessed");
    }
    
    return letter;
  }
  
  public boolean applyGuess(String letters) {
    // 排除沒有輸入任何東西
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));
  }
  
  public boolean applyGuess(char letter) {
    letter = normalizeGuess(letter);
    
    // String.indexOf 找不到時會回傳 -1
    boolean isHit = answer.indexOf(letter) != -1;
    if (isHit) {
      hits += letter;
    } else {
      misses += letter;
    }
    return isHit;
  }
  
  public int getRemainingTries() {
    return MAX_MISSES - misses.length();
  }
  
  public String getCurrentProgress() {
    String progress = "";
    for (char letter : answer.toCharArray()) {
      char display = '-';
      // Array 的 index 從 0 開始，大於等於 0 表示能找到
      if (hits.indexOf(letter) >= 0) {
        display = letter;
      }
      progress += display;
    }
    return progress;
  }
  
  public boolean isWon() {
    // indexOf 找不到時會回傳 -1，全部都猜中沒有殘留的 - 時，就贏了
    return getCurrentProgress().indexOf('-') == -1;
  }
  
  
  
}
