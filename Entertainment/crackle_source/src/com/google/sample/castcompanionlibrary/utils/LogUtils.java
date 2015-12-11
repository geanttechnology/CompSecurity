// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.utils;

import android.util.Log;

public class LogUtils
{

    private static final String LOG_PREFIX = "ccl_";
    private static final int LOG_PREFIX_LENGTH = "ccl_".length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    private LogUtils()
    {
    }

    public static void LOGD(String s, String s1)
    {
        if (Log.isLoggable(s, 3))
        {
            Log.d(s, s1);
        }
    }

    public static void LOGD(String s, String s1, Throwable throwable)
    {
        if (Log.isLoggable(s, 3))
        {
            Log.d(s, s1, throwable);
        }
    }

    public static void LOGE(String s, String s1)
    {
        Log.e(s, s1);
    }

    public static void LOGE(String s, String s1, Throwable throwable)
    {
        Log.e(s, s1, throwable);
    }

    public static void LOGI(String s, String s1)
    {
        Log.i(s, s1);
    }

    public static void LOGI(String s, String s1, Throwable throwable)
    {
        Log.i(s, s1, throwable);
    }

    public static void LOGV(String s, String s1)
    {
    }

    public static void LOGV(String s, String s1, Throwable throwable)
    {
    }

    public static void LOGW(String s, String s1)
    {
        Log.w(s, s1);
    }

    public static void LOGW(String s, String s1, Throwable throwable)
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
            return (new StringBuilder()).append("ccl_").append(s.substring(0, 23 - LOG_PREFIX_LENGTH - 1)).toString();
        } else
        {
            return (new StringBuilder()).append("ccl_").append(s).toString();
        }
    }

}
