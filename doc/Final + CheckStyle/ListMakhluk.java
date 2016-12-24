import java.util.ArrayList;

/**
 * @author Chalvin/13514032.
 */
public class ListMakhluk {
  /**
   * Atribut private v bertipe vektor.
   */
  private ArrayList<Makhluk> v;

  /**
   * Konstruktor ListMakhluk tanpa parameter.
   */
  public ListMakhluk() {
    v = new ArrayList<Makhluk>();
  }

  /**
   * Fungsi public IsListEmpty.
   * @return v.isEmpty() menyatakan apakah list kosong.
   */
  public final boolean isListEmpty() {
    return v.isEmpty();
  }

  /**
   * Fungsi public Neff.
   * @return v.size() int ukuran size.
   */
  public final int neff() {
    return v.size();
  }

  /**
   * Fungsi public Search.
   * @param m sebuah argumen bertipe Makhluk.
   * @return v.indexOf(m) int lokasi pada list.
   */
  public final int search(final Makhluk m) {
    return v.indexOf(m);
  }

  /**
   * Prosedur public Insert.
   * @param m sebuah argumen bertipe Makhluk.
   */
  public final void insert(final Makhluk m) {
    boolean added = v.add(m);
  }

  /**
   * Prosedur public Delete menghapus elemen indeks sesuai parameter.
   * @param i sebuah argumen bertipe int.
   */
  public final void delete(final int i) {
    v.remove(i);
  }

  /**
   * Fungsi public Get mengembalikan nilai elemen ke-i(parameter input).
   * @param i sebuah argumen bertipe int.
   * @return v.get(i) Makhluk elemen ke-i.
   */
  public final Makhluk get(final int i) {
    return v.get(i);
  }
}
