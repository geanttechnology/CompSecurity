// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.log;

import android.util.Log;

public class AppLog
{

    private static int logLevel = 6;

    public AppLog()
    {
    }

    private static boolean doLog(String s, int i)
    {
        return isLoggable(s, i);
    }

    public static boolean isLoggable(String s, int i)
    {
        if (logLevel != -1)
        {
            return i >= logLevel;
        } else
        {
            return Log.isLoggable(s, i);
        }
    }

    public static int v(String s, String s1)
    {
        if (doLog(s, 2))
        {
            return Log.v(s, s1);
        } else
        {
            return -1;
        }
    }

}
