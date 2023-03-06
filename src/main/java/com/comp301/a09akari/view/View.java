package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class View implements FXComponent {

  private final AlternateMvcController controller;

  public View(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    BorderPane mainLayout = new BorderPane();

    // Controls
    ControlView controlsView = new ControlView(controller);
    mainLayout.setTop(controlsView.render());

    // ControlsAlt
    ControlViewAlt controlsView2 = new ControlViewAlt(controller);
    mainLayout.setLeft(controlsView2.render());

    // Puzzle
    PuzzleView puzzleView = new PuzzleView(controller);
    mainLayout.setCenter(puzzleView.render());

    // Message
    MessageView messageView = new MessageView(controller);
    mainLayout.setRight(messageView.render());

    // Status
    StatusView statusView = new StatusView(controller);
    mainLayout.setBottom(statusView.render());

    return mainLayout;
  }
}
