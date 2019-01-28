/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels.user;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import javax.swing.JTabbedPane;

/**
 *
 * @author Lobdown.com
 */
public class User extends javax.swing.JPanel {
    
    JTabbedPane tabs;

    /**
     * Creates new form UserDefault
     */
    public User() {
        initComponents();
        tabs = new JTabbedPane();
        tabs.add(new UserList());
        tabs.add(new UserAdd(this));
        
        tabs.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tabs, BorderLayout.CENTER);
    }
    
    public void updatePanel() {
        tabs.remove(0);
        tabs.add(new UserList(), 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
