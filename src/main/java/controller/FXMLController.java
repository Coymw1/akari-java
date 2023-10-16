package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ModelImpl;
import model.PuzzleImpl;
import view.PuzzleView;

public class FXMLController {

  //FXML Controller handles all the scene builder events
  //needs to store the main controller in order to get info from the model (to render with)
  //separated from controllerImpl (was too confusing)
  ControllerImpl modelController;

  private double xOffset;
  private double yOffset;
  public FXMLController() {

  }
  public void setController(ControllerImpl cont) {this.modelController = cont;}
  @FXML
  private HBox iconBox;
  @FXML
  private HBox titleBox;
  @FXML
  private TextField currentPuzzle;
  @FXML
  private HBox exitButton;
  @FXML
  private HBox maxButton;
  @FXML
  private HBox minButton;
  @FXML
  private HBox randomBox;
  @FXML
  private TextField randomText;
  @FXML
  private HBox resetBox;
  @FXML
  private TextField resetText;
  @FXML
  private HBox nextButtonBox;
  @FXML
  private HBox prevButtonBox;
  @FXML
  private HBox puzzleContainer;
  @FXML
  private HBox completedBox;
  @FXML
  private Pane topBar;

  @FXML
  public void initialize() {}
  @FXML
  public void showPuzzle(ControllerImpl c) {
    PuzzleView pv = new PuzzleView(c);
    if (modelController.isSolved()) {
      puzzleContainer.getChildren().add(pv.render(true));
    } else {puzzleContainer.getChildren().add(pv.render(false));}

    puzzleContainer.setAlignment(Pos.CENTER);
  }
  @FXML
  public void showCompleted() {
    ImageView completed = new ImageView(new Image("img/completed.png"));
    if (!modelController.isSolved()) {
      completed.setOpacity(0);
    } else {completed.setOpacity(100);}
    completed.setFitHeight(300);
    completed.setFitWidth(300);
    completedBox.getChildren().add(completed);
    completedBox.setAlignment(Pos.CENTER);


  }
  @FXML
  public void loadIcons() {
    ImageView minIcon = new ImageView(new Image("img/min.png"));
    ImageView maxIcon = new ImageView(new Image("img/max.png"));
    ImageView exitIcon = new ImageView(new Image("img/close.png"));
    ImageView nextIcon = new ImageView(new Image("img/next.png"));
    ImageView prevIcon = new ImageView(new Image("img/prev.png"));
    ImageView mainIcon = new ImageView(new Image("img/bulb.png"));
    ImageView title = new ImageView(new Image("img/title.png"));


    minIcon.setFitHeight(1); maxIcon.setFitHeight(10); exitIcon.setFitHeight(10); nextIcon.setFitHeight(15); prevIcon.setFitHeight(15); mainIcon.setFitHeight(41); title.setFitHeight(100);
    minIcon.setFitWidth(10); maxIcon.setFitWidth(10); exitIcon.setFitWidth(10); nextIcon.setFitWidth(10); prevIcon.setFitWidth(10); mainIcon.setFitWidth(30); title.setFitWidth(200);

    minButton.getChildren().add(minIcon);
    minButton.setAlignment(Pos.CENTER);

    maxButton.getChildren().add(maxIcon);
    maxButton.setAlignment(Pos.CENTER);

    exitButton.getChildren().add(exitIcon);
    exitButton.setAlignment(Pos.CENTER);

    nextButtonBox.getChildren().add(nextIcon);
    nextButtonBox.setAlignment(Pos.CENTER);

    prevButtonBox.getChildren().add(prevIcon);
    prevButtonBox.setAlignment(Pos.CENTER);

    iconBox.getChildren().add(mainIcon);
    iconBox.setAlignment(Pos.CENTER);

    titleBox.getChildren().add(title);
    titleBox.setAlignment(Pos.CENTER);
  }
  @FXML
  public void setStatusText(ControllerImpl c) {
    currentPuzzle.setText("Current puzzle: " + (modelController.currentPuzzleNum() + 1) + " out of " + modelController.getLibrarySize());
  }
  @FXML
  void dragStage(MouseEvent event) {
    Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();
    stage.setX(event.getScreenX() + xOffset);
    stage.setY(event.getScreenY() + yOffset);
  }
  @FXML
  void pressTopBar(MouseEvent event) {
    Stage stage = (Stage) ((Pane) event.getSource()).getScene().getWindow();
    xOffset = stage.getX() - event.getScreenX();
    yOffset = stage.getY() - event.getScreenY();
  }

