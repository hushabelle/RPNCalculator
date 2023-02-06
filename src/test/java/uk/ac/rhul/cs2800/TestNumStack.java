package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNumStack {
  private NumStack numStack = new NumStack();
  private float numStackFloat = 10f;
  private float secondNumStackFloat = 9f;
  private float thirdNumStackFloat = 8f;


  @BeforeEach
  // Initialise numStack as a precondition for each of the following tests
  public void setup() {
    numStack = new NumStack();
  }

  @Test
  // Test if constructor is made for NumStack
  void testStackMade() {
    NumStack newStack = new NumStack();
    assertDoesNotThrow(() -> newStack, "Constructor for NumStack was not made");
  }

  @Test
  // One thing pushed onto numStack has size of 1
  void testPush() {
    numStack.push(numStackFloat);
    assertEquals(1, numStack.size(), "Pushing one thing to a new NumStack should return size 1");
  }

  @Test
  // Popping from an empty numStack throws EmptyStackException
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "You cannot pop from an empty NumStack");
  }

  @Test
  // Pushing two items should return size of 2, then popping two items after should
  // return size 0
  void testPushThenPop() throws BadTypeException {
    numStack.push(secondNumStackFloat);
    numStack.push(thirdNumStackFloat);
    assertEquals(2, numStack.size(), "Pushing twice should give size 2");
    assertEquals(8f, numStack.pop(),
        "Pushing 9 then 8, then popping it for the first time should return 9");
    assertEquals(9f, numStack.pop(),
        "Pushing 9 then 8, then popping it for the second time should return 8");
    assertEquals(0, numStack.size(),
        "Pushing two Entries then popping them should give an empty Stack");
  }

  @Test
  // If stack is empty, returns true. If not returns false
  void testIsEmpty() {
    assertEquals(true, numStack.isEmpty(), "Empty numStack returns true");
    numStack.push(numStackFloat);
    assertEquals(false, numStack.isEmpty(), "Non-empty numStack returns false");

  }

}
