// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import android.util.Log;

public class MMLog
{

    private static final String TAG_PREFIX = "MMSDK-";
    public static int logLevel = 4;

    public MMLog()
    {
    }

    public static void d(String s, String s1)
    {
        if (logLevel <= 3)
        {
            dInternal(s, s1);
        }
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        if (logLevel <= 3)
        {
            dInternal(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    private static void dInternal(String s, String s1)
    {
        Log.d(getFullTag(s), s1);
    }

    public static void e(String s, String s1)
    {
        if (logLevel <= 6)
        {
            eInternal(s, s1);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (logLevel <= 6)
        {
            eInternal(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    private static void eInternal(String s, String s1)
    {
        Log.e(getFullTag(s), s1);
    }

    private static String getFullTag(String s)
    {
        return (new StringBuilder()).append("MMSDK-").append(s).append(" <").append(Thread.currentThread().getId()).append(":").append(System.currentTimeMillis()).append(">").toString();
    }

    public static void i(String s, String s1)
    {
        if (logLevel <= 4)
        {
            iInternal(s, s1);
        }
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        if (logLevel <= 4)
        {
            iInternal(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    private static void iInternal(String s, String s1)
    {
        Log.i(getFullTag(s), s1);
    }

    public static boolean isDebugEnabled()
    {
        return logLevel <= 3;
    }

    public static boolean isVerboseEnabled()
    {
        return logLevel <= 2;
    }

    public static void setLogLevel(int j)
    {
        logLevel = j;
    }

    public static void v(String s, String s1)
    {
        if (logLevel <= 2)
        {
            vInternal(s, s1);
        }
    }

    public static void v(String s, String s1, Throwable throwable)
    {
        if (logLevel <= 2)
        {
            vInternal(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    private static void vInternal(String s, String s1)
    {
        Log.v(getFullTag(s), s1);
    }

    public static void w(String s, String s1)
    {
        if (logLevel <= 5)
        {
            wInternal(s, s1);
        }
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        if (logLevel <= 5)
        {
            wInternal(s, (new StringBuilder()).append(s1).append(": ").append(Log.getStackTraceString(throwable)).toString());
        }
    }

    private static void wInternal(String s, String s1)
    {
        Log.w(getFullTag(s), s1);
    }

}
