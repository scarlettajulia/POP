/**
 * @author Chalvin/13514032.
 */
public class GhostBuster extends Human {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KGB menyatakan kekuatan GhostBuster.
   */
  private static final int KGB = 2;

  /**
   * Konstruktor GhostBuster dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public GhostBuster(final int newx, final int newy) {
    setdeltaX(1);
    setdeltaY(0);
    setKekuatan(KGB);
    setShape(SGB);
    setX(newx);
    setY(newy);
  }
}
