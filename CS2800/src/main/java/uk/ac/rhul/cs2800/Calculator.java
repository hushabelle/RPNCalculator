package uk.ac.rhul.cs2800;

/**
 * Abstract class that is used to group related methods in RevPolishCalc(Postfix) and
 * StandardCalc(Infix), i.e. Evaluate().
 * 
 * @author Annabelle Wong Poh Hui
 *
 */
public interface Calculator {
  /**
   * Common method Evaluate() in RevPolishCalc and StandardCalc.
   */
  public float evaluate(String inputString) throws InvalidExpressionException, BadTypeException;
}
