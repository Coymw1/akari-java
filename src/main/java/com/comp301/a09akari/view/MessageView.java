package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MessageView implements FXComponent {

  private final AlternateMvcController controller;

  public MessageView(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    VBox section1 = new VBox();
    VBox section2 = new VBox();
    VBox section3 = new VBox();

    VBox layout = new VBox();

    StackPane textBox = new StackPane();
    textBox.setMinHeight(20);
    Text info = new Text("Black tiles represent walls");

    StackPane textBox2 = new StackPane();
    textBox2.setMinHeight(20);
    Text info2 = new Text("White tiles represent corridors");

    StackPane textBox3 = new StackPane();
    textBox3.setMinHeight(20);
    Text info3 = new Text("Gold tiles represent lamps");

    StackPane textBox4 = new StackPane();
    textBox4.setMinHeight(20);
    Text info4 = new Text("Tiles with numbers represent clues");

    StackPane textBox6 = new StackPane();
    textBox6.setMinHeight(20);
    Text info6 = new Text("If a clue tile turns green, it is satisfied");

    StackPane textBox7 = new StackPane();
    textBox7.setMinHeight(20);
    Text info7 = new Text("If it turns red, there are too many lamps next to it");

    StackPane textBox8 = new StackPane();
    textBox8.setMinHeight(20);
    Text info8 = new Text("If a lamp turns orange, it is placed illegally");

    StackPane textBox9 = new StackPane();
    textBox9.setMinHeight(20);
    Text info9 = new Text("Click to place a lamp");

    StackPane textBox0 = new StackPane();
    textBox0.setMinHeight(20);
    Text info0 = new Text("Light up the puzzle and satisfy all clues to win!");

    StackPane box = new StackPane();
    box.setMinHeight(50);
    box.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

    textBox.getChildren().add(info);
    textBox2.getChildren().add(info2);
    textBox3.getChildren().add(info3);
    textBox4.getChildren().add(info4);
    textBox6.getChildren().add(info6);
    textBox7.getChildren().add(info7);
    textBox8.getChildren().add(info8);
    textBox9.getChildren().add(info9);
    textBox0.getChildren().add(info0);

    section1.getChildren().addAll(textBox, textBox2, textBox3, textBox4);
    section2.getChildren().addAll(textBox6, textBox7, textBox8);
    section3.getChildren().addAll(textBox9, textBox0);

    layout.getChildren().addAll(section1, section2, section3);
    layout.setSpacing(20);
    layout.setMinWidth(300);
    layout.setAlignment(Pos.CENTER);
    layout.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));

    return layout;
  }
}
