/**
 * @author Friska/13514042.
 */
public class Predator extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   *  Atribut KAR menyatakan kekuatan Alien.
   */
  private static final int KP = 6;

  /**
   * Konstruktor Predator dengan parameter.
   * @param newx sebuah argumen bertipe int.
   * @param newy sebuah argumen bertipe int.
   */
  public Predator(final int newx, final int newy) {
    setdeltaX(-1);
    setdeltaY(-1);
    setKekuatan(KP);
    setShape(SP);
    setX(newx);
    setY(newy);
  }
}
