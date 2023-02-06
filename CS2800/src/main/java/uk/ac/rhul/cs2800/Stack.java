package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * An implementation of a stack of Entry objects.
 *
 * @author Annabelle Wong Poh Hui
 */
public class Stack {
  ArrayList<Entry> values = new ArrayList<Entry>();
  int size = 0;

  /**
   * Constructor for stack class.
   */
  public Stack() {
    this.values = new ArrayList<Entry>();
  }

  /**
   * Calculates the size of ArrayList of type Entry.
   * 
   * @return the size of ArrayList of type integer
   */
  public int size() {
    return size;
  }

  /**
   * Pushes an Entry object onto the top of this stack.
   * 
   * @param i the value to push onto the stack
   */
  public void push(Entry i) {
    values.add(i);
    size += 1;
  }

  /**
   * Removes and displays the Entry object at the top of this stack. Size of stack decrements.
   * 
   * @return the last pushed Entry object at the top of this stack
   * @throws EmptyStackException thrown when size of stack is 0. Index will decrement out of bounds
   */
  public Entry pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry entry = values.get(size - 1);
    values.remove(entry);
    size -= 1;
    return entry;
  }

  /**
   * Displays the Entry object at the top of this stack.
   * 
   * @return the last pushed Entry object at the top of this stack
   * @throws EmptyStackException thrown when size of stack is 0. Nothing to display
   */
  public Entry top() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return values.get(values.size() - 1);
  }
}
