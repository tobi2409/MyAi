// java -cp AI-0.0.1-SNAPSHOT.jar example.SampleWindow

package example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import inspection.InspectionEntry;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.collections.ListChangeListener;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.value.ChangeListener;

public class SampleWindow extends Application {

  private SampleFrontEnd sampleFrontEnd = new SampleFrontEnd();

  private Object[] vector = new Object[] {true, true, false, true, true, false, true, true, false, true};

  private VBox resultView = new VBox();

  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();

    HBox menuBar = new HBox();

    Button runButton = new Button("Run");
    runButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        onRun();
      }
    });

    Button settingsButton = new Button("Settings");
    settingsButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        onSettings();
      }
    });

    Button optionSimulatorButton = new Button("What are Options?");
    Button exitButton = new Button("Exit");

    menuBar.getChildren().addAll(runButton, settingsButton, optionSimulatorButton, exitButton);

    HBox checkBoxPane = new HBox();
    for (int i = 0 ; i < vector.length ; i++) {
      CheckBox checkBox = new CheckBox();
      checkBox.setSelected((Boolean) vector[i]);
      checkBox.setText((Boolean) vector[i] ? "1" : "0");

      final int finalIndex = i;
      checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          vector[finalIndex] = newValue;
          checkBox.setText(newValue ? "1" : "0");
        }
      });

      checkBoxPane.getChildren().add(checkBox);
    }

    borderPane.setTop(menuBar);
    borderPane.setCenter(checkBoxPane);
    borderPane.setBottom(resultView);

    Scene scene = new Scene(borderPane, 500, 100);
    primaryStage.setScene(scene);
    //primaryStage.setTitle("MyAi - Example")
    primaryStage.show();
  }

  private void onRun() {
    InspectionEntry inspectionEntry = sampleFrontEnd.run(vector, 0, new int[] {1, 2}, 2, false);

    Text headLine = new Text("Possibility for high probability of defined goal");
    resultView.getChildren().add(headLine);

    Text oldValue = new Text("oldValue: " + inspectionEntry.getOldValue());
    resultView.getChildren().add(oldValue);

    Text option = new Text("option: " + inspectionEntry.getOption());
    resultView.getChildren().add(option);
  }

  private void onSettings() {
    SettingsWindow settingsWindow = new SettingsWindow();
    settingsWindow.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
