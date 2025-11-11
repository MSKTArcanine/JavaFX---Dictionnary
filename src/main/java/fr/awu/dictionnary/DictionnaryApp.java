package fr.awu.dictionnary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Main app.
 */
public class DictionnaryApp extends Application {

  private final Dictionnary dictionnary = new Dictionnary();

  @Override
  public void start(Stage primaryStage) throws Exception {
    Button btn1 = new Button("Add");
    Button btn2 = new Button("Random");
    Region spacerL = new Region();
    Region spacerR = new Region();
    HBox.setHgrow(spacerL, Priority.ALWAYS);
    HBox.setHgrow(spacerR, Priority.ALWAYS);
    ToolBar tb = new ToolBar(spacerL, btn1, btn2, spacerR);
    BorderPane root = new BorderPane();
    root.setTop(tb);
    root.setCenter(new PracticeView(dictionnary).getView());
    btn1.setOnAction(
        e -> root.setCenter(new PracticeView(dictionnary).getView()));
    btn2.setOnAction(e -> root.setCenter(new InputView(dictionnary).getView()));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
