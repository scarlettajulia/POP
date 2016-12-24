/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Monster extends Makhluk {
  /**
   * {@inheritDoc}.
   */
  /**
   * Konstruktor Monster tanpa parameter.
   */
  public Monster() {
    setId(getIdGlobal());
    setX(0);
    setY(0);
  }

  /**
   * Konstruktor Monster dengan parameter.
   * @param newx sebuah parameter bertipe int.
   * @param newy sebuah parameter bertipe int.
   */
  public Monster(final int newx, final int newy) {
    addIdGlobal();
    setId(getIdGlobal());
    setX(newx);
    setY(newy);
  }

  /**
   * Prosedur public move mengatur pergerakan Monster.
   */
  public final void move() {
    setX(getX() + getdeltaX());
    setY(getY() + getdeltaY());
  }
}
