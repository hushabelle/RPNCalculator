package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Facade for a Stack of Entry of Type float values. Delegates methods from Stack class.
 * 
 * @author Annabelle Wong Poh Hui
 */
public class NumStack {
  private Stack numStack = new Stack();

  /**
   * Constructor for NumStack class.
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Calculates the size of ArrayList of numStack of Entry Type NUMBER.
   * 
   * @return the size of ArrayList of type integer
   */
  public int size() {
    return numStack.size;
  }

  /**
   * Pushes float object, specifically of Type NUMBER, onto the top of the stack.
   * 
   * @param floatNumber the float number to push onto the stack
   */
  public void push(float floatNumber) {
    numStack.push(new Entry(floatNumber));
  }

  /**
   * Removes and displays the float at the top of the stack.
   * 
   * @return the last pushed float object of Type NUMBER  
   * @throws EmptyStackException thrown when size of stack is 0. Index will decrement out of bounds
   * @throws BadTypeException thrown when numStack and return type of float do not match
   */
  public float pop() throws EmptyStackException, BadTypeException {
    return numStack.pop().getNumber();
  }

  /**
   * Checks if NumStack is empty.
   * 
   * @return boolean whether NumStack is empty.
   */
  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
