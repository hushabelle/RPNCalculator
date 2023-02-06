package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Driver class of JavaFx GUI to launch an instance of the JavaFx application.
 * 
 * <p>References code from CS2800 Dave Cohen MVC-seperated demo files with permission.

 * @author Annabelle Wong Poh Hui
 *
 */
public class Driver extends Application {

  /**
   * Launches an instance of the application.
   * 
   * @param args the command line arguments passed to the application. 
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/myView.fxml"));
    Scene scene = new Scene(root, 340, 185);
    primaryStage.setScene(scene);
    primaryStage.show();    
  }
}
