package panels.search;

import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Lobdown.com
 */
public class Search extends javax.swing.JPanel {

    JPanel byIdName, byDate;
    
    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
        JTabbedPane tabs = new JTabbedPane();
        tabs.add(new SearchDefault());
        tabs.add(new SearchDate());
        tabs.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(tabs);
        tabs.setSelectedIndex(0);
        JPanel p = (JPanel) tabs.getSelectedComponent();
        p.getComponent(0).requestFocus();
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

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}