package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSymbol {

  @Test
  // Test 1: Ensures symbolic representation corresponds to Symbols
  void testSymbols() {
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")");
    assertEquals(Symbol.TIMES.toString(), "*");
    assertEquals(Symbol.DIVIDE.toString(), "/");
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.MINUS.toString(), "-");
    assertEquals(Symbol.INVALID.toString(), "Invalid");
  }

}
