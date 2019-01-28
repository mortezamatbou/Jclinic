//package clas.db;
//
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//
///**
// * CLASS ID = 1004 this class model result of visit table to class
// *
// * @author Lobdown.com
// */
//public class VisitModel1 {
//
//    Visit[] visit;
//
//    Visit current;
//
//    int cursor = 0;
//    int columnCount = 0;
//    int rowCount = 0;
//
//    String[] columnNames;
//
//    ResultSet result;
//    ResultSetMetaData meta;
//
//    public VisitModel1(ResultSet result) {
//        try {
//            result.beforeFirst();
//            this.result = result;
//            this.meta = result.getMetaData();
//            init();
//        } catch (SQLException ex) {
//
//        }
//
//    }
//
//    private void init() throws SQLException {
//        this.columnCount = meta.getColumnCount();
//
//        result.beforeFirst();
//
//        while (result.next()) {
//            this.rowCount++;
//        }
//
//        result.beforeFirst();
//        visit = new Visit[rowCount];
//        int j = 0;
//        while (result.next()) {
//            visit[j] = new Visit();
//            for (int i = 1; i <= columnCount; i++) {
//                visit[j].visit_id = result.getString(1);
//                visit[j].user_id = result.getString(2);
//                visit[j].visit_date = result.getString(3);
//                visit[j].day = result.getString(4);
//                visit[j].next_visit = result.getString(5);
//                visit[j].ghors_5 = result.getString(6);
//                visit[j].ghors_20 = result.getString(7);
//                visit[j].ghors_40 = result.getString(8);
//                visit[j].metadon = result.getString(9);
//                visit[j].bupre_4 = result.getString(10);
//                visit[j].bupre_2 = result.getString(11);
//                visit[j].bupre_8 = result.getString(12);
//                visit[j].bupre_bn = result.getString(13);
//                visit[j].opiom = result.getString(14);
//            }
//            j++;
//        }
//
//    }
//
//    public int getRowCount() {
//        return this.rowCount;
//    }
//
//    public int getColumnCount() {
//        return this.columnCount;
//    }
//
//    public boolean next() {
//        if (this.cursor + 1 < this.rowCount) {
//            return true;
//        }
//        return false;
//    }
//
//    public Visit getVisit() {
//        if (cursor < rowCount) {
//            this.current = this.visit[cursor];
//            cursor++;
//            return this.current;
//        }
//        return null;
//    }
//
//    public void first() {
//        this.cursor = 0;
//    }
//
//    public Visit getLastVisit() {
//        if (visit.length > 0) {
//            int pointer = 0;
//            for (int i = 0; i < visit.length; i++) {
//                if (i == 0) {
//                    pointer = 0;
//                }
//            }
//            return visit[pointer];
//        }
//        return null;
//    }
//
//}
