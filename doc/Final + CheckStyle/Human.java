/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Human extends Makhluk {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut private umur bertipe int.
   */
  private int umur;

  /**
   * Prosedur protected setUmur untuk mengeset umur Human.
   * @param newx sebuah argumen bertipe int.
   */
  protected final void setUmur(final int newx) {
    umur = newx;
  }

  /**
   * Konstrutor Human tanpa parameter.
   */
  public Human() {
    setId(getIdGlobal());
    setUmur(0);
    setX(0);
    setY(0);
  }

  /**
   * Konstruktor Human dengan parameter.
   * @param newx sebuah argumen bertipe int yang menyatakan absis.
   * @param newy sebuah argumen bertipe int yang menyatakan ordinat.
   */
  public Human(final int newx, final int newy) {
    addIdGlobal();
    setId(getIdGlobal());
    setUmur(0);
    setX(newx);
    setY(newy);
  }

   /**
   * Fungsi public getUmur mengembalikan umur Human.
   * @return umur sebuah int.
   */
    public final int getUmur() {
    return umur;
  }

  /**
   * Prosedur public AddUmur menambahkan umur Human sebanyak 1.
   */
    public final void addUmur() {
    umur++;
  }

  /**
   * Prosedur public move mengatur pergerakan Human.
   */
    public final void move() {
    setX(getX() + getdeltaX());
    setY(getY() + getdeltaY());
    addUmur();
  }
}
