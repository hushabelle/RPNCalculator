package uk.ac.rhul.cs2800;

/**
 * Custom exception class that throws when an invalid expression is inputed.
 * 
 * @author Annabelle Wong Poh Hui
 *
 */
public class InvalidExpressionException extends Exception {
  // Default serialVersionID
  private static final long serialVersionUID = 1L;

  /**
   * Constructor for the exception with an output message.
   * 
   * @param message message to be output when exception is thrown
   */
  public InvalidExpressionException(String message) {
    super(message);
  }
}
