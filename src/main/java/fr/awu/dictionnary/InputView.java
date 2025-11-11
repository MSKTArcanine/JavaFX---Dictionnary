package fr.awu.dictionnary;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * inputview.
 */
public class InputView {
  private final Dictionnary dictionary;

  public InputView(Dictionnary dictionary) {
    this.dictionary = dictionary;
  }

  /**
   * oui.
   */
  public Parent getView() {
    GridPane layout = new GridPane();
    Label wordLbl = new Label("Entrez un mot");
    TextField wordField = new TextField();
    Label translateLbl = new Label("Entrez la trad");
    TextField translateField = new TextField();
    Button addButton = new Button("Add");

    layout.add(wordLbl, 0, 0);
    layout.add(wordField, 1, 0);
    layout.add(translateLbl, 0, 1);
    layout.add(translateField, 1, 1);
    layout.add(addButton, 1, 2);

    addButton.setOnAction(e -> {
      this.dictionary.add(
          wordField.getText(),
          translateField.getText());
      wordField.clear();
      translateField.clear();
    });

    return layout;
  }
}
