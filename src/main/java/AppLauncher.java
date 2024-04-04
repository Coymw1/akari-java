import controller.ControllerImpl;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.View;

import java.io.IOException;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) throws IOException {

    // Model
    PuzzleLibraryImpl puzlib = new PuzzleLibraryImpl();
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_01));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_02));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_03));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_04));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_05));
    puzlib.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_06));
    ModelImpl mod = new ModelImpl(puzlib);

    // Controller
    ControllerImpl cont = new ControllerImpl();
    cont.setModel(mod);

    // View
    View view = new View(cont);
    view.setStage(stage);

    // Scene
    Parent rootNode = view.render();
    Scene scene = new Scene(rootNode);
    scene.setFill(Color.TRANSPARENT);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setResizable(true);
    stage.setScene(scene);

    // Refresh view when model changes
    mod.addObserver(
        (ModelImpl m) -> {
          scene.setRoot(view.render());
          stage.setScene(scene);
          //m.getActivePuzzle().outputPuzzle();
        });

    //show stage
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
