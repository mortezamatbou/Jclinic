/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clas;

import clas.db.DatabaseHandler;
import clas.db.SearchHandler;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import panels.details.Details;

/**
 *
 * @author morteza
 */
public class SearchBox {

//    private final int WIDTH = 200;
//    private final int HEIGHT = 30;
    Connection c;
    Statement s;

    SearchHandler search;
    
    int j = 0;

    JTextField f;

    JTable t;
    DefaultTableModel m;
    
    DatabaseHandler db;

    public SearchBox(JTextField f,JPanel jp, DatabaseHandler db, SearchHandler search) {
        this.f = f;
        this.db = db;
        this.search = search;
        
        jp.setOpaque(false);
        

        JPanel p = new JPanel(new BorderLayout());
        
        
        m = new DefaultTableModel(new Object[][]{}, new Object[]{"شماره پرونده", "نام", "نام خانوادگی", "شماره تماس", "روز مراجعه"});
        t = new JTable(m);
        t.setOpaque(false);
        t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        t.setDefaultEditor(Object.class, null);
        t.setRowHeight(20);
        t.setFont(new Font("tahoma", Font.PLAIN, 13));
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (t.getSelectedRow() != -1) {
                    f.setText(t.getValueAt(t.getSelectedRow(), 0) + "");
                }
                
                if (evt.getClickCount() == 2) {
                    searchPlease();
                }
                
            }
        });

        p.add(t, BorderLayout.CENTER);

        

        jp.add(new JScrollPane(p), BorderLayout.CENTER);

    }
    
    public void searchPlease() {
        if (f.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "فیلد مربوطه را پر کنید", "خطا در پردازش", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(f.getText());
            ResultSet r = search.getUsers(id);
            if (r != null) {
                r.next();
                AppData.changeSingleSearchFrame(new Details(r));
            } else {
                JOptionPane.showMessageDialog(null, "بیماری با این شماره پرونده وجود ندارد", "خطا در پردازش", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "شماره پرونده باید به صورت عدد وارد شود", "خطا در پردازش", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void search(String param) {
        try {

            ResultSet r = db.searchBoxLastName(param);

            if (r.next()) {
                r.beforeFirst();
                DefaultTableModel model = (DefaultTableModel) this.t.getModel();
                model.setRowCount(0);
                while (r.next()) {
                    String[] row = new String[5];
                    row[0] = r.getString(1);
                    row[1] = r.getString(2);
                    row[2] = r.getString(3);
                    row[3] = r.getString(5);
                    row[4] = Common.getDayName(Integer.parseInt(r.getString(4)));
                    model.addRow(row);
                }
            }
            
            this.f.requestFocus();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
