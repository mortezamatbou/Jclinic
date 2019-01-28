package clas;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lobdown.com
 */
public class HistoryTable extends JTable {

    public HistoryTable() {
        super(new DefaultTableModel(new Object[]{"شناسه مراجعه", "تاریخ مراجعه"}, 0));

        initTable();

    }


    private void initTable() {
        setFont(new Font("tahoma", Font.PLAIN, 13));
        getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        setDefaultEditor(Object.class, null);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setRowHeight(20);

        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        if (defaults.get("Table.alternateRowColor") == null) {
            defaults.put("Table.alternateRowColor", new Color(245, 245, 245));
        }
    }

}
