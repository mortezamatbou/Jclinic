/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clas;

/**
 *
 * @author Lobdown
 */
public class Common {

    public static String getDayName(int dayIndex) {
        switch (dayIndex) {
            case 1:
                return "شنبه";
            case 2:
                return "یکشنبه";
            case 3:
                return "دوشنبه";
            case 4:
                return "سه شنبه";
            case 5:
                return "چهارشنبه";
            case 6:
                return "پنج شنبه";
            case 7:
                return "آزاد";
            case 8:
                return "ندارد";
            default:
                return "ندارد";
        }
    }
    
    public static int getDayIndex(String dayName) {
        switch (dayName) {
            case "شنبه":
                return 1;
            case "یکشنبه":
                return 2;
            case "دوشنبه":
                return 3;
            case "سه شنبه":
                return 4;
            case "چهارشنبه":
                return 5;
            case "پنج شنبه":
                return 6;
            case "آزاد":
                return 7;
            case "ندارد":
                return 8;
            default:
                return 8;
        }
    }
    
    public static String getDays(String selectedDaysString) {
        String days = "";
        String[] selectedDays = selectedDaysString.split(",");
        if (selectedDays.length == 0) {
            return "ندارد";
        }
        for (int i = 0; i < selectedDays.length; i++) {

            String value = "";
            switch (selectedDays[i]) {
                case "1":
                    value = "شنبه";
                    break;
                case "2":
                    value = "یکشنبه";
                    break;
                case "3":
                    value = "دوشنبه";
                    break;
                case "4":
                    value = "سه شنبه";
                    break;
                case "5":
                    value = "چهارشنبه";
                    break;
                case "6":
                    value = "پنج شنبه";
                    break;
                case "7":
                    value = "آزاد";
                    break;
                case "8":
                    value = "ندارد";
                    break;
                default:
                    value = "ندارد";
            }
            if (days.length() == 0) {
                days = value;
            } else {
                days += "," + value;
            }

        }
        // default is ندارد
        return days.length() > 0 ? days : "ندارد";
    }

}
