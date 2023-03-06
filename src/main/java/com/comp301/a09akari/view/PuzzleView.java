package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PuzzleView implements FXComponent {
  private final AlternateMvcController controller;

  public PuzzleView(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    int width = controller.getActivePuzzle().getWidth();
    int height = controller.getActivePuzzle().getHeight();

    GridPane panel = new GridPane();
    VBox container = new VBox();

    StackPane[][] board = new StackPane[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        StackPane s = new StackPane();
        s.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        Rectangle r = new Rectangle();
        Image img = new Image("file:/resources/light-bulb.png");
        ImageView imgV = new ImageView(img);
        imgV.setFitHeight(10);
        imgV.setFitWidth(10);

        String tileInfo = null;
        if (controller.getActivePuzzle().getCellType(j, i) == CellType.CLUE) {
          tileInfo = String.valueOf(controller.getActivePuzzle().getClue(j, i));
          if (controller.isClueSatisfied(j, i)) {
            s.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
          } else if (controller.isClueOver(j, i)) {
            s.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
          }
        }

        if (controller.getActivePuzzle().getCellType(j, i) == CellType.WALL) {
          s.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        }

        if (controller.getActivePuzzle().getCellType(j, i) == CellType.CORRIDOR) {
          if (controller.isLamp(j, i)) {
            if (controller.isLampIllegal(j, i)) {
              s.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
            } else {
              s.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));
            }
          }
        }

        if (controller.getActivePuzzle().getCellType(j, i) == CellType.CORRIDOR) {
          if (controller.isLit(j, i) && !controller.isLamp(j, i)) {
            s.setBackground(
                new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, null, null)));
          }
        }

        Text t = new Text(tileInfo);
        s.getChildren().addAll(r, t);

        board[i][j] = s;
        board[i][j].setMinSize(40, 40);
        board[i][j].setBorder(
            new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

        int finalJ = j;
        int finalI = i;
        s.setOnMouseClicked(
            e -> {
              if (controller.getActivePuzzle().getCellType(finalJ, finalI) == CellType.CORRIDOR) {
                if (controller.isLamp(finalJ, finalI)) {
                  controller.removeLamp(finalJ, finalI);
                  s.getChildren().remove(imgV);
                } else {
                  controller.addLamp(finalJ, finalI);
                  s.getChildren().add(imgV);
                }
              }
            });
        panel.add(board[i][j], i, j);
        panel.setMaxHeight(40 * height);
        panel.setMaxWidth(40 * width);
      }
    }
    StackPane box = new StackPane();
    box.setMaxHeight(50);

    Image image = new Image("success.png");
    ImageView imageView = new ImageView();
    imageView.setImage(image);
    imageView.setOpacity(0);
    imageView.setPreserveRatio(true);
    imageView.setFitHeight(60);

    if (controller.isSolved()) {
      imageView.setOpacity(100);
    }

    // shows how many puzzles and current puzzle
    StackPane infoContainer = new StackPane();
    Text puzzleInfo =
        new Text(
            "Current puzzle: "
                + (controller.currentPuzzleNum() + 1)
                + " out of "
                + controller.getLibrarySize());
    puzzleInfo.setFont(Font.font("verdana", FontWeight.BOLD, null, 22));
    infoContainer.getChildren().add(puzzleInfo);

    box.getChildren().add(imageView);
    container.getChildren().add(panel);
    container.getChildren().add(box);
    container.getChildren().add(infoContainer);
    container.setAlignment(Pos.CENTER);
    container.setSpacing(20);
    container.maxWidth(400);

    container.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
    return container;
  }
}
