package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Evaluates a given input in Reverse Polish Notation; Postfix.
 * 
 * <p>Code inspired from https://stackoverflow.com/questions/14100522/reverse-polish-notation-java
 * 
 * @author Annabelle Wong Poh Hui
 *
 */
public class RevPolishCalc implements Calculator {
  private NumStack evaluationStack = new NumStack(); // only has numbers
  float retVal;

  /**
   * Evaluates a given mathematical expression.
   * 
   * @param inputString mathematical expression input
   * @return the evaluated expression in float
   * @throws InvalidExpressionException thrown when given expression is invalid
   * @throws BadTypeException thrown when the instantiated Entry and return type does not match.
   */
  public float evaluate(String inputString) throws InvalidExpressionException, BadTypeException {
    Scanner input = new Scanner(inputString);
    Symbol[] allSymbols = Symbol.values();

    while (input.hasNext()) {
      String caseInput = "";

      if (input.hasNextFloat()) {
        this.evaluationStack.push(input.nextFloat());
        continue;
      }

      String nextInput = input.next();

      for (int i = 0; i < allSymbols.length; i++) {
        Symbol val = allSymbols[i];
        if (val.toString().equals(nextInput)) {
          caseInput = val.toString();
          continue;
        }
      }

      switch (caseInput) {
        case "+":
          float operand1 = evaluationStack.pop();
          float operand2 = evaluationStack.pop();
          float midway = operand1 + operand2;
          evaluationStack.push(midway);
          break;

        case "-":
          float minOperand1 = evaluationStack.pop();
          float minOperand2 = evaluationStack.pop();
          float minMidway = minOperand2 - minOperand1;
          evaluationStack.push(minMidway);
          break;

        case "*":
          float timOperand1 = evaluationStack.pop();
          float timOperand2 = evaluationStack.pop();
          float timMidway = timOperand1 * timOperand2;
          evaluationStack.push(timMidway);
          continue;

        case "/":
          float divOperand1 = evaluationStack.pop();
          float divOperand2 = evaluationStack.pop();
          float divMidway = divOperand2 / divOperand1;
          evaluationStack.push(divMidway);
          continue;

        default:
          throw new InvalidExpressionException("Expression is not valid");
      }
    }
    input.close();
    if (evaluationStack.isEmpty()) {
      throw new InvalidExpressionException("An empty expression is not valid");
    }
    return evaluationStack.pop();
  }
}
