package view;

import controller.AlternateMvcController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class View implements FXComponent {

  private final AlternateMvcController controller;
  private Stage stage;
  private double xOffset;
  private double yOffset;


  public View(AlternateMvcController controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    return render(stage);
  }

  public Parent render(Stage s) {
    Parent root;
    URL viewUrl = null;
    FXMLLoader fx = new FXMLLoader();

    try {
      viewUrl = new File("src/main/resources/view.fxml").toURI().toURL();
    } catch (MalformedURLException ex) {
      throw new RuntimeException(ex);
    }

    fx.setLocation(viewUrl);

    try {
      root = fx.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


    root.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
      }
    });
    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
      }
    });


//    BorderPane mainLayout = new BorderPane();
//
//    // Controls
//    ControlView controlsView = new ControlView(controller);
//    mainLayout.setTop(controlsView.render());
//
//    // ControlsAlt
//    ControlViewAlt controlsView2 = new ControlViewAlt(controller);
//    mainLayout.setLeft(controlsView2.render());
//
//    // Puzzle
//    PuzzleView puzzleView = new PuzzleView(controller);
//    mainLayout.setCenter(puzzleView.render());
//
//    // Message
//    MessageView messageView = new MessageView(controller);
//    mainLayout.setRight(messageView.render());
//
//    // Status
//    StatusView statusView = new StatusView(controller);
//    mainLayout.setBottom(statusView.render());

    return root;
  }

  public void setStage(Stage s) {
    this.stage = s;
  }

}
