package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TestEntry {
  // initialise Entry values of different parameters types
  private Entry entryNothing = new Entry();
  private Entry entryNumber = new Entry(5f);
  private Entry anotherEntryNumber = new Entry(5f);
  private Entry entrySymbol = new Entry(Symbol.RIGHT_BRACKET);
  private Entry anotherEntrySymbol = new Entry(Symbol.PLUS);
  private Entry entryString = new Entry("testing");
  private Entry anotherEntryString = new Entry("differentString");
  private Entry entryNull = null;


  @Test
  // Test 1: Test if constructor is made for Entry with no parameter
  void testEmptyConstructorMade() {
    Entry newEntry = new Entry();
    assertDoesNotThrow(() -> newEntry, "Constructor for Entry with no paramaters was not made");
  }

  @Test
  // Test 2: Test if constructor is made for Entry with Number parameter
  void testNumberConstructorMade() {
    Entry newEntry = new Entry(6f);
    assertDoesNotThrow(() -> newEntry, "Constructor for Entry with Number parameter was not made");
  }

  @Test
  // Test 3: Test if constructor is made for Entry with Symbol parameter
  void testSymbolConstructorMade() {
    Entry newEntry = new Entry(Symbol.PLUS);
    assertDoesNotThrow(() -> newEntry, "Constructor for Entry with Symbol parameter was not made");
  }

  @Test
  // Test 4: Test if constructor is made for Entry with String parameter
  void testStringConstructorMade() {
    Entry newEntry = new Entry("test");
    assertDoesNotThrow(() -> newEntry, "Constructor for Entry with String parameter was not made");
  }

  @Test
  // Test 5: Nothing passed through Entry should assign its type to Type.INVALID
  void testEmptyEntryConstructor() {
    assertEquals(Type.INVALID, entryNothing.getType());
  }

  @Test
  // Test 6:
  // 1. Float number passed through Entry should assign its value to 5f and type to Type.NUMBER
  // 2. BadTypeException implemented. Code is refactored and throws when initialised Entry type and
  // return type are mismatched
  void testNumberEntryConstructor() throws BadTypeException {
    assertEquals(5f, entryNumber.getNumber());
    assertEquals(Type.NUMBER, entryNumber.getType());
    assertThrows(BadTypeException.class, () -> entryNumber.getSymbol(),
        "Throws when Entry initialised with Number but wants to return Symbol");
  }

  @Test
  // Test 7:
  // 1. Symbol passed through Entry should assign its value to Symbol.RIGHT_BRACKET and type to
  // Type.SYMBOL
  // 2. BadTypeException implemented. Code is refactored and throws when initialised Entry type and
  // return type are mismatched
  void testSymbolEntryConstructor() throws BadTypeException {
    assertEquals(Symbol.RIGHT_BRACKET, entrySymbol.getSymbol());
    assertEquals(Type.SYMBOL, entrySymbol.getType());
    assertThrows(BadTypeException.class, () -> entrySymbol.getNumber(),
        "Throws when Entry initialised with Symbol but wants to return Number");
  }

  @Test
  // Test 8:
  // 1. String passed through Entry should assign its value to "testing" and type to
  // Type.STRING
  // 2. BadTypeException implemented. Code is refactored and throws when initialised Entry type and
  // return type are mismatched
  void testStringEntryConstructor() throws BadTypeException {
    assertEquals("testing", entryString.getString());
    assertEquals(Type.STRING, entryString.getType());
    assertThrows(BadTypeException.class, () -> entryString.getNumber(),
        "Throws when Entry initialised with String but wants to return Number");
  }

  @Test
  // Test 9:
  // 1. Getter of Number should return initialised number
  // 2. BadTypeException thrown when getter tries to return from mismatched initialised entry type
  void testGetNumber() throws BadTypeException {
    assertEquals(5f, entryNumber.getNumber());
    assertThrows(BadTypeException.class, () -> entryNumber.getString(),
        "Throws when Entry initialised with Number but wants to return String");
  }

  @Test
  // Test 10:
  // 1. Getter of Symbol should return initialised symbol
  // 2. BadTypeException thrown when getter tries to return from mismatched initialised entry type
  void testGetSymbol() throws BadTypeException {
    assertEquals(Symbol.RIGHT_BRACKET, entrySymbol.getSymbol());
    assertThrows(BadTypeException.class, () -> entryString.getNumber(),
        "Throws when Entry initialised with Symbol but wants to return Number");
  }

  @Test
  // Test 11:
  // 1. Getter of String should return initialised string
  // 2. BadTypeException thrown when getter tries to return from mismatched initialised entry type
  void testGetString() throws BadTypeException {
    assertEquals("testing", entryString.getString());
    assertThrows(BadTypeException.class, () -> entryString.getSymbol(),
        "Throws when Entry initialised with String but wants to return Symbol");
  }

  @Test
  // Test 12: Gets the Type of an Entry
  void testGetType() {
    assertEquals(Type.STRING, entryString.getType());
  }

  @Test
  // Test 13:
  // 1. Assert that HashSet was constructed
  // 2. Assert that two separate entries of the same value has the same hash code
  void testHashCode() {
    Set<Entry> set = new HashSet<Entry>();
    Entry entry1 = new Entry(5f);
    Entry entry2 = new Entry(5f);
    set.add(entry1);
    set.add(entry2);
    assertDoesNotThrow(() -> set, "Constructor for HashSet of type Entry was not made");
    assertEquals(entry1.hashCode(), entry2.hashCode());
  }

  @Test
  // Test 14:
  // 1. Test that Entries of type Number are equal
  // 2. Test that Entry of type String and Number are not equal
  // 3. Test that Entries of different Symbols are not equal
  // 4. Test that Entries of the same type are equal
  // 5. Test that Entry of type null is False
  void testEquals() {
    assertTrue(anotherEntryNumber.equals(entryNumber));
    assertFalse(entryString.equals(entryNumber));
    assertFalse(entrySymbol.equals(anotherEntrySymbol));
    assertFalse(entryString.equals(anotherEntryString));
    assertTrue(entryString.getType().equals(anotherEntryString.getType()));
    assertFalse(entryNumber.equals(entryNull));
  }
}
