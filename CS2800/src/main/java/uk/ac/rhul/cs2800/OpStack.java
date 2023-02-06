package uk.ac.rhul.cs2800;

/**
 * Facade for a Stack of Entry of Type SYMBOL values. Delegates methods from Stack class.
 * 
 * @author Annabelle Wong Poh Hui
 */
public class OpStack {
  private Stack opStack = new Stack();

  /**
   * Constructor for OpStack class.
   */
  public OpStack() {
    this.opStack = new Stack();
  }
  
  /**
   * Calculates the size of ArrayList of opStack of Entry Type SYMBOL.
   * 
   * @return the size of ArrayList of Type SYMBOL
   */
  public int size() {
    return opStack.size;
  }
  
  /**
   * Pushes Entry object, specifically of Type SYMBOL, onto the top of the stack.
   * 
   * @param symbolOperator the symbol to push onto the stack
   */
  public void push(Entry symbolOperator) {
    opStack.push(symbolOperator);
  }
  
  /**
   * Removes and displays the Entry Type SYMBOL at the top of the stack.
   * 
   * @return the last pushed Entry object of Type SYMBOL
   */
  public Entry pop() {
    return opStack.pop();
  }
  
  /**
   * Checks if OpStack is empty.
   * 
   * @return boolean whether OpStack is empty.
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
