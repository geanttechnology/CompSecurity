// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.util.Log;

public class AkLog
{

    public AkLog()
    {
    }

    public static void d(String s, String s1)
    {
        if ("release".equals("debug"))
        {
            Log.d(s, s1);
        }
    }

    public static void e(String s, String s1)
    {
        if ("release".equals("debug"))
        {
            Log.e(s, s1);
        }
    }

    public static void e(String s, String s1, Exception exception)
    {
        if ("release".equals("debug"))
        {
            Log.e(s, s1, exception);
        }
    }

    public static void i(String s, String s1)
    {
        if ("release".equals("debug"))
        {
            Log.i(s, s1);
        }
    }

    public static void v(String s, String s1)
    {
        if ("release".equals("debug"))
        {
            Log.v(s, s1);
        }
    }

    public static void w(String s, String s1)
    {
        if ("release".equals("debug"))
        {
            Log.w(s, s1);
        }
    }
}