  @FXML
  void prevExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void prevHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void prevClick(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void prevPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void prevReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void nextExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void nextHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void nextClick(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void nextPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void nextReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void randomExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void randomHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void randomClicked(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void randomPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void randomReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void resetExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void resetHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void resetClicked(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void resetPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void resetReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void handleExitOnClick(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void exitExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void exitHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void exitPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void exitReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void handleMaxOnClick(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void maxExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void maxHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void maxPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void maxReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void handleMinOnClick(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void minExited(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void minHover(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void minPressed(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}
  @FXML
  void minReleased(MouseEvent event) {responsiveUIHelper((Region) event.getSource(), event);}

  //sets element color, and may do something based on event and region (what button was clicked)
  void responsiveUIHelper(Region r, MouseEvent e) {
    String col = "";

    //mouse enter is for hover (mouse entered node area)
    if (e.getEventType().getName() == "MOUSE_ENTERED") {
      if (r.getId().equals("minButton")) {col = "#da9395";}
      if (r.getId().equals("maxButton")) {col = "#da9395";}
      if (r.getId().equals("exitButton")) {col = "#ff3c05";}
      if (r.getId().equals("prevButtonBox")) {col = "#7198ca";}
      if (r.getId().equals("nextButtonBox")) {col = "#7198ca";}
      if (r.getId().equals("resetBox") || r.getId().equals("resetText")) {col = "#d87e5d";}
      if (r.getId().equals("randomBox") || r.getId().equals("randomText")) {col = "#d87e5d";}
      r.setStyle("-fx-background-color: " + col);
    }

    //mouse presses change color
    if (e.getEventType().getName() == "MOUSE_PRESSED") {
      if (r.getId().equals("minButton")) {col = "#be4144";}
      if (r.getId().equals("maxButton")) {col = "#be4144";}
      if (r.getId().equals("exitButton")) {col = "#af2600";}
      if (r.getId().equals("prevButtonBox")) {col = "#4e7198";}
      if (r.getId().equals("nextButtonBox")) {col = "#4e7198";}
      if (r.getId().equals("resetBox") || r.getId().equals("resetText")) {col = "#af4d2a";}
      if (r.getId().equals("randomBox") || r.getId().equals("randomText")) {col = "#af4d2a";}

      r.setStyle("-fx-background-color: " + col);
    }

    //releasing mouse and not hovering should change color back to original
    if (e.getEventType().getName() == "MOUSE_RELEASED" || e.getEventType().getName() == "MOUSE_EXITED") {
      if (r.getId().equals("minButton")) {col = "#cc686b";}
      if (r.getId().equals("maxButton")) {col = "#cc686b";}
      if (r.getId().equals("exitButton")) {col = "#cc686b";}
      if (r.getId().equals("prevButtonBox")) {col = "#668ab1";}
      if (r.getId().equals("nextButtonBox")) {col = "#668ab1";}
      if (r.getId().equals("resetBox") || r.getId().equals("resetText")) {col = "#cf5f37";}
      if (r.getId().equals("randomBox") || r.getId().equals("randomText")) {col = "#cf5f37";}

      r.setStyle("-fx-background-color: " + col);
    }

    //mouse clicks call methods for functions the buttons represent
    if (e.getEventType().getName() == "MOUSE_CLICKED") {
      if (r.getId().equals("minButton")) {
        Stage stage = (Stage) ((HBox) e.getSource()).getScene().getWindow();
        stage.setIconified(true);
      }
      if (r.getId().equals("maxButton")) {
        Boolean fullStatus = false;
        Stage stage = (Stage) ((HBox) e.getSource()).getScene().getWindow();
        if (fullStatus) {fullStatus = false;}
        else {fullStatus = true;}
        stage.setFullScreen(fullStatus);
      }
      if (r.getId().equals("exitButton")) {
        Stage stage = (Stage) ((HBox) e.getSource()).getScene().getWindow();
        stage.close();
      }
      if (r.getId().equals("prevButtonBox")) {modelController.clickPrevPuzzle();}
      if (r.getId().equals("nextButtonBox")) {modelController.clickNextPuzzle();}
      if (r.getId().equals("resetBox") || r.getId().equals("resetText")) {modelController.clickResetPuzzle();}
      if (r.getId().equals("randomBox") || r.getId().equals("randomText")) {modelController.clickRandPuzzle();}
    }
  }

}
