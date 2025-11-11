package fr.awu.dictionnary;

/**
 * jsaipo.
 */
public final class SystemInfo {

  private SystemInfo() {
    // Prevent instantiation
  }

  public static String javaVersion() {
    return System.getProperty("java.version");
  }

  public static String javafxVersion() {
    return System.getProperty("javafx.version");
  }
}
