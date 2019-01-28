package clas;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Lobdown.com
 */
public class Logging {
    
    private static String logFilePath = "log.txt";

    private static final File logFile = new File(logFilePath);
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Calendar cal = Calendar.getInstance();

    public static void log(String log) {
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            String logText = "\n" + dateFormat.format(cal.getTime()) + " : " + log;
            Files.write(Paths.get(logFilePath), logText.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception ex) {
            
        }
    }

}
