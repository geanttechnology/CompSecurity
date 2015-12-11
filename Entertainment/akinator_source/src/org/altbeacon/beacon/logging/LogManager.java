// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.logging;


// Referenced classes of package org.altbeacon.beacon.logging:
//            Loggers, Logger

public final class LogManager
{

    private static Logger sLogger = Loggers.warningLogger();
    private static boolean sVerboseLoggingEnabled = false;

    private LogManager()
    {
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        sLogger.d(s, s1, aobj);
    }

    public static transient void d(Throwable throwable, String s, String s1, Object aobj[])
    {
        sLogger.d(throwable, s, s1, aobj);
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        sLogger.e(s, s1, aobj);
    }

    public static transient void e(Throwable throwable, String s, String s1, Object aobj[])
    {
        sLogger.e(throwable, s, s1, aobj);
    }

    public static Logger getLogger()
    {
        return sLogger;
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        sLogger.i(s, s1, aobj);
    }

    public static transient void i(Throwable throwable, String s, String s1, Object aobj[])
    {
        sLogger.i(throwable, s, s1, aobj);
    }

    public static boolean isVerboseLoggingEnabled()
    {
        return sVerboseLoggingEnabled;
    }

    public static void setLogger(Logger logger)
    {
        if (logger == null)
        {
            throw new NullPointerException("Logger may not be null.");
        } else
        {
            sLogger = logger;
            return;
        }
    }

    public static void setVerboseLoggingEnabled(boolean flag)
    {
        sVerboseLoggingEnabled = flag;
    }

    public static transient void v(String s, String s1, Object aobj[])
    {
        sLogger.v(s, s1, aobj);
    }

    public static transient void v(Throwable throwable, String s, String s1, Object aobj[])
    {
        sLogger.v(throwable, s, s1, aobj);
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        sLogger.w(s, s1, aobj);
    }

    public static transient void w(Throwable throwable, String s, String s1, Object aobj[])
    {
        sLogger.w(throwable, s, s1, aobj);
    }

}
