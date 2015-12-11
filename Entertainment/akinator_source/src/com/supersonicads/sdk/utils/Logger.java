// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.util.Log;

public class Logger
{

    private static boolean enableLogging;

    public Logger()
    {
    }

    public static void d(String s, String s1)
    {
        if (enableLogging)
        {
            Log.d(s, s1);
        }
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        if (enableLogging)
        {
            Log.d(s, s1, throwable);
        }
    }

    public static void e(String s, String s1)
    {
        if (enableLogging)
        {
            Log.e(s, s1);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (enableLogging)
        {
            Log.e(s, s1, throwable);
        }
    }

    public static void enableLogging(int j)
    {
        if (com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_0.getValue() == j)
        {
            enableLogging = false;
            return;
        } else
        {
            enableLogging = true;
            return;
        }
    }

    public static void i(String s, String s1)
    {
        if (enableLogging)
        {
            Log.i(s, s1);
        }
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        if (enableLogging)
        {
            Log.i(s, s1, throwable);
        }
    }

    public static void v(String s, String s1)
    {
        if (enableLogging)
        {
            Log.v(s, s1);
        }
    }

    public static void v(String s, String s1, Throwable throwable)
    {
        if (enableLogging)
        {
            Log.v(s, s1, throwable);
        }
    }

    public static void w(String s, String s1)
    {
        if (enableLogging)
        {
            Log.w(s, s1);
        }
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        if (enableLogging)
        {
            Log.w(s, s1, throwable);
        }
    }
}
