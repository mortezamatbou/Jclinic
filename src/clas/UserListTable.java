package clas;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lobdown.com
 */
public class UserListTable extends JTable {

    public UserListTable(JPanel p) {
        super(new DefaultTableModel(new Object[]{"شماره پرونده", "نام و نام خانوادگی", "روز مراجعه"}, 0));
        setFont(new Font("tahoma", Font.PLAIN, 13));
        getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.RIGHT);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setRowHeight(20);
        setShowVerticalLines(false);
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        if (defaults.get("Table.alternateRowColor") == null) {
            defaults.put("Table.alternateRowColor", new Color(245, 245, 245));
        }
        
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
