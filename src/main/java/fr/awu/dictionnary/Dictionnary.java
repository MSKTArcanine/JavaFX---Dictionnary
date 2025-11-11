package fr.awu.dictionnary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Dictionnary class.
 **/
public class Dictionnary {
  private final Map<String, String> dict;
  private final List<String> words;
  private final Random random = new Random();

  public Dictionnary() {
    this.dict = new HashMap<>();
    this.words = new ArrayList<>();
  }

  /**
   * Add to dict.
   */
  public void add(final String word, final String translate) {
    if (!this.words.contains(word)) {
      this.words.add(word);
    }
    this.dict.put(word, translate);
  }

  /**
   * get from dict.
   */
  public String get(final String word) {
    if (!this.dict.containsKey(word)) {
      throw new IllegalArgumentException("Word doesn't exist");
    }
    return this.dict.get(word);
  }

  /**
   * get random from dict.
   */
  public String getRandom() {
    return this.words.get(random.nextInt(this.words.size()));
  }
}
