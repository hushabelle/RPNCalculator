package uk.ac.rhul.cs2800;

/**
 * Enumerator declaration class, provides printables of the Symbol enumerators.
 * 
 * @author Annabelle Wong Poh Hui
 */
public enum Symbol {
  /**
   * Left bracket.
   */
  LEFT_BRACKET("("),
  /**
   * Right bracket.
   */
  RIGHT_BRACKET(")"),
  /**
   * Multiplication.
   */
  TIMES("*"),
  /**
   * Division.
   */
  DIVIDE("/"),
  /**
   * Addition.
   */
  PLUS("+"),
  /**
   * Subtraction.
   */
  MINUS("-"),
  /**
   * Invalid symbol.
   */
  INVALID("Invalid");

  private String operator; // information attached to the symbols


  private Symbol(String operator) {
    this.operator = operator;
  }


  /**
   * Presents a string that "textually represents" the Symbol enumerator object.
   */
  public String toString() {
    return this.operator;
  }
}
