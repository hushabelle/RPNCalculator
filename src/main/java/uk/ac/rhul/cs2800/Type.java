package uk.ac.rhul.cs2800;

/**
 * Enumerator declaration class, provides printables of the Type enumerators.
 * 
 * @author Annabelle Wong Poh Hui
 */
public enum Type {
  /**
   * Input of type float.
   */
  NUMBER,
  /**
   * Input of type symbol, which are operators.
   */
  SYMBOL,
  /**
   * Input of type string.
   */
  STRING,
  /**
   * Invalid input.
   */
  INVALID;


  /**
   * Presents a string that "textually represents" the Type enumerator object.
   * 
   * @param type value to determine the type of enumerator
   * @return the textual representation of objects of type String
   */
  public String toString(Type type) {
    switch (type) {
      case NUMBER:
        return "Number";
      case SYMBOL:
        return "Symbol";
      case STRING:
        return "String";
      case INVALID:
        return "Invalid";
      default:
        return "Invalid"; // because everything other than something recognised is invalid
    }
  }
}
