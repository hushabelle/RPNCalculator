package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOpStack {
  private OpStack opStack = new OpStack();
  private Entry opStackSymbol = new Entry(Symbol.LEFT_BRACKET);
  private Entry secondOpStackSymbol = new Entry(Symbol.TIMES);
  private Entry thirdOpStackSymbol = new Entry(Symbol.PLUS);
  private Entry fourthOpStackSymbol = new Entry(Symbol.MINUS);


  @BeforeEach
  // Initialise opStack as a precondition for each of the following tests
  public void setup() {
    opStack = new OpStack();
  }

  @Test
  // Test if constructor is made for OpStack
  void testOpStackMade() {
    OpStack newStack = new OpStack();
    assertDoesNotThrow(() -> newStack, "Constructor for OpStack was not made");
  }

  @Test
  // One thing pushed onto opStack has size of 1
  void testPush() {
    opStack.push(opStackSymbol);
    assertEquals(1, opStack.size(), "Pushing one thing to a new OpStack should return size 1");
  }

  @Test
  // Popping from an empty opStack throws EmptyStackException
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(),
        "You cannot pop from an empty OpStack");
  }

  @Test
  // Pushing three items should return size of 3, then popping three items after should
  // return size 0
  void testPushThenPop() throws BadTypeException {
    opStack.push(secondOpStackSymbol);
    opStack.push(thirdOpStackSymbol);
    opStack.push(fourthOpStackSymbol);
    assertEquals(3, opStack.size(), "Pushing twice should give size 3");
    assertEquals(opStack.pop().getSymbol(), Symbol.MINUS,
        "Pushing '*', '+', '-', then popping it for the first time should return '-'");
    assertEquals(opStack.pop().getSymbol(), Symbol.PLUS,
        "Pushing '*', '+', '-', then popping it for the second time should return '+'");
    assertEquals(opStack.pop().getSymbol(), Symbol.TIMES,
        "Pushing '*', '+', '-', then popping it for the second time should return '*'");
    assertEquals(0, opStack.size(),
        "Pushing three Entries then popping them should give an empty Stack");
  }
  
  @Test
  // If stack is empty, returns true. If not returns false
  void testIsEmpty() {
    assertEquals(true, opStack.isEmpty(), "Empty opStack returns true");
    opStack.push(opStackSymbol);
    assertEquals(false, opStack.isEmpty(), "Non-empty opStack returns false");
  }
}
