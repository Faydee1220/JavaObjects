public class Example {
 
  public static void main(String[] args) {
    // Your amazing code goes here...
    System.out.println("We are making new PEZ Dispenser");
    
    // 有加上 static 的可以在初始化之前就取用 
    System.out.printf("FUN FACT: There are %d PEZ allowed in evey dispenser %n",
                     PezDispenser.MAX_PEZ);
    
    // 初始化物件
    // type 命名 = new className();
    // PezDispenser dispenser = new PezDispenser();
    PezDispenser dispenser = new PezDispenser("Yoda");
      
    // Swift 的初始化
    // var dispenser = PezDispenser("Yoda")
    
    // characterName 沒有寫 private 時可以被取用及改變
    // dispenser.characterName = "Darth Vader";
    
    System.out.printf("The dispenser is %s %n", 
                      dispenser.getCharacterName()
                     );
    
    if (dispenser.isEmpty()) {
      System.out.println("Dispenser is empty");
    }
    
    System.out.println("Filling the dispenser with delicious PEZ...");
    dispenser.fill();
    
    if (!dispenser.isEmpty()) {
      System.out.println("Dispenser is full");
    }
    
    while (dispenser.dispense()) {
      System.out.println("Chomp!");
    }
    if (dispenser.isEmpty()) {
      System.out.println("Eat all the PEZ");
    }
    
    dispenser.fill(4);
    dispenser.fill(2);
    while (dispenser.dispense()) {
      System.out.println("Chomp!!");
    }
    
    try {
      dispenser.fill(400);
      System.out.println("This will never happen");
    } catch (IllegalArgumentException iae) {
      System.out.println("Whoa there!");
      System.out.printf("The error was %s",
                       iae.getMessage());
    }
    
    
    // 測試 final
//    String before = dispenser.swapHead("Darth Vader");
//    System.out.printf("It was %s but Faydee switched to %s %n",
//                     before,
//                     dispenser.getCharacterName()
//                     );

  }

}
