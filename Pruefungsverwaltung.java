import java.util.HashMap;


/**
 * Bietet Funktionalitaeten zum Speichern von Pruefungsergebnissen von einer
 * Vielzahl von Studenten. Aus den gespeicherten Ergebnissen lassen sich
 * personalisierte Antworttext generieren.
 */
public class Pruefungsverwaltung {
  private HashMap<String,Double> ergebnisse = new HashMap<String, Double>();
  private Pruefungsergebnis pruefungsergebnis;

  /**
   * Speichert ein Pruefungsergebnis. Erfasst ein Prüfungsergebnis und weist
   * der Hashmap den Namen und dessen Note zu. Die Note wird auf 0.5 Stellen gerundet.
   * 
   * @param student der StudentenName, der neu hinzugefügt wird.
   * @param note die Note, die dieser Student errreicht hat.
   */
  public void speichereErgebnis(String student, double note) {
      Pruefungsergebnis pruefungsergebnis = new Pruefungsergebnis(student, note);
      ergebnisse.put(pruefungsergebnis.getStudent(), rundeAufHalbeNote(pruefungsergebnis.getNote()));
    }
  

  /**
   * Gibt pro gespeichert Ergebnis einen Text auf die Konsole aus.
   * Je nachdem ob der Kandidate die Pruefung bestanden (>= 4.0) oder nicht
   * bestanden (< 4.0) hat, wird ein Text in folgendem Format ausgegeben:
   * 
   * Sie haben an der Pruefung eine 3.0 erzielt und 
   * sind somit durchgefallen!
   * 
   * Herzliche Gratulation Max Muster! Sie haben an der Pruefung eine 4.5
   * erzielt und somit bestanden!
   */
  public void druckeAntworttexte() {
    /*
     *  Gibt für jeden Studenten, die Note an und gibt entweder das Bestehen
     *  oder Nichtbestehen, zusammen mit der gerundeten Note aus:
     */ 
   
    for (String name : ergebnisse.keySet()){
     if(ergebnisse.get(name) >= 4){
        System.out.println("Herzliche Gratulation " + name + "! Sie haben an der Pruefung eine " + 
        ergebnisse.get(name) + " erzielt und somit bestanden!");
     } else if (ergebnisse.get(name) < 4) {
        System.out.println(name + ", Sie haben der Pruefung eine " 
         + ergebnisse.get(name) + " erzielt und sind somit durchgefallen");  
     }
    }  
  }
  
  
  private double rundeAufHalbeNote(double note) {
    return Math.round(note * 2) / 2.0;
  }
}
