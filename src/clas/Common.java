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
            default:
                return "نا معلوم";
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
            default:
                return 0;
        }
    }

}
