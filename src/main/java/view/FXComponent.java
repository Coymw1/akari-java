package view;

import javafx.scene.Parent;

import java.io.IOException;

public interface FXComponent {
  /** Render the component and return the resulting Parent object */
  Parent render() throws IOException;
}
