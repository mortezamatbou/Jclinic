package panels.user;

import clas.AppData;
import clas.UserListTable;
import clas.db.SearchHandler;
import clas.db.UserHandler;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lobdown.com
 */
public class UserList extends javax.swing.JPanel {

    UserListTable table;
    Image img;

    /**
     * Creates new form Users
     */
    public UserList() {
        initComponents();
        this.img = new ImageIcon(AppData.class.getResource("/images/background_add_user.jpg")).getImage();
        setName("لیست بیمار ها");
        UserHandler user = new UserHandler();
        ResultSet r = user.getUsers();
        table = new UserListTable(this);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try {
            while (r.next()) {
                int columnCount = r.getMetaData().getColumnCount();
                Object[] row = new Object[columnCount];
                row[0] = r.getObject(1);
                row[1] = r.getObject(2) + " " + r.getObject(3);
                model.addRow(row);
            }
        } catch (Exception e) {
        }

        JScrollPane js = new JScrollPane(table);
        jPanel2.add(js);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, -20, null);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 35));

        jLabel1.setText("لیست بیماران");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setText("ویرایش");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("حذف");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (table.getSelectedRow() != -1) {
            try {
                String id = table.getValueAt(table.getSelectedRow(), 0) + "";
                ResultSet r = new SearchHandler().getUsers(Integer.parseInt(id));
                r.next();
                String[] data = {id, r.getObject(2).toString(), r.getObject(3).toString()};
                AppData.changeUserEditFrame(new UserEdit(data));
            } catch (SQLException ex) {

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "آیا میخواهید این بیمار حذف شود ؟ (غیر قابل بازگردانی)", "حذف ویزیت", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
            if (table.getSelectedRow() != -1) {
                UserHandler u = new UserHandler();
                String user_id = table.getValueAt(table.getSelectedRow(), 0).toString();
                u.deleteUser(user_id);
                JOptionPane.showMessageDialog(this, "عملیات با موفقیت انجام شد");
                ((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
