/**
 * @author Vitra Chandra/13514043.
 */
public class Knight extends Human {
  /**
   * {@inheritDoc} .
   */
  /**
   *  Atribut KAR menyatakan kekuatan Artist.
   */
  private static final int KK = 7;

  /**
   * Konstruktor Knight dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public Knight(final int newx, final int newy) {
    setdeltaX(1);
    setdeltaY(1);
    setKekuatan(KK);
    setShape(SK);
    setX(newx);
    setY(newy);
  }
}
