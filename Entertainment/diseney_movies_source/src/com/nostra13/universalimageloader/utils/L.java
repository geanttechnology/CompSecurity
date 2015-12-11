// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.util.Log;

public final class L
{

    private static final String LOG_FORMAT = "%1$s\n%2$s";

    private L()
    {
    }

    public static transient void d(String s, Object aobj[])
    {
    }

    public static transient void e(String s, Object aobj[])
    {
    }

    public static void e(Throwable throwable)
    {
    }

    public static transient void e(Throwable throwable, String s, Object aobj[])
    {
    }

    public static transient void i(String s, Object aobj[])
    {
    }

    private static transient void log(int j, Throwable throwable, String s, Object aobj[])
    {
        String s1 = s;
        if (aobj.length > 0)
        {
            s1 = String.format(s, aobj);
        }
        if (throwable == null)
        {
            return;
        }
        if (s1 == null)
        {
            s = throwable.getMessage();
        } else
        {
            s = s1;
        }
        String.format("%1$s\n%2$s", new Object[] {
            s, Log.getStackTraceString(throwable)
        });
    }

    public static transient void w(String s, Object aobj[])
    {
    }
}
