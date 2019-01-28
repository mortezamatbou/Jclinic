package clas.db;

import clas.Logging;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * CLASS ID = 1000-1
 *
 * @author Lobdown.com
 */
public class DatabaseHandler {

    Properties properties;

    final static String URL = "jdbc:mysql://";
    Connection connection;
    Statement statement;
    PreparedStatement pre;
    ResultSet resultSet;
    ResultSetMetaData metaData;

    public DatabaseHandler() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
            try {
                String h = URL + properties.getProperty("host") + ":" + properties.getProperty("port") + "/" + properties.getProperty("database") + "?useUnicode=true&characterEncoding=UTF-8";
                connection = DriverManager.getConnection(h, properties);
                statement = connection.createStatement();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ارور 10011 پایگاه داد", "ERROR", JOptionPane.ERROR_MESSAGE);

                Logging.log(e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ارور 10012. فایل کانفیگ یافت نشد.", "ERROR", JOptionPane.ERROR_MESSAGE);
            // add eror to log file
            Logging.log(e.getMessage());
        }

    }

    public DatabaseHandler(String host) {
        try {
            properties = new Properties();
            properties.setProperty("host", host);
            properties.load(new FileInputStream("config.properties"));
            try {
                String h = URL + properties.getProperty("host") + ":" + properties.getProperty("port") + "/" + properties.getProperty("database") + "?useUnicode=true&characterEncoding=UTF-8";
                connection = DriverManager.getConnection(h, properties);
                statement = connection.createStatement();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ارور 10011 پایگاه داد", "ERROR", JOptionPane.ERROR_MESSAGE);

                Logging.log(e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ارور 10012. فایل کانفیگ یافت نشد.", "ERROR", JOptionPane.ERROR_MESSAGE);
            // add eror to log file
            Logging.log(e.getMessage());
        }
    }

    public int getCount(String tableName) {
        try {
            resultSet = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM " + tableName);
            resultSet.next();
            int count = resultSet.getInt("rowcount");

            return count;
        } catch (SQLException ex) {
            return -1;
        }
    }

    public ResultSet getLastVisit(String id) {
        try {
            String sql = "SELECT * FROM visit WHERE user_id='%s' ORDER BY visit_date DESC LIMIT 1";
            sql = String.format(sql, id);
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return resultSet;
        } catch (SQLException ex) {

        }

        return null;
    }

    public ResultSet getUserHistory(String id) {
        try {
            String sql = "SELECT * FROM visit WHERE user_id='%s' ORDER BY visit_date DESC";
            sql = String.format(sql, id);
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return resultSet;
        } catch (SQLException ex) {

        }

        return null;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
        }
    }

    public boolean insertVisit(String sql) {
        try {
            statement.executeUpdate(sql);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logging.log(sql + " error while insert a new visit for defined user --- " + ex.getMessage());
        }

        return false;
    }

    public boolean checkLoginUser(String username, String password) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM admin WHERE admin_username = '" + username + "' AND admin_password = '" + password + "'");
            resultSet.next();
            resultSet.getObject(1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet getVisit(String visitId) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_id = '" + visitId + "'");
            resultSet.next();
            return resultSet;
        } catch (Exception e) {
        }

        return null;
    }

    public ResultSet searchBoxLastName(String lastName) {
        try {
            String sql = "SELECT * FROM user WHERE user_lname LIKE '" + lastName + "%'";
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean updateVisit(String sql, String user_id) {
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logging.log(sql + " error while insert a new visit for defined user --- " + ex.getMessage());
        }

        return false;
    }

}
