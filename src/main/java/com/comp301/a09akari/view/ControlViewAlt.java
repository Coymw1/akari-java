package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ControlViewAlt implements FXComponent {
  private final AlternateMvcController controller;

  public ControlViewAlt(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    VBox layout = new VBox();
    layout.setMinWidth(100);

    StackPane box = new StackPane();
    box.setMinHeight(controller.getActivePuzzle().getHeight() * 20);
    box.setMinWidth(300);
    box.setMaxWidth(300);
    box.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));

    Button reset = new Button("Reset");
    reset.setOnAction((ActionEvent event) -> controller.clickResetPuzzle());
    reset.setPrefSize(200, 100);
    layout.getChildren().add(box);
    layout.getChildren().add(reset);
    layout.setAlignment(Pos.BASELINE_CENTER);
    layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));

    return layout;
  }
}
