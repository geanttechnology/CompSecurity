// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.util.Log;
import com.crashlytics.android.Crashlytics;

public final class m
{

    public static boolean a = false;
    public static int b = 2;

    public static int a(int i, String s, String s1)
    {
        if (i < b)
        {
            return 0;
        }
        if (a)
        {
            Crashlytics.log(i, s, s1);
            return 0;
        } else
        {
            return Log.println(i, s, s1);
        }
    }

    public static int a(String s, String s1)
    {
        return a(2, s, s1);
    }

    public static int a(String s, String s1, Throwable throwable)
    {
        return a(5, s, (new StringBuilder()).append(s1).append('\n').append(a(throwable)).toString());
    }

    public static String a(Throwable throwable)
    {
        return Log.getStackTraceString(throwable);
    }

    public static int b(String s, String s1)
    {
        return a(3, s, s1);
    }

    public static int b(String s, String s1, Throwable throwable)
    {
        return a(6, s, (new StringBuilder()).append(s1).append('\n').append(a(throwable)).toString());
    }

    public static int c(String s, String s1)
    {
        return a(4, s, s1);
    }

    public static int d(String s, String s1)
    {
        return a(5, s, s1);
    }

    public static int e(String s, String s1)
    {
        return a(6, s, s1);
    }

}
