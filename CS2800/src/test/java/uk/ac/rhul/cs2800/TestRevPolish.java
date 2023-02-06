package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRevPolish {
  private RevPolishCalc calc = new RevPolishCalc();

  @BeforeEach
  public void setup() {
    calc = new RevPolishCalc();
  }

  @Test
  //Tests PLUS case works."3 2 +" should return 5
  public final void simplePlus() throws InvalidExpressionException, BadTypeException {
    assertEquals(5F, this.calc.evaluate("3 2 +"));
  }

  @Test
  //Tests PLUS and MINUS case together in one expression.
  public final void simplePlusMinus() throws InvalidExpressionException, BadTypeException {
    assertEquals(-5F, this.calc.evaluate("2 3 4 + -"));
    assertEquals(1F, this.calc.evaluate("2 3 + 4 -"));
  }

  @Test
  //Tests PLUS, MINUS and TIMES all together in one expression.
  public final void testTimes() throws InvalidExpressionException, BadTypeException {
    assertEquals(15F, this.calc.evaluate("3 4 + 2 * 1 +"));
    assertEquals(2F, this.calc.evaluate("2 3 * 4 -"));
    assertEquals(-1F, this.calc.evaluate("4 3 2 * + 11 -"));
  }

  @Test
  //Tests PLUS, MINUS and TIMES and DIVIDE all together in one expression.
  public final void testDivide() throws InvalidExpressionException, BadTypeException {
    assertEquals(2F, this.calc.evaluate("2 5 * 4 + 3 2 * 1 + /"));
  }

  @Test
  //An empty expression inputed will throw InvalidExpressionException.
  public final void testEmptyExpression() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> this.calc.evaluate(""),
        "Empty expression is invalid");
  }

}
