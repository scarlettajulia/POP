import java.util.*;
import java.io.*;

/**
 * @author Friska/13514042.
 */
public class Board {
  /**
   * Atribut private Board berbentuk matriks list.
   */
  private ArrayList<ArrayList<ArrayList<Integer>>> papan;

  /**
   * Prosedur void startBertarung memulai bertarung jika sel penuh.
   * @param listM sebuah argumen bertipe ListMakhluk.
   * @param list sebuah argumen bertipe vektor.
   */
  private void startBertarung(final ListMakhluk listM, final ArrayList<Integer> list) {
  int i = 0;
  int j = 0;
  char x;
  while (i < bWidth) {
    j = 0;
    while (j < bLength) {
    int k = 0;
      while (papan.get(i).get(j).get(k) != -1) {
      k++;
    }
    if (k >= bHeight * bHeight) {
      bertarung(i, j, listM, list);
    }
    j++;
    }
    i++;
  }
  }

  /**
   * Prosedur private Bertarung membunuh satu makhluk jika sel penuh.
   * @param i sebuah argumen bertipe int.
   * @param j sebuah argumen bertipe int.
   * @param listM sebuah argumen bertipe ListMakhluk.
   * @param tempatHapus sebuah argumen bertipe vektor.
   */
  private void bertarung(final int i, final int j, final ListMakhluk listM, final ArrayList<Integer> tempatHapus) {
  int k;
  int kmin = 0;
  int kekuatanMin = listM.get(papan.get(i).get(j).get(0)).getKekuatan();
  for (k = 1; k <= bHeight * bHeight; k++) {
    if (listM.get(papan.get(i).get(j).get(k)).getKekuatan() < kekuatanMin) {
    kmin = k;
    kekuatanMin = listM.get(papan.get(i).get(j).get(k)).getKekuatan();
    }
  }
  tempatHapus.add(papan.get(i).get(j).get(kmin));
  papan.get(i).get(j).set(kmin, -1);
  }

  /**
   * Prosedur deleteHasilBertarung menghapus hasil bertarung dari list.
   * @param listM sebuah argumen bertipe ListMakhluk.
   * @param list sebuah argumen bertipe vektor.
   */
  private void deleteHasilBertarung(final ListMakhluk listM, final ArrayList<Integer> list) {
  Collections.sort(list); //http://beginnersbook.com/2013/12/how-to-sort-arraylist-in-java/
  int sizeVector = list.size();
  int i;
  int indeks;
  for (i = sizeVector - 1; i >= 0; i--) {
    indeks = list.get(i); //http://stackoverflow.com/questions/3920602/get-specific-arraylist-item
    listM.delete(listM.search(listM.get(indeks)));
  }
  }

  /**
   * Prosedur private setElmtBoard untuk mengeset element board.
   * @param c sebuah argumen bertipe int.
   * @param x sebuah argumen bertipe int.
   * @param y sebuah argumen bertipe int.
   * @param z sebuah argumen bertipe int.
   */
  private void setElementBoard(final int c, final int x, final int y, final int z) {
    papan.get(x).get(y).set(z, c);
  }

  /**
   * Prosedur addToBoard menambahkan isi list makhluk ke board.
   * @param listM sebuah argumen bertipe ListMakhluk.
   */
  private void addToBoard(final ListMakhluk listM) {
    for (int i = 0; i < bWidth; i++) {
      for (int j = 0; j < bLength; j++) {
        for (int k = 0; k < bHeight * bHeight; k++) {
          papan.get(i).get(j).set(k, -1);
        }
      }
    }
    v.clear();
    int k = 0;
    for (int i = 0; i < listM.neff(); i++) {
      k = 0;
      while (k < bHeight * bHeight && papan.get(listM.get(i).getX()).get(listM.get(i).getY()).get(k) != -1) {
        k++;
      }
      if (k >= bHeight * bHeight) {
        papan.get(listM.get(i).getX()).get(listM.get(i).getY()).set(k, i);
        bertarung(listM.get(i).getX(), listM.get(i).getY(), listM, v);
        k = 0;
        while (k < bHeight * bHeight && papan.get(listM.get(i).getX()).get(listM.get(i).getY()).get(k) != -1) {
          k++;
        }
        papan.get(listM.get(i).getX()).get(listM.get(i).getY()).set(k, papan.get(listM.get(i).getX()).get(listM.get(i).getY()).get(bHeight * bHeight));
      } else {
        papan.get(listM.get(i).getX()).get(listM.get(i).getY()).set(k, i);
      }
    }
  }

  /**
   * Konstruktor Board tanpa parameter.
   * Membuat board.
   */
  public Board() {
    bWidth = 0;
    bHeight = 0;
    bLength = 0;
    papan = new ArrayList<ArrayList<ArrayList<Integer>>>();
  }

