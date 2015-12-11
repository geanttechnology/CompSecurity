// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal.utils;

import android.util.Log;

public final class LogUtils
{

    private static final String LOG_PREFIX = "PI_";
    private static final int LOG_PREFIX_LENGTH = "PI_".length();
    private static final int MAX_LOG_TAG_LENGTH = 23;
    private static final String TAG_IO = "PI_IO";

    public LogUtils()
    {
    }

    public static void logD(String s, String s1)
    {
        if (Log.isLoggable(s, 3))
        {
            Log.d(s, s1);
        }
    }

    public static void logD(String s, String s1, String s2)
    {
        if (Log.isLoggable(s, 3))
        {
            Log.d(s1, s2);
        }
    }

    public static void logD(String s, String s1, Throwable throwable)
    {
        if (Log.isLoggable(s, 3))
        {
            Log.d(s, s1, throwable);
        }
    }

    public static void logDebugIO(String s)
    {
        logD("PI_IO", s);
    }

    public static void logE(String s, String s1)
    {
        Log.e(s, s1);
    }

    public static void logE(String s, String s1, Throwable throwable)
    {
        Log.e(s, s1, throwable);
    }

    public static void logI(String s, String s1)
    {
        Log.i(s, s1);
    }

    public static void logI(String s, String s1, Throwable throwable)
    {
        Log.i(s, s1, throwable);
    }

    public static void logV(String s, String s1)
    {
        if (Log.isLoggable(s, 2))
        {
            Log.v(s, s1);
        }
    }

    public static void logV(String s, String s1, Throwable throwable)
    {
        if (Log.isLoggable(s, 2))
        {
            Log.v(s, s1, throwable);
        }
    }

    public static void logW(String s, String s1)
    {
        Log.w(s, s1);
    }

    public static void logW(String s, String s1, Throwable throwable)
    {
        Log.w(s, s1, throwable);
    }

    public static String makeLogTag(Class class1)
    {
        return makeLogTag(class1.getSimpleName());
    }

    public static String makeLogTag(String s)
    {
        if (s.length() > 23 - LOG_PREFIX_LENGTH)
        {
            return (new StringBuilder()).append("PI_").append(s.substring(0, 23 - LOG_PREFIX_LENGTH - 1)).toString();
        } else
        {
            return (new StringBuilder()).append("PI_").append(s).toString();
        }
    }

}
