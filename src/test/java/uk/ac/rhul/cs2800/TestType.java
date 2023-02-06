package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestType {

  @Test
  // Test 1: Ensures textual representation corresponds to Types
  void testToString() {
    assertEquals(Type.NUMBER.toString(Type.NUMBER), "Number");
    assertEquals(Type.SYMBOL.toString(Type.SYMBOL), "Symbol");
    assertEquals(Type.STRING.toString(Type.STRING), "String");
    assertEquals(Type.INVALID.toString(Type.INVALID), "Invalid");
  }

}
