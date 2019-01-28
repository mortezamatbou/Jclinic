package clas;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lobdown.com
 */
public class VisitTable extends JTable {

    public VisitTable(String[][] data, String[] columns) {
        super(data, columns);
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
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        if (defaults.get("Table.alternateRowColor") == null) {
            defaults.put("Table.alternateRowColor", new Color(245, 245, 245));
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        if (column > 1) {
            return true;
        }
        return false;
    }

}
