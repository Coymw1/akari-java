package model;

import java.io.IOException;

public interface ModelObserver {
  /** When a model value is changed, the model calls update() on all active ModelObserver objects */
  void update(ModelImpl model);
}
