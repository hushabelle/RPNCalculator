package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Some test cases were inspired from RHUL CS2800 Week2 TDD Demo video.
class TestStack {
  private Stack calcStack;
  private Entry entryFloat = new Entry(5f);
  private Entry entrySymbol = new Entry(Symbol.LEFT_BRACKET);
  private Entry entryString = new Entry("testing");

  @BeforeEach
  // Test 1: Initialise stack as a precondition for each of the following tests
  public void setup() {
    calcStack = new Stack();
  }
  
  @Test
  // Test 2: Test if constructor is made for Stack
  void testStackMade() {
    Stack newStack = new Stack();
    assertDoesNotThrow(() -> newStack, "Constructor for Stack was not made");
  }

  @Test
  // Test 3: Size of empty stack is 0
  void testEmptySize() {
    assertEquals(0, calcStack.size(),
        "A newly created stack with nothing pushed onto it should return size 0");
  }

  @Test
  // Test 4: One thing pushed onto stack has size of 1
  void testPush() {
    calcStack.push(entryString);
    assertEquals(1, calcStack.size(), "Pushing one thing to a new Stack should return size 1");
  }


  @Test
  // Test 5: Five things pushed onto stack has size of 5
  void testPushFew() {
    calcStack.push(entryFloat);
    calcStack.push(entrySymbol);
    calcStack.push(entryString);
    calcStack.push(entryFloat);
    calcStack.push(entrySymbol);
    assertEquals(5, calcStack.size(), "Pushing five things onto a new stack should return size 5");
  }

  @Test
  // Test 6: Popping from an empty stack throws EmptyStackException
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> calcStack.pop(),
        "You cannot pop from an empty Stack");
  }

  @Test
  // Test 7: Pushing two items should return size of 2, then popping two items after should
  // return size 0
  void testPushThenPop() throws BadTypeException {
    calcStack.push(entryFloat);
    calcStack.push(entrySymbol);
    assertEquals(2, calcStack.size(), "Pushing twice should give 2");
    assertEquals(calcStack.pop().getSymbol(), Symbol.LEFT_BRACKET,
        "Pushing a five then popping it should return 17");
    assertEquals(5f, calcStack.pop().getNumber(), "Pushing a five then popping it should return 5");
    assertEquals(0, calcStack.size(), "Pushing a five then popping it should give an empty Stack");
  }

  @Test
  // Test 8:
  // 1. Pushing a lot of items breaks the code. Array is not sufficient when items pushed
  // exceeds array size. ArrayList was implemented here
  // 2. Stack was refactored to implement ArrayList of type Entry alongside the creation of Entry
  // class
  void testPushALot() {
    for (int counter = 0; counter < 1000; counter++) {
      calcStack.push(entryFloat);
    }
    assertEquals(1000, calcStack.size(), "Pushing 1000 things, should return 1000");
  }

  @Test
  // Test 9: There is no top when stack is empty, EmptyStackException thrown
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> calcStack.top(),
        "You cannot top from an empty Stack");
  }

  @Test
  // Test 10: Pushing two items and passing top twice to ensure the method doesn't remove the
  // item it topped
  void testPushThenTop() throws BadTypeException {
    calcStack.push(entryFloat);
    calcStack.push(entrySymbol);
    assertEquals(Symbol.LEFT_BRACKET, calcStack.top().getSymbol(),
        "Popping first time should return (");
    assertEquals(Symbol.LEFT_BRACKET, calcStack.top().getSymbol(),
        "Popping second time should also return (");

  }
}
