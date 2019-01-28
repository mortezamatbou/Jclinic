package panels.other;

import panels.user.User;
import panels.search.Search;
import panels.other.Welcome;
import clas.AppData;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import panels.importdata.ImportData;
import sepidclinic.SepidClinic;

/**
 *
 * @author Lobdown.com
 */
public class Menu implements ActionListener {

    public JMenuBar menubar;
    public JMenu file, help;
    public JMenuItem exit, search, logout, user, today, addData, setting, backup;
    //public JMenuItem drug;
    public JMenuItem about, handbook;
    Properties p;

    public Menu() {
        menubar = new JMenuBar();
        menubar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        try {
            p.load(new FileInputStream("config.properties"));
        } catch (Exception ex) {
        }
        
        Font f = new Font("tahoma", Font.PLAIN, 12);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);

        file = new JMenu("منو اصلی");
        file.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        help = new JMenu("راهنما");
        help.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        addData = new JMenuItem("ورود اطلاعات");
        addData.setIcon(new ImageIcon(getClass().getResource("/images/icon_import_data.png")));
        addData.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        addData.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        backup = new JMenuItem("بک آپ اطلاعات");
        backup.setIcon(new ImageIcon(getClass().getResource("/images/icon_backup.png")));
        backup.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        backup.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

//        today = new JMenuItem("مراجعین امروز");
//        today.setIcon(new ImageIcon(getClass().getResource("/images/icon_today_users.png")));
//        today.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        today.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        user = new JMenuItem("بیمار");
        user.setIcon(new ImageIcon(getClass().getResource("/images/icon_user.png")));
        user.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        user.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

//        drug = new JMenuItem("دارو");
//        drug.setIcon(new ImageIcon(getClass().getResource("/images/icon_drug.png")));
//        drug.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        drug.setAccelerator(KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        search = new JMenuItem("جستجو");
        search.setIcon(new ImageIcon(getClass().getResource("/images/icon_search.png")));
        search.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        search.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        setting = new JMenuItem("تنظیمات");
        setting.setIcon(new ImageIcon(getClass().getResource("/images/icon_setting.png")));
        setting.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setting.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        
        logout = new JMenuItem("خروج از حساب");
        logout.setIcon(new ImageIcon(getClass().getResource("/images/icon_lock.png")));
        logout.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        logout.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        exit = new JMenuItem("خروج");
        exit.setIcon(new ImageIcon(getClass().getResource("/images/icon_exit.png")));
        exit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        exit.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        about = new JMenuItem("درباره سازنده برنامه");
        about.setIcon(new ImageIcon(getClass().getResource("/images/icon_info.png")));
        about.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        handbook = new JMenuItem("محتوای کمکی");
        handbook.setIcon(new ImageIcon(getClass().getResource("/images/icon_handbook.png")));
        handbook.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        handbook.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        file.add(addData);
//        file.add(today);
        file.add(user);
//        file.add(drug);
        file.add(search);
        file.add(setting);
        file.add(backup);
        file.add(logout);
        file.add(exit);

        help.add(handbook);
        help.add(about);

        backup.addActionListener(this);
        addData.addActionListener(this);
        setting.addActionListener(this);
        exit.addActionListener(this);
        logout.addActionListener(this);
        search.addActionListener(this);
//        drug.addActionListener(this);
        user.addActionListener(this);
//        today.addActionListener(this);
        handbook.addActionListener(this);
        about.addActionListener(this);

        menubar.add(file);
        menubar.add(help);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o != logout && o != exit && o != addData && o != setting && o != backup) {
            AppData.detailsFrame.dispose();
            SepidClinic.FRAME.getContentPane().removeAll();
        }

        if (o == exit) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int i = JOptionPane.showConfirmDialog(null, "آیا می خواهید از برنامه خارج شوید ؟", "خروج از برنامه", dialogButton);
            if (i == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (o == today) {
            SepidClinic.FRAME.getContentPane().add(new Welcome(), BorderLayout.CENTER);
        } else if (o == search) {
            SepidClinic.FRAME.getContentPane().add(new Search(), BorderLayout.CENTER);
        } else if (o == user) {
            SepidClinic.FRAME.getContentPane().add(new User(), BorderLayout.CENTER);
//        } else if (o == drug) {
//            SepidClinic.FRAME.getContentPane().add(new Drug(), BorderLayout.CENTER);
        } else if (o == logout) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int i = JOptionPane.showConfirmDialog(null, "آیا می خواهید از برنامه خارج شوید ؟", "خروج از حساب کاربری", dialogButton);
            if (i == JOptionPane.YES_OPTION) {
                AppData.USER_LOGGED = false;
                AppData.USER_ID = 0;
                AppData.USER_NAME = null;
                SepidClinic.FRAME.setJMenuBar(null);
                AppData.detailsFrame.dispose();
                SepidClinic.FRAME.getContentPane().removeAll();
                SepidClinic.FRAME.getContentPane().add(new Login());
            }

        } else if (o == about) {
            
        } else if (o == handbook) {
        
        } else if (o == addData) {
            AppData.showImportDataFrame(new ImportData());
        } else if (o == setting) {
            AppData.changeSettingFrame(new Setting());
        } else if (o == backup) {
            try {
                Desktop.getDesktop().open(new File("C:\\xampp\\mysql\\data\\sepid_db"));
            } catch (IOException ex) {
                
            }
        }

        SepidClinic.FRAME.validate();
        SepidClinic.FRAME.repaint();
    }

}
