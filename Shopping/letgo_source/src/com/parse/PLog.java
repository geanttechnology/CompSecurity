// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.util.Log;

class PLog
{

    public static final int LOG_LEVEL_NONE = 0x7fffffff;
    private static int logLevel = 0x7fffffff;

    PLog()
    {
    }

    static void d(String s, String s1)
    {
        d(s, s1, null);
    }

    static void d(String s, String s1, Throwable throwable)
    {
        log(3, s, s1, throwable);
    }

    static void e(String s, String s1)
    {
        e(s, s1, null);
    }

    static void e(String s, String s1, Throwable throwable)
    {
        log(6, s, s1, throwable);
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    static void i(String s, String s1)
    {
        i(s, s1, null);
    }

    static void i(String s, String s1, Throwable throwable)
    {
        log(4, s, s1, throwable);
    }

    private static void log(int j, String s, String s1, Throwable throwable)
    {
label0:
        {
            if (j >= logLevel)
            {
                if (throwable != null)
                {
                    break label0;
                }
                Log.println(logLevel, s, s1);
            }
            return;
        }
        Log.println(logLevel, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    public static void setLogLevel(int j)
    {
        logLevel = j;
    }

    static void v(String s, String s1)
    {
        v(s, s1, null);
    }

    static void v(String s, String s1, Throwable throwable)
    {
        log(2, s, s1, throwable);
    }

    static void w(String s, String s1)
    {
        w(s, s1, null);
    }

    static void w(String s, String s1, Throwable throwable)
    {
        log(5, s, s1, throwable);
    }

}
