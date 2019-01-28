package clas.db;

import java.sql.ResultSet;

/**
 * CLASS ID = 1003
 * @author Lobdown.com
 */
public class UserHandler extends DatabaseHandler {

    public ResultSet getUsers() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM user ORDER BY user_id ASC");
            return resultSet;
        } catch (Exception e) {
            return null;
        }
    }

    public int addUser(int id, String fname, String lname, int day) {
        try {
            statement.executeUpdate("INSERT INTO user (user_id, user_fname, user_lname, user_day) VALUES ('" + id + "'," + "'" + fname + "', '" + lname + "', " + day + ")");
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public int updateUser(int id, String fname, String lname, int userDay) {
        try {
            statement.executeUpdate("UPDATE user SET user_fname='" + fname + "', user_lname='" + lname + "', user_day='" + userDay + "' WHERE user_id = '" + id + "'");
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean userExists(String userId) {
        try {
            resultSet = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM user WHERE user_id = '" + userId + "'");
            resultSet.next();
            int count = resultSet.getInt("rowcount");
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {

        }

        return false;
    }

    public ResultSet getUser(String userId) {
        try {
            String sql = "SELECT * FROM user WHERE user_id = '%s'";
            sql = String.format(sql, userId);
            ResultSet r = statement.executeQuery(sql);
            r.next();
            return r;
        } catch (Exception e) {

        }

        return null;
    }
    public void updateUserId(String oldValue, String newValue, String fname, String lname, int userDay) {
        try {
            statement.executeUpdate("UPDATE user SET user_id='" + newValue + "', user_fname = '" + fname + "', user_lname = '" + lname + "' WHERE user_id = '" + oldValue + "' user_day='" + userDay + "'");
            statement.executeUpdate("UPDATE visit SET user_id='" + newValue + "' WHERE user_id = '" + oldValue + "'");
        } catch (Exception e) {
        }
    }
    
    public ResultSet getVisits() {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit LIMIT 2");
            return resultSet;
        } catch (Exception e) {
            return null;
        }
    }
    
    public int deleteUser(String user_id) {
        try {
            statement.executeUpdate("DELETE FROM user WHERE user_id = '" + user_id + "'");
            statement.executeUpdate("DELETE FROM visit WHERE user_id = '" + user_id + "'");
            return 1;
        } catch (Exception e) {
        }
        
        return 1;
    }
    
    

}
