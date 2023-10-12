package view;


import controller.AlternateMvcController;
import controller.ControllerImpl;
import javafx.stage.StageStyle;
import model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    //Stage


    // Model
    PuzzleLibrary puzlib = new PuzzleLibraryImpl();
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_01));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_02));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_03));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_04));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_05));
    Model mod = new ModelImpl(puzlib);

    // Controller
    AlternateMvcController cont = new ControllerImpl(mod);

    // View
    View view = new View(cont);
    view.setStage(stage);

    // Scene
    Scene scene = new Scene(view.render());
    scene.getStylesheets().add("main.css");
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setScene(scene);


    // Refresh view when model changes
    mod.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.setScene(scene);
        });

    // Show the stage
    stage.setTitle("Akari");
    stage.setMinWidth(1000);
    stage.setMinHeight(700);
    stage.setMaxWidth(1200);
    stage.setMaxHeight(800);

    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
