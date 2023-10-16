package view;

import controller.ControllerImpl;
import model.CellType;
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
import org.w3c.dom.css.RGBColor;

public class PuzzleView {
  private final ControllerImpl controller;
  private Parent container;

  public PuzzleView(ControllerImpl controller) {
    this.controller = controller;
  }

  public Parent render(Boolean completionStatus) {

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
                new Background(new BackgroundFill(Color.valueOf("#fffe88"), null, null)));
          }
        }


        //highlights border of all edge squares depending on the completion status of the puzzle
        //-fx-border-style: top right bottom left
        //follow the above order when concatenating string
        String widthStyle = "-fx-border-width: ";
        String colorStyle = "-fx-border-color: ";
        if (completionStatus) {
          //if i == 0, square is on left, and if j == 0, square is on at the top
          if (j == 0) {
            colorStyle = colorStyle + "#80ef2c ";
            widthStyle = widthStyle + "3 ";
          } else {
            colorStyle = colorStyle + "#111111 ";
            widthStyle = widthStyle + "1 ";
          }

          if (i == width - 1) {
            colorStyle = colorStyle + "#80ef2c ";
            widthStyle = widthStyle + "3 ";
          } else {
            colorStyle = colorStyle + "#111111 ";
            widthStyle = widthStyle + "1 ";
          }

          if (j == width - 1) {
            colorStyle = colorStyle + "#80ef2c ";
            widthStyle = widthStyle + "3 ";
          } else {
            colorStyle = colorStyle + "#111111 ";
            widthStyle = widthStyle + "1 ";
          }

          if (i == 0) {
            colorStyle = colorStyle + "#80ef2c; ";
            widthStyle = widthStyle + "3;";
          } else {
            colorStyle = colorStyle + "#111112; ";
            widthStyle = widthStyle + "1;";
          }

          s.setStyle(colorStyle + widthStyle);

        }


        //formatting clue text
        Text t = new Text(tileInfo);
        t.setStyle("-fx-font: Montserrat");
        t.setStyle("-fx-font-size: 18pt");
        s.getChildren().addAll(r, t);


        //determining the size of each square
          // minW must be equal to minH
        board[i][j] = s;
        int minW = 40;
        if (width > 10 || height > 10) {minW = 25;}
        int minH = minW;
        board[i][j].setMinSize(minW, minH);
        board[i][j].setBorder(
            new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));

        //handling lamp controls
        int finalJ = j;
        int finalI = i;

        s.setOnMouseClicked(
            e -> {
              if (controller.getActivePuzzle().getCellType(finalJ, finalI) == CellType.CORRIDOR) {
                if (controller.isLamp(finalJ, finalI)) {
                  controller.removeLamp(finalJ, finalI);
                } else {
                  controller.addLamp(finalJ, finalI);
                }
              }
            });
        panel.add(board[i][j], i, j);
        panel.setMaxHeight(40 * height);
        panel.setMaxWidth(40 * width);
      }
    }

    container.getChildren().add(panel);
    container.setAlignment(Pos.CENTER);
    container.setSpacing(20);

    this.container = container;
    return container;
  }
}
