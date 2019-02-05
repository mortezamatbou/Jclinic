package clas.db;

import clas.Common;
import java.sql.ResultSet;

/**
 *
 * @author Lobdown.com
 */
public class SearchHandler extends DatabaseHandler {

    public ResultSet getUsers(int id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id='" + id + "'");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String getUserName(int id) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id='" + id + "'");
            if (resultSet.next()) {

                return resultSet.getObject(2) + " " + resultSet.getObject(3);
            }
            return "نا مشخص";
        } catch (Exception e) {
            return "نا مشخص";
        }
    }

    public ResultSet getUsers(String lastName) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE user_lname='" + lastName + "'");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet getUsersByName(String name) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM user WHERE user_id = 13950");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchOneDay(String date) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date = '" + date + "' ORDER BY visit_date ASC");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchOneDayUser(String userId, String date) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date = '" + date + "' AND user_id = '" + userId + "' ORDER BY visit_date ASC");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchBetween(String start, String end) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date between '" + start + "' AND '" + end + "' ORDER BY visit_date ASC LIMIT 50");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchBetweenPage(String start, String end, int page) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date between '" + start + "' AND '" + end + "' ORDER BY visit_date ASC LIMIT 50");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchBetween(String userId, String start, String end) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date between '" + start + "' AND '" + end + "' AND user_id = '" + userId + "' ORDER BY visit_date ASC LIMIT 50");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchVisitDate(String date) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE next_visit = '" + date + "'");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet searchBetweenPage(String userId, String start, String end, int page) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM visit WHERE visit_date between '" + start + "' AND '" + end + "' AND user_id = '" + userId + "' ORDER BY visit_date ASC LIMIT 50");
            if (resultSet.next()) {
                resultSet.beforeFirst();
                return resultSet;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String getUserDay(String userId) {
        try {
            resultSet = statement.executeQuery("SELECT user_day FROM user WHERE user_id = '" + userId + "'");
            if (resultSet.next()) {
                return Common.getDayName(Integer.parseInt(resultSet.getString(1)));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
