package uk.ac.rhul.cs2800;

/**
 * Custom exception class that throws when the instantiated Entry and return type does not match.
 * 
 * @author Annabelle Wong Poh Hui
 */
public class BadTypeException extends Exception {

  // Default serialVersionID
  private static final long serialVersionUID = 1L;

  /**
   * Constructor for the exception with an output message.
   * 
   * @param message message to be output when exception is thrown
   */
  public BadTypeException(String message) {
    super(message);
  }
}
