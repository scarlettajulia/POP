/**
 * @author Scarletta Julia Yapfrine/13514074.
 */
public class Military extends Human {
  /**
   * {@inheritDoc}.
   */
  /**
   * Atribut KM menyatakan kekuatan Military.
   */
  private static final int KM = 5;

  /**
   * Atribut private turn menyatakan lama Military bersembunyi.
   */
  private int turn;

  /**
   * Konstruktor Military dengan parameter.
   * @param newx sebuah argumen bertipe int menyatakan absis.
   * @param newy sebuah argumen bertipe int menyatakan ordinat.
   */
  public Military(final int newx, final int newy) {
    setdeltaX(0);
    setdeltaY(1);
    setKekuatan(KM);
    setShape(SM);
    setTurn(0);
    
    setX(newx);
    setY(newy);
  }

  /**
   * Prosedur public setTurn.
   * Mengeset turn Military berdasarkan parameter masukan.
   * @param newx sebuah argumen bertipe int.
   */
    public final void setTurn(final int newx) {
    turn = newx;
  }

  /**
   * Fungsi public getTurn mengembalikan turn Military.
   * @return turn sebuah int yang menyatakan turn Military.
   */
    public final int getTurn() {
    return turn;
  }

  /**
   * Prosedur public camouflage menyembunyikan Military pada board.
   */
    public final void camouflage() {
    setShape(SH);
  }

  /**
   * Prosedur public uncamouflage.
   * Memunculkan kembali Military pada board.
   */
    public final void uncamouflage() {
    setShape(SM);
  }
}
