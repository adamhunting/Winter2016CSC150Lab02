package com.ahunting.Lab02;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Adam on 1/12/2016.
 */
public class Logger {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    static String newLine = System.getProperty("line.separator");
    private Writer writer;

    public boolean Init(String fileName)
    {
        try
        {
            // Path path = Paths.get("log.txt");
            // writer = new PrintWriter(Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND));
            writer = new PrintWriter(fileName);
        }
    catch (IOException FileNotFoundException)
    {
        System.out.format(FileNotFoundException.toString());
        return false;
    }

        return true;
    }

    public void ShutDown()
    {
        try
        {
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void Log(String msg)
    {
        //TODO: Check parameters
        LogFormat(LogLevelEnum.Debug, msg);
    }

    public  void Log(LogLevelEnum level, String msg, String fileName)
    {
        LogFormat(level, msg, fileName);
    }

    public <T> void Log(LogLevelEnum level, String msg, T ... parameters)
    {
        LogFormat(level,msg, parameters);
    }

    private <T> void LogFormat(LogLevelEnum level, String msg, T ... parameters)
    {
        try {
            String data = String.format("%s   [%s]-%s%s", getFormattedTime(), level, String.format(msg, parameters), newLine);
            writer.write(data);
            if(level==LogLevelEnum.Error)
                System.out.format(ANSI_RED + data + ANSI_RESET);
            else
                System.out.format(data);
        }
        catch (IOException ex)
        {
            System.out.format(ex.toString());
        }
    }

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")
                    .withLocale(Locale.ENGLISH)
                    .withZone(ZoneId.systemDefault());

  private  String getFormattedTime()
  {
        Instant date = Instant.now();
        return  formatter.format(date);
  }

}
