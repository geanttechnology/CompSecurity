// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Referenced classes of package tv.freewheel.hybrid.utils:
//            CommonUtil

public class Logger
{

    private static int logLevel = 2;
    protected boolean isAndroid;
    private Method logDebugMethod;
    private Method logErrorMethod;
    private Method logInfoMethod;
    private Method logVerboseMethod;
    private Method logWarnMethod;
    private String tag;
    private boolean textWithThreadIDAsPrefix;

    private Logger(String s)
    {
        logVerboseMethod = null;
        logDebugMethod = null;
        logInfoMethod = null;
        logWarnMethod = null;
        logErrorMethod = null;
        textWithThreadIDAsPrefix = false;
        isAndroid = false;
        tag = "FW-";
        tag = s;
        s = tv/freewheel/hybrid/utils/Logger.getClassLoader();
        Class aclass[];
        s = Class.forName("android.util.Log", true, s);
        aclass = new Class[2];
        aclass[0] = java/lang/String;
        aclass[1] = java/lang/String;
        try
        {
            logVerboseMethod = s.getMethod("v", aclass);
            logDebugMethod = s.getMethod("d", aclass);
            logInfoMethod = s.getMethod("i", aclass);
            logWarnMethod = s.getMethod("w", aclass);
            logErrorMethod = s.getMethod("e", aclass);
            isAndroid = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
    }

    private void doLoggerInvoke(Method method, String s, int i)
    {
        if (!isAndroid || i < logLevel)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (textWithThreadIDAsPrefix)
        {
            s = (new StringBuilder()).append(CommonUtil.currentThreadIdentifier()).append(s).toString();
        }
        method.invoke(null, new Object[] {
            tag, s
        });
        return;
        method;
    }

    private void doSystemOut(String s, String s1, int i)
    {
        if (!isAndroid && i >= logLevel)
        {
            PrintStream printstream = System.out;
            if (s.equals("error"))
            {
                printstream = System.err;
            }
            printstream.println((new StringBuilder()).append(now()).append(" ").append(s.toUpperCase()).append("/").append(tag).append(": ").append(s1).toString());
        }
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    public static Logger getLogger(Object obj)
    {
        return getLogger(obj, false);
    }

    public static Logger getLogger(Object obj, boolean flag)
    {
        return getLogger(obj.getClass().getSimpleName(), flag);
    }

    public static Logger getLogger(String s)
    {
        return getLogger(s, false);
    }

    public static Logger getLogger(String s, boolean flag)
    {
        s = new Logger(s);
        s.textWithThreadIDAsPrefix = flag;
        return s;
    }

    public static String now()
    {
        Calendar calendar = Calendar.getInstance();
        return (new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]")).format(calendar.getTime());
    }

    public static void setLogLevel(int i)
    {
        logLevel = i;
    }

    public void debug(String s)
    {
        doSystemOut("debug", s, 3);
        doLoggerInvoke(logDebugMethod, s, 3);
    }

    public void error(String s)
    {
        doSystemOut("error", s, 6);
        doLoggerInvoke(logErrorMethod, s, 6);
    }

    public void info(String s)
    {
        doSystemOut("info", s, 4);
        doLoggerInvoke(logInfoMethod, s, 4);
    }

    public void verbose(String s)
    {
        doSystemOut("verbose", s, 2);
        doLoggerInvoke(logVerboseMethod, s, 2);
    }

    public void warn(String s)
    {
        doSystemOut("warn", s, 5);
        doLoggerInvoke(logWarnMethod, s, 5);
    }

}
