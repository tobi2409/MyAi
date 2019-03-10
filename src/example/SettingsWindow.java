package example;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class SettingsWindow {

  public void show() {
    Stage stage = new Stage();

    VBox vBox = new VBox();

    HBox indexInputBox = new HBox();

    Text indexInputText = new Text("Focus Index:");
    TextField indexInputField = new TextField();
    indexInputField.setText(String.valueOf(SampleWindow.index));
    indexInputBox.getChildren().addAll(indexInputText, indexInputField);

    HBox goalInputBox = new HBox();

    Text goalInputText = new Text("Your Goal:");
    ComboBox goalInputField = new ComboBox();
    goalInputField.getItems().addAll("1", "0");
    goalInputField.getSelectionModel().select(SampleWindow.goal ? "1" : "0");
    goalInputBox.getChildren().addAll(goalInputText, goalInputField);

    HBox buttonBox = new HBox();
    Button okButton = new Button("OK");
    okButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        SampleWindow.index = Integer.valueOf(indexInputField.getText());
        String goalString = goalInputField.getSelectionModel().getSelectedItem().toString();
        SampleWindow.goal = goalString.equals("1");
        stage.close();
      }
    });

    Button cancelButton = new Button("Cancel");
    cancelButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        stage.close();
      }
    });

    buttonBox.getChildren().addAll(okButton, cancelButton);

    vBox.getChildren().addAll(indexInputBox, goalInputBox, buttonBox);

    Scene scene = new Scene(vBox, 200, 100);

    stage.setScene(scene);
    stage.setTitle("Settings");
    stage.show();
  }

}
