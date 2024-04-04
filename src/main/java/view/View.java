package view;

import controller.ControllerImpl;
import controller.FXMLController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class View {

  private final ControllerImpl controller;
  private Stage stage;


  public View(ControllerImpl controller) {
    this.controller = controller;
  }

  public Parent render() {
    return render(stage);
  }

  public Parent render(Stage s) {
    BorderPane root;
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

    FXMLController viewController = fx.getController();
    viewController.setController(controller);
    viewController.showPuzzle(controller);
    viewController.setStatusText(controller);
    viewController.loadIcons();
    //viewController.showCompleted();

//    Insets bgInsets = new Insets(0);
//    BackgroundFill bgFill = new BackgroundFill(Color.TRANSPARENT, null, bgInsets);
//    root.setBackground(new Background(bgFill));
//    root.setEffect(new DropShadow(BlurType.GAUSSIAN, Color.rgb(70,70, 70), 10, -100, 0, 0));

    return root;
  }

  public void setStage(Stage s) {
    this.stage = s;
  }

}
