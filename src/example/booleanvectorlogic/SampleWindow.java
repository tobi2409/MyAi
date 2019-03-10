package example;

import inspection.InspectionEntry;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.beans.value.ChangeListener;

public class SampleWindow extends Application {

  private SampleFrontEnd sampleFrontEnd = new SampleFrontEnd();

  private Object[] vector = new Object[] {true, true, false, true, true, false, true, true, false, true};

  public static int index = 0;
  public static boolean goal = false;

  private VBox resultView = new VBox();

  public void start(Stage primaryStage) {
    final BorderPane borderPane = new BorderPane();

    HBox menuBar = new HBox();

    Button runButton = new Button("Run");
    runButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        resultView = onRun();
        borderPane.setBottom(resultView);
      }
    });

    Button settingsButton = new Button("Settings");
    settingsButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        onSettings();
      }
    });

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        primaryStage.close();
      }
    });

    menuBar.getChildren().addAll(runButton, settingsButton, exitButton);

    VBox centerPane = new VBox();
    Text vectorInfoText1 = new Text("Vector (= your world):");
    Text vectorInfoText2 = new Text("In this case (SampleVectorLogic) the entries of the world are Booleans, which can be changed by options.");
    Text vectorInfoText3 = new Text("oldState -> change world by options -> newState");
    Text vectorInfoText4 = new Text("Change the state of the vector or change the goal, the focus index");
    Text vectorInfoText5 = new Text("Then you will see the old state for the focus index as well as the necessary option so that the probability of reaching the goal is high.");
    Text vectorInfoText6 = new Text("Focus Index is important because in the real world you also can't see the changes for every place.");

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

    centerPane.getChildren().addAll(vectorInfoText1, vectorInfoText2, vectorInfoText3, vectorInfoText4, vectorInfoText5, vectorInfoText6, checkBoxPane);

    borderPane.setTop(menuBar);
    borderPane.setCenter(centerPane);

    Scene scene = new Scene(borderPane, 900, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("MyAi - Example");
    primaryStage.show();
  }

  private VBox onRun() {
    VBox resultView = new VBox();

    InspectionEntry inspectionEntry = sampleFrontEnd.run(vector, index, new int[] {1, 2}, 2, goal);

    Text headLine = new Text("Possibility for high probability of defined goal (Focus Index: " + index + "; Goal: " + goal + ")");
    Font font = new Font(15);
    headLine.setFont(font);
    resultView.getChildren().add(headLine);

    Text oldValue = new Text("oldValue: " + inspectionEntry.getOldValue());
    resultView.getChildren().add(oldValue);

    Text option = new Text("option: " + inspectionEntry.getOption());
    resultView.getChildren().add(option);

    return resultView;
  }

  private void onSettings() {
    SettingsWindow settingsWindow = new SettingsWindow();
    settingsWindow.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
