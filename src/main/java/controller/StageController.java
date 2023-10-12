package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StageController {

    @FXML
    private TextArea currentPuzzle;

    @FXML
    private Pane exitButton;

    @FXML
    private Pane maxButton;

    @FXML
    private Pane minButton;

    @FXML
    private Pane puzzleContainer;

    @FXML
    private Pane statusBox;

    @FXML
    private Pane topBar;

    @FXML
    public void initialize() {

    }

    @FXML
    void dragStage(MouseEvent event) {
        topBar.setStyle("-fx-background-color: #111111");
    }

}
