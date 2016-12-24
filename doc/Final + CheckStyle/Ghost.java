/**
 * @author Friska/13514042.
 */
public class Ghost extends Monster {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KAR menyatakan kekuatan Ghost.
   */
  private static final int KG = 3;

  /**
  * Konstruktor Ghost dengan parameter.
  * @param newx sebuah argumen bertipe int menyatakan absis.
  * @param newy sebuah argumen bertipe int menyatakan ordinat.
  */
  public Ghost(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(-1);
    setKekuatan(KG);
    setShape(SG);
    setX(newx);
    setY(newy);
  }

  /**
   * Prosedur public spook mengeluarkan Boo (spook Ghost).
   */
  public final void spook() {
    System.out.println("Boo!!!");
  }
}
