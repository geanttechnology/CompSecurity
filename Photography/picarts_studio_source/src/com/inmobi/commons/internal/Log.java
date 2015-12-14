// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;

// Referenced classes of package com.inmobi.commons.internal:
//            CommonsConfig

public class Log
{

    private static INTERNAL_LOG_LEVEL a;

    public Log()
    {
    }

    public static void debug(String s, String s1)
    {
        if (a.getValue() < INTERNAL_LOG_LEVEL.DEBUG.getValue() && a == INTERNAL_LOG_LEVEL.NOT_SET)
        {
            CommonsConfig.getLogLevelConfig();
            INTERNAL_LOG_LEVEL.DEBUG.getValue();
        }
    }

    public static void debug(String s, String s1, Throwable throwable)
    {
        switch (_cls1.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            debug(s, s1);
            return;

        case 2: // '\002'
            internal(s, s1, throwable);
            break;
        }
    }

    public static INTERNAL_LOG_LEVEL getLogLevel()
    {
        return a;
    }

    public static INTERNAL_LOG_LEVEL getLogLevelValue(long l)
    {
        if (l == 2L)
        {
            return INTERNAL_LOG_LEVEL.INTERNAL;
        }
        if (l == 1L)
        {
            return INTERNAL_LOG_LEVEL.DEBUG;
        } else
        {
            return INTERNAL_LOG_LEVEL.NONE;
        }
    }

    public static void internal(String s, String s1)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
        {
            s = (new Throwable()).getStackTrace()[1];
            (new StringBuilder()).append(s.getFileName()).append(": ").append(s.getMethodName()).append(" ").append(s1);
        }
    }

    public static void internal(String s, String s1, Throwable throwable)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.INTERNAL.getValue())
        {
            StackTraceElement stacktraceelement = (new Throwable()).getStackTrace()[1];
            android.util.Log.e(s, (new StringBuilder()).append(stacktraceelement.getFileName()).append(": ").append(stacktraceelement.getMethodName()).append(" ").append(s1).toString(), throwable);
        }
    }

    public static void setInternalLogLevel(INTERNAL_LOG_LEVEL internal_log_level)
    {
        a = internal_log_level;
        if (internal_log_level == INTERNAL_LOG_LEVEL.INTERNAL)
        {
            BuildSettings.DEBUG = true;
        }
    }

    public static void verbose(String s, String s1)
    {
        if (a.getValue() >= INTERNAL_LOG_LEVEL.VERBOSE.getValue() || a == INTERNAL_LOG_LEVEL.NOT_SET && CommonsConfig.getLogLevelConfig() >= INTERNAL_LOG_LEVEL.VERBOSE.getValue())
        {
            android.util.Log.i(s, s1);
        }
    }

    public static void verbose(String s, String s1, Throwable throwable)
    {
        switch (_cls1.a[a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 3: // '\003'
            verbose(s, s1);
            return;

        case 2: // '\002'
            internal(s, s1, throwable);
            break;
        }
    }

    static 
    {
        a = INTERNAL_LOG_LEVEL.NOT_SET;
    }

    /* member class not found */
    class INTERNAL_LOG_LEVEL {}


    /* member class not found */
    class _cls1 {}

}
