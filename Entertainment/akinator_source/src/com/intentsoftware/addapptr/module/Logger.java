// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.module;

import android.util.Log;

public class Logger
{

    private static final String TAG = "AATKit";

    public Logger()
    {
    }

    public static int d(Object obj, String s)
    {
        return Log.d("AATKit", formatMessage(obj, s));
    }

    public static int d(Object obj, String s, Throwable throwable)
    {
        return Log.d("AATKit", formatMessage(obj, s), throwable);
    }

    public static int e(Object obj, String s)
    {
        return Log.e("AATKit", formatMessage(obj, s));
    }

    public static int e(Object obj, String s, Throwable throwable)
    {
        return Log.e("AATKit", formatMessage(obj, s), throwable);
    }

    private static String formatMessage(Object obj, String s)
    {
        if (obj != null)
        {
            if (obj instanceof String)
            {
                obj = (String)obj;
            } else
            if (obj instanceof Class)
            {
                obj = ((Class)obj).getSimpleName();
            } else
            {
                obj = obj.getClass().getSimpleName();
            }
        } else
        {
            obj = "Unknown";
        }
        return (new StringBuilder()).append(((String) (obj))).append(": ").append(s).toString();
    }

    public static int i(Object obj, String s)
    {
        return Log.i("AATKit", formatMessage(obj, s));
    }

    public static int i(Object obj, String s, Throwable throwable)
    {
        return Log.i("AATKit", formatMessage(obj, s), throwable);
    }

    public static boolean isLoggable(int j)
    {
        return Log.isLoggable("AATKit", j);
    }

    public static void log(Object obj, String s)
    {
        log(obj.getClass().getSimpleName(), s);
    }

    public static void log(String s, String s1)
    {
        Log.d("AATKit", (new StringBuilder()).append(s).append(": ").append(s1).toString());
    }

    public static int v(Object obj, String s)
    {
        return Log.v("AATKit", formatMessage(obj, s));
    }

    public static int v(Object obj, String s, Throwable throwable)
    {
        return Log.v("AATKit", formatMessage(obj, s), throwable);
    }

    public static int w(Object obj, String s)
    {
        return Log.w("AATKit", formatMessage(obj, s));
    }

    public static int w(Object obj, String s, Throwable throwable)
    {
        return Log.w("AATKit", formatMessage(obj, s), throwable);
    }

    public static int wtf(Object obj, String s)
    {
        return Log.wtf("AATKit", formatMessage(obj, s));
    }

    public static int wtf(Object obj, String s, Throwable throwable)
    {
        return Log.wtf("AATKit", formatMessage(obj, s), throwable);
    }
}
