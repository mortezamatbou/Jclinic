package panels.search;

import clas.AppData;
import clas.DateConverter;
import clas.SearchBox;
import clas.db.DatabaseHandler;
import clas.db.SearchHandler;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author Lobdown.com
 */
public class SearchVisitDate extends javax.swing.JPanel {

    SearchHandler search = new SearchHandler();
    SearchBox box;
    DatabaseHandler db;
    Image img;

    /**
     * Creates new form SearchDate
     */
    public SearchVisitDate() {
        initComponents();
        this.img = new ImageIcon(AppData.class.getResource("/images/background_search.jpg")).getImage();
        setName("جستجو بر اساس تاریخ مراجعه");
        year.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        year.setEditor(new JSpinner.NumberEditor(year, "#"));
        datePanel.setOpaque(true);
        datePanel.setBackground(new Color(0, 0, 0, 0.3f));

        db = new DatabaseHandler();

        int[] date = DateConverter.getDate();

        year.setValue(date[0]);
        month.setSelectedIndex(date[1] - 1);
        day.setSelectedIndex(date[2] - 1);

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

        datePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        year = new javax.swing.JSpinner();
        searchButton = new javax.swing.JButton();
        month = new javax.swing.JComboBox();
        day = new javax.swing.JComboBox();
        todayVisitors = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        datePanel.setPreferredSize(new java.awt.Dimension(550, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("تاریخ");

        year.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1397), Integer.valueOf(1300), null, Integer.valueOf(1)));

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchButton.setText("جستجو");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" }));

        day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        todayVisitors.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        todayVisitors.setText("امروز");
        todayVisitors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayVisitorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(searchButton)
                        .addGap(18, 18, 18)
                        .addComponent(todayVisitors)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(todayVisitors))
                .addGap(31, 31, 31))
        );

        add(datePanel, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String date = year.getValue() + "-" + (month.getSelectedIndex() + 1) + "-" + (day.getSelectedIndex() + 1);
        doSearch(date);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void doSearch(String date) {
        ResultSet r = search.searchVisitDate(date);
        if (r != null) {
            try {
                AppData.changeSearchFrame(new SearchResult(r));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "هیچ مراجعه کننده ای وجود ندارد");
            }
        } else {
            JOptionPane.showMessageDialog(this, "هیچ مراجعه کننده ای وجود ندارد");
        }
    }

    private void todayVisitorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayVisitorsActionPerformed
        String today = DateConverter.getToday();
        doSearch(today);
    }//GEN-LAST:event_todayVisitorsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel datePanel;
    private javax.swing.JComboBox day;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox month;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton todayVisitors;
    private javax.swing.JSpinner year;
    // End of variables declaration//GEN-END:variables
}
