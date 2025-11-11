package fr.awu.dictionnary;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * oui.
 */
public class PracticeView {
  private final Dictionnary dictionnary;

  public PracticeView(Dictionnary dictionnary) {
    this.dictionnary = dictionnary;
  }

  /**
   * oui.
   */
  public Parent getView() {
    GridPane layout = new GridPane();
    layout.setHgap(8);
    layout.setVgap(8);
    Label practiceText = new Label();
    TextField practiceField = new TextField();
    Label status = new Label();

    if (dictionnary.size() == 0) {
      practiceText.setText("Add words first");
      practiceField.setDisable(true);
      layout.add(practiceText, 0, 0);
      layout.add(practiceField, 1, 0);
      layout.add(status, 0, 1);
      return layout;
    }

    StringProperty currentWord = new SimpleStringProperty(
        dictionnary.getRandom());
    StringProperty inputText = new SimpleStringProperty("");

    practiceText.textProperty().bind(currentWord);
    inputText.bindBidirectional(practiceField.textProperty());
    BooleanBinding ok = Bindings.createBooleanBinding(
        () -> inputText.get().equals(dictionnary.get(currentWord.get())),
        inputText, currentWord);
    status.textProperty().bind(Bindings.when(ok).then("ok").otherwise("non"));
    ok.addListener((obs, was, is) -> {
      if (is) {
        practiceField.clear();
        String next = dictionnary.getRandom();
        currentWord.set(next);
      }
    });
    layout.add(practiceText, 0, 0);
    layout.add(practiceField, 1, 0);
    layout.add(status, 0, 1);
    return layout;
  }
}
