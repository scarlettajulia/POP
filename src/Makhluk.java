/**
 * @author Scarletta Julia Yapfrine/13514074
 */
public abstract class Makhluk {
  /**
   * Atribut SGB menyatakan karakter untuk GhostBuster.
   */
  public static final char SGB = 'B';
  /**
   * Atribut SM menyatakan karakter untuk Military.
   */
  public static final char SM = 'M';
  /**
   * Atribut SK menyatakan karakter untuk Knight.
   */
  public static final char SK = 'K';
  /**
   * Atribut SAR menyatakan karakter untuk Artist.
   */
  public static final char SAR = '*';
  /**
   * Atribut SP menyatakan karakter untuk Predator.
   */
  public static final char SP = 'P';
  /**
   * Atribut SG menyatakan karakter untuk Ghost.
   */
  public static final char SG = 'G';
  /**
   * Atribut SAL menyatakan karakter untuk Alien.
   */
  public static final char SAL = 'A';
  /**
   * Atribut SH menyatakan karakter untuk Military yang bersembunyi.
   */
  public static final char SH = ' ';
  /**
   * Atribut OH menyatakan usia maksimum Human untuk dimatikan.
   */
  public static final int OH = 70;
  /**
   * Atribut TM menyatakan waktu Military bersembunyi.
   */
  public static final int TM = 4;

  /**
   * Atribut shape menyatakan karakter makhluk yang ditampilkan pada board.
   */
  private char shape;
  /**
   * Atribut x bertipe int menyatakan absis makhluk pada board.
   */
  private int x;
  /**
   * Atribut deltaX bertipe int menyatakan perpindahan absis makhluk.
   */
  private int deltaX;
  /**
   * Atribut y bertipe int menyatakan ordinat makhluk pada board.
   */
  private int y;
  /**
   * Atribut deltaY bertipe int menyatakan perpindahan ordinat makhluk.
   */
  private int deltaY;
  /**
   * Atribut kekuatan bertipe int menyatakan kekuatan makhluk.
   */
  private int kekuatan;

  /**
   * Atribut idglobal menyatakan banyak makhluk yang diciptakan.
   */
  private static int idglobal = 0;
  /**
   * Atribut id menyatakan urutan diciptakan makhluk.
   */
  private int id;

  /**
   * Prosedur setdeltaX untuk mengeset deltaX dengan parameter masukan.
   * @param newx sebuah argumen bertipe int.
   */
  protected final void setdeltaX(final int newx) {
    deltaX = newx;
  }

  /**
   * Prosedur setdeltaY untuk mengeset deltaY dengan parameter masukan.
   * @param newy sebuah argumen bertipe int.
   */
  protected final void setdeltaY(final int newy) {
    deltaY = newy;
  }

  /**
   * Prosedur setKekuatan untuk mengeset kekuatan dengan parameter masukan.
   * @param newkekuatan sebuah argumen bertipe int.
   */
  protected final void setKekuatan(final int newkekuatan) {
    kekuatan = newkekuatan;
  }

  /**
   * Prosedur setShape untuk mengeset shape dengan parameter masukan.
   * @param c sebuah argumen bertipe char.
   */
  protected final void setShape(final char c) {
    shape = c;
  }

  /**
  * Prosedur public addIdGlobal untuk inkremen idglobal.
  */
  protected final void addIdGlobal() {
    idglobal++;
  }

  /**
  * Prosedur public setId mengeset id dengan parameter masukan.
  * @param newid sebuah argumen bertipe int
  */
  protected final void setId(final int newid) {
    id = newid;
  }

  /**
   * Fungsi getIdGlobal mengembalikan idglobal.
   * @return idglobal sebuah int yang merupakan id global.
   */
  protected final int getIdGlobal() {
    return idglobal;
  }

  /**
   * Fungsi getId mengembalikan id makhluk.
   * @return id sebuah int yang merupakan id makhluk.
   */
  public final int getId() {
    return id;
  }

  /**
   * Fungsi getX mengembalikan absis makhluk.
   * @return x sebuah int yang merupakan absis makhluk.
   */
  public final int getX() {
    return x;
  }

  /**
   * Fungsi getY mengembalikan ordinat makhluk.
   * @return y sebuah int yang merupakan ordinat makhluk.
   */
  public final int getY() {
    return y;
  }

  /**
   * Fungsi getdeltaX mengembalikan perpindahan absis makhluk.
   * @return deltaX sebuah int yang merupakan perpindahan absis makhluk.
   */
  public final int getdeltaX() {
    return deltaX;
  }

  /**
   * Fungsi getdeltaY mengembalikan perpindahan ordinat makhluk.
   * @return deltaY sebuah int yang merupakan perpindahan ordinat makhluk.
   */
  public final int getdeltaY() {
    return deltaY;
  }

  /**
   * Fungsi getKekuatan mengembalikan kekuatan makhluk.
   * @return kekuatan sebuah int yang merupakan kekuatan makhluk.
   */
  public final int getKekuatan() {
    return kekuatan;
  }

  /**
   * Fungsi getShape mengembalikan karakter yang menyatakan jenis makhluk.
   * @return shape sebuah char yang merupakan karakter makhluk.
   */
  public final char getShape() {
    return shape;
  }

  /**
   * Prosedur setX mengeset nilai x dengan parameter masukan.
   * @param newx sebuah argumen bertipe int.
   */
  public final void setX(final int newx) {
    x = newx;
  }

  /**
   * Prosedur setY mengeset nilai y dengan parameter masukan.
   * @param newy sebuah argumen bertipe int.
   */
  public final void setY(final int newy) {
    y = newy;
  }

  /**
   * Fungsi compare membandingkan id dengan id suatu makhluk.
   * @param m sebuah argumen bertipe Makhluk.
   * @return (id == m.id)
   * yang menyatakan apakah id sama dengan id makhluk.
   */
  public final boolean compare(final Makhluk m) {
    return (id == m.id);
  }


}
