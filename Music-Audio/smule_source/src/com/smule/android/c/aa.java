// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import android.util.Log;

public class aa
{

    public static int a(String s, String s1)
    {
        return Log.d(s, s1);
    }

    public static int a(String s, String s1, Throwable throwable)
    {
        return Log.d(s, s1, throwable);
    }

    public static int b(String s, String s1)
    {
        return Log.e(s, s1);
    }

    public static int b(String s, String s1, Throwable throwable)
    {
        return Log.e(s, s1, throwable);
    }

    public static int c(String s, String s1)
    {
        return Log.i(s, s1);
    }

    public static int c(String s, String s1, Throwable throwable)
    {
        return Log.i(s, s1, throwable);
    }

    public static int d(String s, String s1)
    {
        return Log.v(s, s1);
    }

    public static int d(String s, String s1, Throwable throwable)
    {
        return Log.w(s, s1, throwable);
    }

    public static int e(String s, String s1)
    {
        return Log.w(s, s1);
    }
}
