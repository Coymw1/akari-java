package view;

import controller.ControllerImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class View implements FXComponent {

  private final ControllerImpl controller;
  private Stage stage;


  public View(ControllerImpl controller) {
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

    ControllerImpl c = fx.getController();
    c.setModel(controller.getModel());
    c.showPuzzle(controller);
    c.setStatusText(controller);
    c.loadIcons();

    return root;
  }

  public void setStage(Stage s) {
    this.stage = s;
  }

}
