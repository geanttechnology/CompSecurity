// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.j256.ormlite.logger:
//            Log, LoggerFactory

public class LocalLog
    implements Log
{

    private static final Log.Level DEFAULT_LEVEL;
    public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
    private static List classLevels;
    private static ThreadLocal dateFormatThreadLocal;
    private final String className;
    private final Log.Level level;
    private final PrintStream printStream;

    public LocalLog(String s)
    {
        className = LoggerFactory.getSimpleClassName(s);
        Object obj = null;
        if (classLevels != null)
        {
            Iterator iterator = classLevels.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                PatternLevel patternlevel = (PatternLevel)iterator.next();
                if (patternlevel.pattern.matcher(s).matches() && (obj == null || patternlevel.level.ordinal() < ((Log.Level) (obj)).ordinal()))
                {
                    obj = patternlevel.level;
                }
            } while (true);
            s = ((String) (obj));
        } else
        {
            s = null;
        }
        obj = s;
        if (s == null)
        {
            s = System.getProperty("com.j256.ormlite.logger.level");
            if (s == null)
            {
                obj = DEFAULT_LEVEL;
            } else
            {
                try
                {
                    obj = Log.Level.valueOf(s.toUpperCase());
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Level '").append(s).append("' was not found").toString(), illegalargumentexception);
                }
            }
        }
        level = ((Log.Level) (obj));
        s = System.getProperty("com.j256.ormlite.logger.file");
        if (s == null)
        {
            printStream = System.out;
            return;
        }
        try
        {
            printStream = new PrintStream(new File(s));
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Log file ").append(s).append(" was not found").toString(), filenotfoundexception);
        }
    }

    private static List configureClassLevels(InputStream inputstream)
    {
        ArrayList arraylist;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        arraylist = new ArrayList();
_L2:
        String as[];
        Object obj;
        do
        {
            obj = inputstream.readLine();
            if (obj == null)
            {
                return arraylist;
            }
        } while (((String) (obj)).length() == 0 || ((String) (obj)).charAt(0) == '#');
        as = ((String) (obj)).split("=");
        if (as.length != 2)
        {
            System.err.println((new StringBuilder()).append("Line is not in the format of 'pattern = level': ").append(((String) (obj))).toString());
            continue; /* Loop/switch isn't completed */
        }
        obj = Pattern.compile(as[0].trim());
        Log.Level level1 = Log.Level.valueOf(as[1].trim());
        arraylist.add(new PatternLevel(((Pattern) (obj)), level1));
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        System.err.println((new StringBuilder()).append("Level '").append(as[1]).append("' was not found").toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void printMessage(Log.Level level1, String s, Throwable throwable)
    {
        if (isLevelEnabled(level1))
        {
            StringBuilder stringbuilder = new StringBuilder(128);
            DateFormat dateformat = (DateFormat)dateFormatThreadLocal.get();
            Object obj = dateformat;
            if (dateformat == null)
            {
                obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
                dateFormatThreadLocal.set(obj);
            }
            stringbuilder.append(((DateFormat) (obj)).format(new Date()));
            stringbuilder.append(" [").append(level1.name()).append("] ");
            stringbuilder.append(className).append(' ');
            stringbuilder.append(s);
            printStream.println(stringbuilder.toString());
            if (throwable != null)
            {
                throwable.printStackTrace(printStream);
                return;
            }
        }
    }

    void flush()
    {
        printStream.flush();
    }

    public boolean isLevelEnabled(Log.Level level1)
    {
        return level.isEnabled(level1);
    }

    public void log(Log.Level level1, String s)
    {
        printMessage(level1, s, null);
    }

    public void log(Log.Level level1, String s, Throwable throwable)
    {
        printMessage(level1, s, throwable);
    }

    static 
    {
        Object obj;
        DEFAULT_LEVEL = Log.Level.DEBUG;
        dateFormatThreadLocal = new ThreadLocal();
        obj = com/j256/ormlite/logger/LocalLog.getResourceAsStream("/ormliteLocalLog.properties");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        classLevels = configureClassLevels(((InputStream) (obj)));
        ((InputStream) (obj)).close();
        return;
        Object obj1;
        obj1;
        System.err.println((new StringBuilder()).append("IO exception reading the log properties file '/ormliteLocalLog.properties': ").append(obj1).toString());
        try
        {
            ((InputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj1;
        IOException ioexception;
        try
        {
            ((InputStream) (obj)).close();
        }
        catch (IOException ioexception1) { }
        throw obj1;
        ioexception;
    }

    private class PatternLevel
    {

        Log.Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern1, Log.Level level1)
        {
            pattern = pattern1;
            level = level1;
        }
    }

}
