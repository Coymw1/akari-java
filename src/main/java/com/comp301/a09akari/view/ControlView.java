package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ControlView implements FXComponent {
  private final AlternateMvcController controller;

  public ControlView(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    HBox container = new HBox();
    HBox layout = new HBox();

    Button prev = new Button("Previous");
    prev.setOnAction(
        (ActionEvent event) -> {
          controller.clickPrevPuzzle();
        });
    layout.getChildren().add(prev);

    Button next = new Button("Next");
    next.setOnAction(
        (ActionEvent event) -> {
          controller.clickNextPuzzle();
        });
    layout.getChildren().add(next);

    Button rand = new Button("Random");
    rand.setOnAction(
        (ActionEvent event) -> {
          controller.clickRandPuzzle();
        });
    layout.getChildren().add(rand);

    layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));
    layout.maxWidth(300);

    layout.setSpacing(50);
    layout.setAlignment(Pos.CENTER);
    container.setMinHeight(75);

    container.getChildren().add(layout);
    container.setAlignment(Pos.CENTER);
    container.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));
    return container;
  }
}
