package clas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Lobdown.com
 */
public class AppData {

    public static JInternalFrame detailsFrame = new JInternalFrame();
    public static JFrame historyFrame = new JFrame("سابقه مراجعه");
    public static JFrame searchFrame = new JFrame("جستجو");
    public static JFrame singleSearchFrame = new JFrame("جستجو");
    public static JFrame userEditFrame = new JFrame("ویرایش مشخصات بیمار");
    public static JFrame importDataFrame = new JFrame("ورود اطلاعات");
    public static JFrame selectUserFrame = new JFrame("انتخاب بیمار");
    public static JFrame settingFrame = new JFrame("تنظیمات");
    
    static Image icon = new ImageIcon(AppData.class.getResource("/images/logo.jpeg")).getImage();

    public static boolean USER_LOGGED = false;
    public static int USER_ID = 0;
    public static String USER_NAME = null;

    public static String USER = null;

    public static void changeDetailsFrame(JPanel panel) {
        detailsFrame.setSize(500, 500);
        detailsFrame.getContentPane().removeAll();
        detailsFrame.getContentPane().add(panel);
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setBorder(null);
        BasicInternalFrameUI bi = (BasicInternalFrameUI) detailsFrame.getUI();
        bi.setNorthPane(null);

        jclinic.Jclinic.FRAME.getContentPane().add(detailsFrame);
        detailsFrame.setVisible(true);
        detailsFrame.validate();
        detailsFrame.repaint();
    }

    public static void showImportDataFrame(JPanel panel) {
        importDataFrame.getContentPane().removeAll();
        importDataFrame.setIconImage(icon);
        importDataFrame.setSize(900, 600);
        importDataFrame.setLocationRelativeTo(null);
        importDataFrame.setLayout(new BorderLayout());
        importDataFrame.getContentPane().add(panel, BorderLayout.CENTER);
        importDataFrame.setAlwaysOnTop(true);
        importDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        importDataFrame.setVisible(true);
        importDataFrame.validate();
        importDataFrame.repaint();
    }

    public static void selectUserFrame(JPanel panel) {
        importDataFrame.getContentPane().removeAll();
        importDataFrame.setIconImage(icon);
        importDataFrame.setSize(300, 450);
        importDataFrame.setLocationRelativeTo(null);
        importDataFrame.setLayout(new BorderLayout());
        importDataFrame.getContentPane().add(panel, BorderLayout.CENTER);
        importDataFrame.setAlwaysOnTop(true);
        importDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        importDataFrame.setVisible(true);
        importDataFrame.validate();
        importDataFrame.repaint();
    }

    public static void changeVisitFrame(JPanel panel) {
        historyFrame.getContentPane().removeAll();
        historyFrame.setSize(1000, 500);
        historyFrame.setIconImage(icon);
        historyFrame.setLocationRelativeTo(null);
        historyFrame.setLayout(new BorderLayout());
        historyFrame.getContentPane().add(panel, BorderLayout.CENTER);
        historyFrame.setAlwaysOnTop(true);
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.setVisible(true);
    }

    public static void changeSearchFrame(JPanel panel) {
        searchFrame.getContentPane().removeAll();
        searchFrame.setSize(1000, 500);
        searchFrame.setIconImage(icon);
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setLayout(new BorderLayout());
        searchFrame.getContentPane().add(panel, BorderLayout.CENTER);
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        searchFrame.setVisible(true);
    }

    public static void changeUserEditFrame(JPanel panel) {
        userEditFrame.getContentPane().removeAll();
        userEditFrame.setSize(550, 450);
        userEditFrame.setIconImage(icon);
        userEditFrame.setResizable(false);
        userEditFrame.setLocationRelativeTo(null);
        userEditFrame.setLayout(new BorderLayout());
        userEditFrame.getContentPane().add(panel, BorderLayout.CENTER);
        userEditFrame.setAlwaysOnTop(true);
        userEditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userEditFrame.setVisible(true);
    }
    public static void changeSettingFrame(JPanel panel) {
        settingFrame.getContentPane().removeAll();
        settingFrame.setSize(512, 220);
        settingFrame.setIconImage(icon);
        settingFrame.setResizable(false);
        settingFrame.setType(Window.Type.UTILITY);
        settingFrame.setLocationRelativeTo(null);
        settingFrame.setLayout(new BorderLayout());
        settingFrame.getContentPane().add(panel, BorderLayout.CENTER);
        settingFrame.setAlwaysOnTop(true);
        settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingFrame.setVisible(true);
    }

    public static void changeSingleSearchFrame(JPanel panel) {
        singleSearchFrame.getContentPane().removeAll();
        singleSearchFrame.setSize(850, 600);
        singleSearchFrame.setIconImage(icon);
        singleSearchFrame.setLocationRelativeTo(null);
        singleSearchFrame.setLayout(new BorderLayout());
        singleSearchFrame.getContentPane().add(panel, BorderLayout.CENTER);
        singleSearchFrame.setAlwaysOnTop(true);
        singleSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        singleSearchFrame.setVisible(true);
    }
}
