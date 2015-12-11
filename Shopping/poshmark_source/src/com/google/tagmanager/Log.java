// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            DefaultLogger, Logger, NoOpLogger

final class Log
{

    static Logger sLogger = new DefaultLogger();

    Log()
    {
    }

    public static void d(String s)
    {
        sLogger.d(s);
    }

    public static void d(String s, Throwable throwable)
    {
        sLogger.d(s, throwable);
    }

    public static void e(String s)
    {
        sLogger.e(s);
    }

    public static void e(String s, Throwable throwable)
    {
        sLogger.e(s, throwable);
    }

    public static Logger.LogLevel getLogLevel()
    {
        return sLogger.getLogLevel();
    }

    public static Logger getLogger()
    {
        if (sLogger.getClass() == com/google/tagmanager/NoOpLogger)
        {
            return null;
        } else
        {
            return sLogger;
        }
    }

    public static void i(String s)
    {
        sLogger.i(s);
    }

    public static void i(String s, Throwable throwable)
    {
        sLogger.i(s, throwable);
    }

    public static void setLogger(Logger logger)
    {
        if (logger == null)
        {
            sLogger = new NoOpLogger();
            return;
        } else
        {
            sLogger = logger;
            return;
        }
    }

    public static void v(String s)
    {
        sLogger.v(s);
    }

    public static void v(String s, Throwable throwable)
    {
        sLogger.v(s, throwable);
    }

    public static void w(String s)
    {
        sLogger.w(s);
    }

    public static void w(String s, Throwable throwable)
    {
        sLogger.w(s, throwable);
    }

}
