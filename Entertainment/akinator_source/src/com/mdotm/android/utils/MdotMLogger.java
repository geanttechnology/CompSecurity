// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.utils;

import android.util.Log;

public class MdotMLogger
{

    private static final String TAG = "MdotM";

    public MdotMLogger()
    {
    }

    public static void d(Object obj, String s)
    {
    }

    public static void debug(Object obj, String s)
    {
    }

    public static void e(Object obj, String s)
    {
        Log.e("MdotM", (new StringBuilder(String.valueOf(obj.getClass().getSimpleName()))).append(": ").append(s).toString());
    }

    public static void e(Object obj, String s, Exception exception)
    {
        Log.e("MdotM", (new StringBuilder(String.valueOf(obj.getClass().getSimpleName()))).append(": ").append(s).toString(), exception);
    }

    public static void error(Object obj, String s)
    {
        Log.e("MdotM", (new StringBuilder(String.valueOf(obj.getClass().getSimpleName()))).append(": ").append(s).toString());
    }

    public static void i(Object obj, String s)
    {
    }

    public static void time(Object obj, String s)
    {
    }

    public static void w(Object obj, String s)
    {
    }
}
