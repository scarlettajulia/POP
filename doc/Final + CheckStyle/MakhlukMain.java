import java.util.*;
import java.io.*;

/**
 * @author Vitra Chandra/13514043.
 */
public class MakhlukMain {
    /**
     * Atribut listM adalah sebuah list makhluk.
     */
    private static ListMakhluk listM;
    /**
     * Atribut board adalah sebuah board.
     */
    private static Board board;
    /**
     * Atribut rand untuk atribut random.
     */
    private static Random rand;
    /**
     * Atribut rx merupakan hasil random x.
     * Atribut ry merupakan hasil random y.
     */
    private static int rx, ry;

    /**
     * Prosedur addMakhluk.
     * Menambahkan makhluk ke list.
     * @param list sebuah argumen bertipe ListMakhluk.
     */
    private static void addMakhluk(final ListMakhluk list) {
        int jenis = rand.nextInt(11) + 1;
        Makhluk m;

        int y = rand.nextInt(board.bWidth);
        int x = rand.nextInt(board.bLength);
        rx = x;
        ry = y;
        if (jenis == 1) {
            m = new Predator(y, x);
            list.insert(m);
        } else if (jenis == 2) {
            m = new Ghost(y, x);
            list.insert(m);
        } else if (jenis == 3) {
            m = new Alien(y, x);
            list.insert(m);
        } else if (jenis == 4 || jenis == 5) {
            m = new Military(y, x);
            list.insert(m);
        } else if (jenis == 6 || jenis == 7) {
            m = new Knight(y, x);
            list.insert(m);
        } else if (jenis == 8 || jenis == 9) {
            m = new Artist(y, x);
            list.insert(m);
        } else if (jenis == 10 || jenis == 11) {
            m = new GhostBuster(y, x);
            list.insert(m);
        }
    }

    /**
     * Prosedur init untuk menginisialisasi list makhluk.
     * @param list sebuah argumen bertipe ListMakhluk final.
     */
    private static void init(final ListMakhluk list) {
        int jumlah = 1;
        for (int it = 1; it <= jumlah; it++) {
            addMakhluk(list);
        }
    }

    /**
     * Prosedur moveL untuk menembus batas-batas sel board.
     * @param it sebuah argumen bertipe int final.
     */
    private static void moveL(final int it) {
          if (listM.get(it).getX() + listM.get(it).getdeltaX() < 0) {
            listM.get(it).setX(listM.get(it).getX() + listM.get(it).getdeltaX() + board.bWidth);
          } else {
            listM.get(it).setX((listM.get(it).getX() + listM.get(it).getdeltaX()) % board.bWidth);
          }
        if ((listM.get(it).getY() + listM.get(it).getdeltaY()) < 0) {
            listM.get(it).setY(listM.get(it).getY() + listM.get(it).getdeltaY() + board.bLength);
        } else {
            listM.get(it).setY((listM.get(it).getY() + listM.get(it).getdeltaY()) % board.bLength);
        }
    }

