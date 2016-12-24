/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Alien extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   *  Atribut KAR menyatakan kekuatan Alien.
   */
  private static final int KAL = 4;

  /**
   * Konstruktor Alien dengan parameter.
   * @param newx sebuah argumen bertipe int menyatakan absis.
   * @param newy sebuah argumen bertipe int menyatakan ordinat.
   */
  public Alien(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KAL);
    setShape(SAL);
    setX(newX);
    setY(newy);
  }
}
