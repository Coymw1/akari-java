package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class StatusView implements FXComponent {

  private final AlternateMvcController controller;

  public StatusView(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    VBox layout = new VBox();
    layout.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
    layout.setAlignment(Pos.TOP_CENTER);

    return layout;
  }
}
