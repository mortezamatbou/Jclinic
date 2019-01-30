package panels.importdata;

import clas.AppData;
import clas.Logging;
import clas.SearchBox;
import clas.db.DatabaseHandler;
import clas.db.UserHandler;
import clas.db.UserModel;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author morteza
 */
public class ImportData extends javax.swing.JPanel implements FocusListener, KeyListener {

    Properties p = new Properties();
    UserModel user;
    UserHandler userHandler = new UserHandler();
    ImportDozPanel doz;

    DatabaseHandler db;
    SearchBox box;
    Image img;

    /**
     * Creates new form ImportData
     */
    public ImportData() {
        initComponents();
        this.img = new ImageIcon(AppData.class.getResource("/images/background_import.jpg")).getImage();

        year.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        year.setEditor(new JSpinner.NumberEditor(year, "#"));
        doz = new ImportDozPanel();
        jPanel3.add(doz);
        jPanel1.setBounds(AppData.importDataFrame.getX(), AppData.importDataFrame.getY(), AppData.importDataFrame.getWidth(), 100);

//        userId.addFocusListener(this);
        doz.dayCount.addFocusListener(this);
        doz.opiom.addFocusListener(this);
        doz.gh20.addFocusListener(this);
        doz.gh40.addFocusListener(this);
        doz.gh5.addFocusListener(this);
        doz.metadon.addFocusListener(this);
        doz.b2.addFocusListener(this);
        doz.b4.addFocusListener(this);
        doz.b8.addFocusListener(this);
        doz.bBN.addFocusListener(this);

//        userId.addKeyListener(this);
        doz.dayCount.addKeyListener(this);
        doz.opiom.addKeyListener(this);
        doz.gh20.addKeyListener(this);
        doz.gh40.addKeyListener(this);
        doz.gh5.addKeyListener(this);
        doz.metadon.addKeyListener(this);
        doz.b2.addKeyListener(this);
        doz.b4.addKeyListener(this);
        doz.b8.addKeyListener(this);
        doz.bBN.addKeyListener(this);

//        AppData.importDataFrame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//                userId.requestFocus();
//            }
//        });
        userId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userId.getText().length() > 0) {
                    box.search(userId.getText());
                }
            }
        });

        db = new DatabaseHandler();
        box = new SearchBox(userId, searchBox, db);

    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField f;
        f = (JTextField) e.getComponent();
        f.selectAll();
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        day = new javax.swing.JComboBox();
        month = new javax.swing.JComboBox();
        year = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        searchBox = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(955, 180));

        jLabel1.setText("شماره پرونده");

        day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        day.setFocusable(false);

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));
        month.setFocusable(false);

        year.setModel(new javax.swing.SpinnerNumberModel(1397, 1300, 9999, 1));
        year.setFocusable(false);

        jLabel2.setText("/");

        jLabel3.setText("/");

        searchBox.setBackground(new java.awt.Color(244, 244, 244));
        searchBox.setOpaque(false);
        searchBox.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userId, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 250));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(656, 50));

        submitButton.setText("ثبت اطلاعات");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButton)
                .addContainerGap(557, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submitButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (userId.getText().length() > 0 && doz.dayCount.getText().length() > 0) {
            try {
                p.load(new FileInputStream("config.properties"));
                if (Integer.parseInt(p.getProperty("ask")) == 0) {
                    if (userHandler.userExists(userId.getText())) {
                        user = new UserModel(userHandler.getUser(userId.getText()));
                        setUserInfo(user);
                        if (user.insertNewVisit()) {
                            JOptionPane.showMessageDialog(this, "اطلاعات با موفقیت ثبت شد");
                            resetForm();
                        } else {
                            System.err.println("NOK");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, String.format("بیماری با شماره پرونده %s وجود ندارد", userId.getText()));
                        userId.requestFocus();
                        userId.selectAll();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "sds");

                }
            } catch (Exception e) {
                Logging.log("Not found config.properties ErrorCode: 5000-1 -- " + e.getMessage());
                JOptionPane.showMessageDialog(this, "فایل کانفیگ یافت نشد", "Error Code 5000-1", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "فیلد شماره پرونده و تعداد روز دارو را پر کنید");
            userId.requestFocus();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    void resetForm() {
        userId.setText("");
        userId.requestFocus();
        doz.dayCount.setText("");
        doz.opiom.setText("0");
        doz.gh20.setText("0");
        doz.gh40.setText("0");
        doz.gh5.setText("0");
        doz.metadon.setText("0");
        doz.b2.setText("0");
        doz.b4.setText("0");
        doz.b8.setText("0");
        doz.bBN.setText("0");
    }

    public void setUserInfo(UserModel u) {
        String visitDate = "%s-%s-%s";
        String y, m, d;
        y = year.getValue().toString();
        m = (month.getSelectedIndex() + 1) + "";
        d = (day.getSelectedIndex() + 1) + "";
        visitDate = String.format(visitDate, y, m, d);
        u.visit_date = visitDate;
        u.user_id = userId.getText();
        u.day = doz.dayCount.getText();
        String nextVisit = calculateNextVisit(y, m, d);
        u.next_visit = nextVisit;
        u.bupre_2 = doz.b2.getText();
        u.bupre_4 = doz.b4.getText();
        u.bupre_8 = doz.b8.getText();
        u.bupre_bn = doz.bBN.getText();
        u.ghors_20 = doz.gh20.getText();
        u.ghors_40 = doz.gh40.getText();
        u.ghors_5 = doz.gh5.getText();
        u.metadon = doz.metadon.getText();
        u.opiom = doz.opiom.getText();
//        JOptionPane.showMessageDialog(this, visitDate);
    }

    String calculateNextVisit(String y, String m, String d) {
        boolean changeYear = false, changeMonth = false;
        int Y, M, D;
        int C = Integer.parseInt(doz.dayCount.getText());
        Y = Integer.parseInt(y);
        M = Integer.parseInt(m);
        int firstD = Integer.parseInt(d);

        D = firstD + C;
        if (M <= 6) {
            if (D > 31) {
                changeMonth = true;
                D = D - 31;
                M += 1;
            }
        } else if (M == 12) {
            if (D > 29) {
                D = D - 29;
                changeMonth = true;
                M += 1;
            }
        } else {
            if (D > 30) {
                D = D - 30;
                changeMonth = true;
                M += 1;
            }
        }

        D = Math.abs(D);

        if (changeMonth) {
            if (M > 12) {
                changeYear = true;
                M = 1;
            }
        }

        if (changeYear) {
            Y++;
        }
        return Y + "-" + M + "-" + D;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox day;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox month;
    private javax.swing.JPanel searchBox;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField userId;
    private javax.swing.JSpinner year;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
