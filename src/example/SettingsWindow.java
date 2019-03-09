package example;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SettingsWindow {

  public void show() {
    Stage stage = new Stage();

    VBox vBox = new VBox();

    HBox indexInputBox = new HBox();

    Text indexInputText = new Text("Focus Index:");
    TextField indexInputField = new TextField();
    indexInputBox.getChildren().addAll(indexInputText, indexInputField);

    vBox.getChildren().add(indexInputBox);

    Scene scene = new Scene(vBox, 200, 100);

    stage.setScene(scene);
    stage.show();
  }

}