  /**
   * Konstruktor Board dengan parameter.
   * Membuat board berdasarkan parameter.
   * @param x sebuah argumen bertipe int.
   * @param y sebuah argumen bertipe int.
   * @param n sebuah argumen bertipe int.
   */
  public Board(final int x, final int y, final int n) {
  bWidth = x;
  bLength = y;
  bHeight = n;
  papan = new ArrayList<ArrayList<ArrayList<Integer>>>();
  v = new ArrayList<Integer>();
  for (int i = 0; i < bWidth; i++) {
    papan.add(new ArrayList<ArrayList<Integer>>());
    for (int j = 0; j < bLength; j++) {
    papan.get(i).add(new ArrayList<Integer>());
    for (int k = 0; k < bHeight * bHeight + 1; k++) {
      papan.get(i).get(j).add(-1);
    }
    }
  }
  }

  /**
   * Prosedur printBoard untuk mencetak board pada layar.
   * @param listM sebuah argumen bertipe ListMakhluk.
   * @param s sebuah argumen bertipe String.
   */
  public final void printBoard(final ListMakhluk listM, final String s) {
      addToBoard(listM);
      int i;
      int a;
      PrintWriter fout;
    try {
      if (s == "System.out") {
        fout = new PrintWriter(System.out);
      } else {
        fout = new PrintWriter(s);
      }
      fout.print(" ");
      for (a = 1; a <= bLength * bHeight + bLength / 2; a++) {
          fout.print("--");
      }
        fout.println("");
      for (i = 0; i < bWidth; i++) {
        for (int l = 0; l < bHeight; l++) {
          for (int j = 0; j < bLength; j++) {
            fout.print("|");
            for (int k = 0; k < bHeight; k++) {
              if (papan.get(i).get(j).get(k + bHeight * l) != -1) {
                fout.print(listM.get(papan.get(i).get(j).get(k + bHeight * l)).getShape() + " ");
              } else {
                fout.print("  ");
              }
            }
          }
          fout.println("|");
        }
        fout.print(" ");
        for (a = 1; a <= bLength * bHeight + bLength / 2; a++) {
          fout.print("--");
        }
        fout.println("");
      }
      ghostBusterMeetGhost(v, listM);
      deleteHasilBertarung(listM, v);
      fout.flush();
      if (s != "System.out") {
        fout.close();
      }
    } catch (IOException e) {
    }
  }

  /**
   * Atribut v menyatakan vektor.
   */
  private ArrayList<Integer> v;

  /**
   * Atribut bLength menyatakan ukuran panjang Board.
   */
  public int bLength;

  /**
   * Atribut bLength menyatakan ukuran tinggi Board.
   */
  public int bHeight;

  /**
   * Atribut bLength menyatakan ukuran lebar Board.
   */
  public int bWidth;

  /**
   * Fungsi getElementpapan untuk mengembalikan elemen papan.
   * @param i sebuah argumen bertipe int.
   * @param j sebuah argumen bertipe int.
   * @param k sebuah argumen bertipe int.
   * @return (papan.get(i).get(j).get(k)) sebuah elemen papan pada i, j, k.
   */
  public final int getElementpapan(final int i, final int j, final int k) {
    return (papan.get(i).get(j).get(k));
  }

  /**
   * Prosedur ghostBusterMeetGhost.
   * Membunuh semua ghost yang satu sel dengan ghostbuster.
   * @param a sebuah argumen bertipe ArrayList.
   * @param listM sebuah argumen bertipe listM.
   */
  public final void ghostBusterMeetGhost(final ArrayList<Integer> a, final ListMakhluk listM) {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    int i, j, k, toPush;
    boolean alert1, alert2;
    for (i = 0; i < bWidth; i++) {
      for (j = 0; j < bLength; j++) {
        alert1 = false;
        alert2 = false;
        temp.clear();
        for (k = 0; k < bHeight * bHeight; k++) {
          if (getElementpapan(i, j, k) != -1) {
            if (listM.get(getElementpapan(i, j, k)).getShape() == 'G') {
              temp.add(getElementpapan(i, j, k));
              alert1 = true;
            } else if (listM.get(getElementpapan(i, j, k)).getShape() == 'B') {
              alert2 = true;
            }
            if (alert1 && alert2) {
              System.out.println("There is/are ghost and ghostbuster in the same cell. Ghost(s) must die");
              for (int idxtemp = 0; idxtemp < temp.size(); idxtemp++) {
                a.add(temp.get(idxtemp));
              }
              alert1 = false;
            }
          }
        }
      }
    }
  }

  /**
   * Fungsi isInVector.
   * Mengembalikan apakah suatu elemen ada d vektor.
   * @param x sebuah argumen bertipe int.
   * @param list sebuah argumen bertipe vektor.
   * @return hasil boolean yang menyatakan ada pada vektor atau tidak.
   */
  public final boolean isInVector(final int x, final ArrayList<Integer> list) {
    boolean hasil = false;
    for (int i = 0; i < list.size(); i++) {
      if (x == list.get(i)) {
        hasil = true;
      }
    }
    return hasil;
  }
}
