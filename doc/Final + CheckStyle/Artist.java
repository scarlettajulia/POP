/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Artist extends Human {
  /**
   * {@inheritDoc} .
   */
  /**
   *  Atribut KAR menyatakan kekuatan Artist.
   */
  private static final int KAR = 1;
  
  /**
   * Konstruktor Artist dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public Artist(final int newx, final int newy) {
    setdeltaX(-1);
    setdeltaY(0);
    setKekuatan(KAR);
    setShape(SAR);
    setX(newx);
    setY(newy);
  }

  /**
   * Prosedur public sing mengeluarkan Lalala (artist bernyanyi).
   */
  public final void sing() {
    System.out.println("Lalala...");
  }
}
