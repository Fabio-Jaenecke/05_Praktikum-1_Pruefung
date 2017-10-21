import java.util.Random;

/**
 * Simuliert Pruefungsergebnisse zum Testen der Pruefungsverwaltung.
 */
public class ZufaelligeNotengebung {

  /**
   * Fuehrt die Simulation aus.
   */
  public void fuehreAus() {
    Pruefungsverwaltung pruefungsverwaltung = new Pruefungsverwaltung();

    for (int i = 0; i < 3; i++) {
      String name = "Max Muster " + i;
      double note = generiereZufaelligePruefungsnote();
      Pruefungsergebnis pruefungsergebnis = new Pruefungsergebnis(name, note);
      pruefungsverwaltung.speichereErgebnis(name, note);
    }
    pruefungsverwaltung.druckeAntworttexte();
  }

  private double generiereZufaelligePruefungsnote() {
    Random generator = new Random();
    double zufallszahlen = 1 + (6 - 1) * generator.nextDouble(); //Zufalldouble zwichen 1 und 6.
    return Math.round(zufallszahlen * 2) / 2.0; //rundet auf 0.5-Noten.
  }
}
