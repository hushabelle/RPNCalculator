package uk.ac.rhul.cs2800;

/**
 * How we want to interact with our calculator. Defines the data and provides hooks for
 * notification and insertion of observers.
 * References code from CS2800 Dave Cohen MVC-seperated demo files with permission.
 * 
 * @author Annabelle Wong Poh Hui
 */
public interface ViewInterface {
  /**
   * A hook to get the arithmetic expression to be evaluated.
   * 
   * @return the expression
   */
  String getExpression();
  
  /**
   * A hook to show the user the evaluated answer.
   * 
   * @param answer the answer
   */
  void setAnswer(String answer);
}

