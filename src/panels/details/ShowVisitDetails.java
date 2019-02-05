package panels.details;

import panels.importdata.ImportDozPanel;
import clas.AppData;
import clas.SearchBox;
import clas.db.DatabaseHandler;
import clas.db.UserHandler;
import clas.db.UserModel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Lobdown.com
 */
public class ShowVisitDetails extends javax.swing.JPanel implements FocusListener, KeyListener {

    ImportDozPanel doz;
    Image img;

    SearchBox box;
    DatabaseHandler db;

    UserModel user;

    /**
     * Creates new form ShowVisitDetails
     *
     * @param user an object from UserModel class
     */
    public ShowVisitDetails(UserModel user) {
        this.user = user;
        initComponents();
        this.img = new ImageIcon(AppData.class.getResource("/images/background_visit.jpg")).getImage();
        doz = new ImportDozPanel();
        jPanel1.add(doz);

        year.setEditor(new JSpinner.NumberEditor(year, "#"));

        initForm();

        db = new DatabaseHandler();
        box = new SearchBox(userId, searchBox, db);

        userId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (userId.getText().length() > 0) {
                    box.search(userId.getText());
                }
            }
        });

        userId.addFocusListener(this);
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

//        visitDate.setText(user.visit_date);
    }

    void initForm() {
        userName.setText(user.getFullName());
        userId.setText(user.user_id);
        visitDay.setText(user.visitDay);
        visitId.setText(user.visit_id);
        nextDate.setText(user.next_visit);
        doz.dayCount.setText(user.day);

        doz.opiom.setText(user.opiom);
        doz.gh20.setText(user.ghors_20);
        doz.gh40.setText(user.ghors_40);
        doz.gh5.setText(user.ghors_5);
        doz.metadon.setText(user.metadon);
        doz.b2.setText(user.bupre_2);
        doz.b4.setText(user.bupre_4);
        doz.b8.setText(user.bupre_8);
        doz.bBN.setText(user.bupre_bn);
        int[] i = user.getDate();

        day.setSelectedIndex(i[2] - 1);
        month.setSelectedIndex(i[1] - 1);
        year.setValue(i[0]);
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        visitId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        nextDate = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        searchBox = new javax.swing.JPanel();
        day = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        year = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        visitDay = new javax.swing.JLabel();

        setOpaque(false);

        jLabel1.setText("شماره ویزیت:");

        visitId.setText("jLabel2");

        jLabel2.setText("شماره پرونده:");

        userId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("تاریخ ویزیت:");

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("مراجعه بعدی:");

        nextDate.setText("jLabel7");

        update.setText("به روز رسانی");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        searchBox.setLayout(new java.awt.BorderLayout());

        day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel4.setText("/");

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        jLabel5.setText("/");

        year.setModel(new javax.swing.SpinnerNumberModel(1397, 1000, 9999, 1));

        jLabel7.setText("نام و نام خانوادگی:");

        userName.setText("jLabel8");

        delete.setText("حذف ویزیت");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel8.setText("روز مراجعه:");

        visitDay.setText("آزاد");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userId, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(visitId)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 120, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userName)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(178, 178, 178)
                                        .addComponent(nextDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(visitDay)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(43, 43, 43)
                                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)))))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(visitId))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(visitDay))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nextDate)
                            .addComponent(jLabel7)
                            .addComponent(userName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(delete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    boolean checkUserId() {
        try {
            Integer.parseInt(userId.getText());
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        if (checkUserId()) {
            user.user_id = userId.getText();
            user.visit_date = year.getValue() + "-" + (month.getSelectedIndex() + 1) + "-" + (day.getSelectedIndex() + 1);
            user.day = doz.dayCount.getText();

            user.next_visit = user.nextVisit();
            user.opiom = doz.opiom.getText();
            user.ghors_20 = doz.gh20.getText();
            user.ghors_40 = doz.gh40.getText();
            user.ghors_5 = doz.gh5.getText();
            user.metadon = doz.metadon.getText();
            user.bupre_2 = doz.b2.getText();
            user.bupre_4 = doz.b4.getText();
            user.bupre_8 = doz.b8.getText();
            user.bupre_bn = doz.bBN.getText();

            boolean b = user.updateVisit();

            if (b) {

                try {
                    ResultSet r = new UserHandler().getUser(user.user_id);
                    user.firstName = r.getString(2);
                    user.lastName = r.getString(3);

                    userName.setText(user.getFullName());
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(this, "به روز رسانی با موفقیت انجام شد");
                initForm();
            } else {
                JOptionPane.showMessageDialog(this, "ورودی نا معتبر است یا اطلاعات وارد شده تغییراتی نداشته است", "مشکل در به روز رسانی", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "شماره پرونده باید عدد باشد", "مشکل در اطلاعات ورودی", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "آیا میخواهید این وزییت حذف شود ؟ (غیر قابل بازگردانی)", "حذف ویزیت", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            user.deleteVisit();
            JOptionPane.showMessageDialog(this, "عملیات با موفقیت انجام شد");
            AppData.historyFrame.dispose();
        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox day;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox month;
    private javax.swing.JLabel nextDate;
    private javax.swing.JPanel searchBox;
    private javax.swing.JButton update;
    private javax.swing.JTextField userId;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel visitDay;
    private javax.swing.JLabel visitId;
    private javax.swing.JSpinner year;
    // End of variables declaration//GEN-END:variables

    @Override
    public void focusGained(FocusEvent e) {
        JTextField f;
        f = (JTextField) e.getComponent();
        f.selectAll();
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
