package jclinic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import panels.other.Login;
import panels.other.Menu;

/**
 *
 * @author Lobdown.com
 */
public class Jclinic extends JFrame {

    public static Jclinic SINGLETON;
    public static JFrame FRAME;
    public static Menu menu;
    public static JPanel panel;

    public Jclinic() {
        initComponent();
    }

    private void initComponent() {
        menu = new Menu();
        

        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().add(new Login());
        setIconImage(new ImageIcon(getClass().getResource("/images/logo.jpeg")).getImage());
        setTitle("Sepid Clinic");
        setVisible(true);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 500));

        FRAME = this;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                // System.out.println(info);
                /**
                 * Windows Windows Classic Nimbus Metal CDE/Motif
                 */
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Jclinic run = new Jclinic();
        SINGLETON = run;
    }

}
