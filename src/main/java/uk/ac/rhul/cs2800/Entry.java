package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * A container class for either a Float, a String or a symbol.
 * 
 * @author Annabelle Wong Poh Hui
 */
public class Entry {
  private float number;
  private Symbol symbol;
  private String str;
  private Type type;

  /**
   * Constructor for Entry with no parameters.
   * 
   */
  public Entry() {
    this.type = Type.INVALID;
  }

  /**
   * Constructor for Entry object of Type NUMBER which holds a float value.
   * 
   * @param inputNumber value to initialise number object
   */
  public Entry(float inputNumber) {
    this.number = inputNumber;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor for Entry object of Type SYMBOL which holds a symbol.
   * 
   * @param inputSymbol value to initialise symbol object
   */
  public Entry(Symbol inputSymbol) {
    this.symbol = inputSymbol;
    this.type = Type.SYMBOL;

  }

  /**
   * Constructor for Entry object of Type STRING which holds a string.
   * 
   * @param inputStr value to initialise string object
   */
  public Entry(String inputStr) {
    this.str = inputStr;
    this.type = Type.STRING;

  }

  /**
   * Getter of float value.
   * 
   * @return the number object value
   * @throws BadTypeException thrown when initialised Entry and return types do not match
   */
  public float getNumber() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException("Mismatched Entry and return type");
    }
    return this.number;
  }

  /**
   * Getter of symbol value.
   * 
   * @return the value of symbol object
   * @throws BadTypeException thrown when initialised Entry and return types do not match
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException("Mismatched Entry and return type");
    }
    return this.symbol;
  }

  /**
   * Getter of string value.
   * 
   * @return the value of string object
   * @throws BadTypeException thrown when initialised Entry and return types do not match
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException("Mismatched Entry and return value");
    }
    return this.str;
  }

  /**
   * Getter of type value.
   * 
   * @return the value of type object
   */
  public Type getType() {
    return this.type;
  }

  /**
   * HashCode overridden.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, str, symbol, type);
  }

  /**
   * Equals overridden.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && Objects.equals(str, other.str) && symbol == other.symbol && type == other.type;
  }



}
