class PezDispenser {
  // 固定的常數命名用大寫
  // static 代表 static context(class level)，不需要初始化就能取用。
  // 相對於 instances context 是必須初始化後才能取用。
  public static final int MAX_PEZ = 12;
  
  private int pezCount;
  
  // private 代表不能讓其他 class 修改、取用
  // 可以在 private 變數的命名前加個 m ，代表 member of variable，避免命名混淆
  // final 代表只能指定一次，之後無法再被改變
  
  // private String characterName = "Yoda";
  // private String characterName;
  // private String mCharacterName;
  final private String mCharacterName;
  
  // Constructor，如何初始化物件，例如可以帶入參數或者給預設值等
  public PezDispenser(String characterName) {
    // 可以用 this 代表自己宣告的變數，同 Swift 的 self
    // this.characterName = characterName;
    
    // 或者在自己宣告的變數的命名前面加個 m，代表 member of variable，避免命名混淆，Android Style
    mCharacterName = characterName;
    
    pezCount = 0;
  }
  
  public boolean dispense() {
    boolean wasDispensed = false;
    if (!isEmpty()) {
      pezCount -= 1;
      wasDispensed = true;
    }
    return wasDispensed;
  }
  
  // void 代表沒有回傳值
  public void fill() {
    // pezCount = MAX_PEZ;
    fill(MAX_PEZ);
  }
  
  public void fill(int pezAmout) {
//    pezCount += pezAmout;
    int newAmount = pezCount + pezAmout;
    if (newAmount > MAX_PEZ) {
      // 執行 throw 後會自動 exit，不執行後面的 code
      throw new IllegalArgumentException("Too many PEZ!!!");
    }
    pezCount = newAmount;
    
  }
  
  public boolean isEmpty() {
    return pezCount == 0;
  }
  
  // Method 的回傳值型態放前面
  // Getter
  public String getCharacterName() {
    return mCharacterName;
  }
  
  // 測試 final
//  public String swapHead(String characterName) {
//    String originalCharacterName = mCharacterName;
//    mCharacterName = characterName;
//    return originalCharacterName;
//  }
  
}