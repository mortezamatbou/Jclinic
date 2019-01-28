package clas.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lobdown.com
 */
public class UserModel extends DatabaseHandler {

    public String firstName, lastName, id;

    public String visit_id;
    public String user_id;
    public String visit_date;
    public String day;
    public String next_visit;
    public String ghors_5;
    public String ghors_20;
    public String ghors_40;
    public String metadon;
    public String bupre_4;
    public String bupre_2;
    public String bupre_8;
    public String bupre_bn;
    public String opiom;

    public boolean hasVisitData = false;
    public boolean hasUserData = false;

    public ResultSet visitHistory;

    public UserModel(ResultSet r) {
        hasUserData = true;
        try {

            this.id = r.getString(1);
            this.firstName = r.getString(2);
            this.lastName = r.getString(3);

            ResultSet visit = getLastVisit(id);

            if (visit != null) {
                init(visit);
                hasVisitData = true;
            }

        } catch (SQLException ex) {
        }

    }
    
    
    
    public UserModel(ResultSet r, boolean type) {
        try {
            init(r);
            hasVisitData = true;
            ResultSet userInfo = new UserHandler().getUser(user_id);
            firstName = userInfo.getString(2);
            lastName = userInfo.getString(3);
        } catch (SQLException ex) {
            
        }
        
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private void init(ResultSet result) throws SQLException {
        this.visit_id = result.getString(1);
        this.user_id = result.getString(2);
        this.visit_date = result.getString(3);
        this.day = result.getString(4);
        this.next_visit = result.getString(5);
        this.ghors_5 = result.getString(6);
        this.ghors_20 = result.getString(7);
        this.ghors_40 = result.getString(8);
        this.metadon = result.getString(9);
        this.bupre_4 = result.getString(10);
        this.bupre_2 = result.getString(11);
        this.bupre_8 = result.getString(12);
        this.bupre_bn = result.getString(13);
        this.opiom = result.getString(14);
    }

    public ResultSet getHistory() {
        try {
            if (hasVisitData) {
                String sql = "SELECT * FROM visit WHERE user_id = '%s' ORDER BY visit_date DESC";
                sql = String.format(sql, user_id);
                return statement.executeQuery(sql);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean insertNewVisit() {
        String sql = "INSERT INTO visit (user_id, visit_date, day, next_visit, ghors_5, ghors_20, ghors_40, metadon, bupre_4, bupre_2, bupre_8, bupre_bn, opiom)"
                + " VALUES ('" + user_id + "', '" + visit_date + "', '" + day + "', '" + next_visit + "', '" + ghors_5 + "', '" + ghors_20 + "',"
                + "'" + ghors_40 + "', '" + metadon
                + "', '" + bupre_4 + "', '" + bupre_2 + "', '" + bupre_8 + "', '" + bupre_bn
                + "', '" + opiom + "')";
        return insertVisit(sql);
    }
    public boolean updateVisit() {
        String sql = "UPDATE visit SET user_id = '" + user_id +"'," + 
                " visit_date = '" + visit_date +"'," +
                " day = '" + day +"'," +
                " next_visit = '" + next_visit +"'," +
                " ghors_5 = '" + ghors_5 +"'," +
                " ghors_20 = '" + ghors_20 +"'," +
                " ghors_40 = '" + ghors_40 +"'," +
                " metadon = '" + metadon +"'," +
                " bupre_4 = '" + bupre_4 +"'," +
                " bupre_2 = '" + bupre_2 +"'," +
                " bupre_8 ='" + bupre_8 +"'," +
                " bupre_bn = '" + bupre_bn +"'," +
                "opiom = '" + opiom +"'"
                + " WHERE visit_id = '" + visit_id + "'";
        return updateVisit(sql, user_id);
    }
    
    public int[] getDate() {
        String[] date = visit_date.split("-");
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);
        int[] l = {y, m, d};
        return l;
    }
    
    public String nextVisit() {
        int[] date = getDate();
        boolean changeYear = false, changeMonth = false;
        int Y, M, D;
        int C = Integer.parseInt(day);
        Y = date[0];
        M = date[1];
        int firstD = date[2];

        D = firstD + C;
        if (M <= 6) {
            if (D > 31) {
                changeMonth = true;
                D = D - 31;
                M += 1;
            }
        } else if (M == 12) {
            if (D > 29) {
                D = D - 29;
                changeMonth = true;
                M += 1;
            }
        } else {
            if (D > 30) {
                D = D - 30;
                changeMonth = true;
                M += 1;
            }
        }

        D = Math.abs(D);

        if (changeMonth) {
            if (M > 12) {
                changeYear = true;
                M = 1;
            }
        }

        if (changeYear) {
            Y++;
        }
        return Y + "-" + M + "-" + D;
    }
    
    public void deleteVisit() {
        if (visit_id != "") {
            try {
                statement.executeUpdate("DELETE FROM visit WHERE visit_id = '" + visit_id + "'");
            } catch (Exception e) {
            }
        }
    }

}
