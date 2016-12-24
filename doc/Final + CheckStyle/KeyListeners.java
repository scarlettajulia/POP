import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;

/**
 * @author Chalvin/13514032
 */
public class KeyListeners extends JFrame implements KeyListener {
    /**
     * Atribut label menyatakan suatu nama label.
     */
    private JLabel label;

    /**
     * Atribut kunci menyatakan nilai suatu kunci.
     */
    private int kunci;

    /**
     * Atribut processed menyatakan apakah suatu key sedang diproses.
     */
    private boolean processed;

    /**
     * Atribut KC menyatakan kunci C.
     */
    public static final  int KC = 1;

    /**
     * Atribut KS menyatakan kunci S.
     */
    public static final int KS = 2;

    /**
     * Atribut KP menyatakan kunci P.
     */
    public static final int KP = 3;

    /**
     * Atribut KA menyatakan kunci A.
     */
    public static final int KA = 4;

    /**
     * Atribut KQ menyatakan kunci Q.
     */
    public static final int KQ = 5;

    /**
     * Atribut KK menyatakan kunci K.
     */
    public static final int KK = 6;

    /**
     * Konstruktor KeyListeners dengan parameter.
     * @param s sebuah argumen bertipe string
     */
    public KeyListeners(final String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);
        processed = true;
    }

    @Override
    /**
     * Prosedur keyReleased untuk mengecek tombol yang tidak ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    public final void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            kunci = KC;
            processed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            kunci = KS;
            processed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            kunci = KP;
            processed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            kunci = KA;
            processed = false;
            label = new JLabel("hahaha");
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {
            kunci = KQ;
            processed = false;
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            kunci = KK;
            processed = false;
        }

    }

    @Override
    /**
     * Prosedur keyTyped untuk mengabaikan tombol yang sudah ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    public final void keyTyped(final KeyEvent e) {
    }

    @Override
    /**
     * Prosedur keyPressed untuk mengabaikan tombol yang sedang ditekan.
     * @param e sebuah kunci yang ditekan.
     */
    public final void keyPressed(final KeyEvent e) {
    }

    /**
     * Fungsi getKunci untuk mengembalika kunci yang telah diproses.
     * @return kunci jika tidak diproses
     */
    public final int getKunci() {
        if (processed == true) {
            return 0;
        } else {
            processed = true;
            return kunci;
        }
    }
}
