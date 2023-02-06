package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller class for JavaFx GUI. Inspired by
 * 
 * @author Annabelle Wong Poh Hui
 *
 */
public class MyView implements ViewInterface {
  RevPolishCalc revPolish = new RevPolishCalc();
  @FXML
  private TextField inputField;

  @FXML
  private Label answerLabel;

  /**
   * aksdhakshf.
   * 
   * @throws BadTypeException asd
   * @throws InvalidExpressionException
   * 
   */
  @FXML
  public void pressed(ActionEvent e) throws InvalidExpressionException, BadTypeException {
    setAnswer(String.valueOf(revPolish.evaluate(getExpression())));
  }

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    answerLabel.setText(answer);
  }

}
