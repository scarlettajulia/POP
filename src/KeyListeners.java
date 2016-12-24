import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.*;

public class KeyListeners extends JFrame implements KeyListener {

    JLabel label;
    private int kunci;
    private boolean processed;
    public static final  int KC = 1;
    public static final int KS = 2;
    public static final int KP = 3;
    public static final int KA = 4;
    public static final int KQ = 5;
    public static final int KK = 6;


    public KeyListeners(String s) {
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
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_C) {
            kunci = KC;
            processed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            kunci = KS;
            processed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_P) {
            kunci = KP;
            processed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            kunci = KA;
            processed = false;
            label = new JLabel("hahaha");
        }
        else if (e.getKeyCode() == KeyEvent.VK_Q) {
            kunci = KQ;
            processed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_K) {
            kunci = KK;
            processed = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        
    }
    public int getKunci(){
        if(processed == true)
            return 0;
        else{
            processed = true;
            return kunci;
        }
    }


}