    /**
     * Main program.
     * @param argc sebuah argumen bertipe String final.
     * @throws InterruptedException.
     */
    public static void main(final String argc[]) throws InterruptedException {
        board = new Board(3, 3, 3);
        boolean stop = false;
        boolean step = false;
        int key;
        KeyListeners t = new KeyListeners("Control Board");
        ArrayList<Integer> tempatHapus = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        listM = new ListMakhluk();
        rand = new Random();

        init(listM);
        do {
            do {
                for (int it = 0; it < listM.neff(); it++) {
                    moveL(it);
                    if (listM.get(it) instanceof Military) {
                        if (((Military) listM.get(it)).getTurn() >= Makhluk.TM) {
                            if (((Military) listM.get(it)).getShape() == Makhluk.SM) {
                                ((Military) listM.get(it)).camouflage();
                            } else {
                                ((Military) listM.get(it)).uncamouflage();
                            }
                            ((Military) listM.get(it)).setTurn(0);
                        } else {
                            ((Military) listM.get(it)).setTurn(((Military) listM.get(it)).getTurn() + 1);
                        }
                    }
                }
                System.out.print("\033[H\033[2J");
                board.printBoard(listM, "System.out");
                for (int it = 0; it < listM.neff(); it++) {
                    System.out.print(listM.get(it).getShape() + " ");
                }
                System.out.println("");

                for (int it = 0; it < listM.neff(); it++) {
                    if (listM.get(it) instanceof Ghost) {
                        System.out.print("Ghost at (" + listM.get(it).getY() + " , " + listM.get(it).getX() + " ) says : ");
                        ((Ghost) listM.get(it)).spook();
                    } else if (listM.get(it) instanceof Artist) {
                        System.out.print("Artist at (" + listM.get(it).getY() + " , " + listM.get(it).getX() + " ) says : ");
                        ((Artist) listM.get(it)).sing();
                    }

                    if (listM.get(it) instanceof Human) {
                        if (((Human) listM.get(it)).getUmur() >= Makhluk.OH) {
                            tempatHapus.add(it);
                            System.out.println("Unable to reach immortality, Human at ( " + listM.get(it).getY() + " , " + listM.get(it).getX() + " ) going  to heaven disgracefully");
                        } else {
                            ((Human) listM.get(it)).addUmur();
                        }
                    }
                }

                if (tempatHapus.isEmpty() == false) {
                    for (int idx = tempatHapus.size() - 1; idx >= 0; idx--) {
                        listM.delete(listM.search(listM.get(tempatHapus.get(idx))));
                    }
                }

                tempatHapus.clear();
                System.out.println("");

                Thread.sleep(300);

                if (listM.isListEmpty()) {
                    stop = true;
                } else if (step == true) {
                    key = 0;
                    while (step == true && key != KeyListeners.KS && key != KeyListeners.KA && key != KeyListeners.KK && stop == false) {
                        key = t.getKunci();

                        if (key == KeyListeners.KP) {
                            String path;
                            System.out.print("Simpan kemana : ");
                            path = in.next();
                            board.printBoard(listM, path);

                        } else if (key == KeyListeners.KA) {
                            addMakhluk(listM);
                        } else if (key == KeyListeners.KC) {
                            step = false;
                        } else if (key == KeyListeners.KQ) {
                            stop = true;
                        } else if (key == KeyListeners.KK) {
                            int victim = rand.nextInt(listM.neff());
                            System.out.print("God has decided that ");
                            if (listM.get(victim) instanceof Human) {
                                System.out.print(" Human at ");
                            } else {
                                System.out.print(" InHuman at ");
                            }
                            System.out.println("( " + listM.get(victim).getY() + " " + listM.get(victim).getX() + " ) will come to his side");
                            listM.delete(listM.search(listM.get(victim)));
                        }
                    }
                }
                key = t.getKunci();
            }
            while (key == 0 && stop == false);

            if (key == KeyListeners.KP) {
                String path;
                System.out.print("Simpan kemana : ");
                path = in.next();
                board.printBoard(listM, path);
            } else if (key == KeyListeners.KA) {
                addMakhluk(listM);
            } else if (key == KeyListeners.KC) {
                step = false;
            } else if (key == KeyListeners.KS) {
                step = true;
            } else if (key == KeyListeners.KQ) {
                stop = true;
            } else if (key == KeyListeners.KK) {
                int victim = rand.nextInt(listM.neff());
                System.out.print("God has decided that ");
                if (listM.get(victim) instanceof Human) {
                    System.out.print(" Human at ");
                } else {
                    System.out.print(" InHuman at ");
                }
                System.out.println("( " + listM.get(victim).getY() + " " + listM.get(victim).getX() + " ) will come to his side");
                listM.delete(listM.search(listM.get(victim)));
            }

            if (listM.isListEmpty()) {
                stop = true;
            }
        }
        while (stop == false);
    }


}