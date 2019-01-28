/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clas;

import clas.db.DatabaseHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author morteza
 */
public class SearchBox {

//    private final int WIDTH = 200;
//    private final int HEIGHT = 30;
    Connection c;
    Statement s;

    int j = 0;

    JTextField f;

    JTable t;
    DefaultTableModel m;
    
    DatabaseHandler db;

    public SearchBox(JTextField f,JPanel jp, DatabaseHandler db) {
        this.f = f;
        this.db = db;
        
        jp.setOpaque(false);
        

        JPanel p = new JPanel(new BorderLayout());
        
        
        m = new DefaultTableModel(new Object[][]{}, new Object[]{"شماره پرونده", "نام", "نام خانوادگی"});
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
            }
        });

        p.add(t, BorderLayout.CENTER);

        

        jp.add(new JScrollPane(p), BorderLayout.CENTER);

    }

    public void search(String param) {
        try {

            ResultSet r = db.searchBoxLastName(param);

            if (r.next()) {
                r.beforeFirst();
                DefaultTableModel model = (DefaultTableModel) this.t.getModel();
                model.setRowCount(0);
                while (r.next()) {
                    String[] row = new String[3];
                    row[0] = r.getString(1);
                    row[1] = r.getString(2);
                    row[2] = r.getString(3);
                    model.addRow(row);
                }
            }
            
            this.f.requestFocus();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
